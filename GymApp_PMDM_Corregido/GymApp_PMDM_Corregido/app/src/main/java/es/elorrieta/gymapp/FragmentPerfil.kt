package es.elorrieta.gymapp
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import android.graphics.BitmapFactory
import android.util.Patterns
import androidx.activity.result.contract.ActivityResultContracts
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import es.elorrieta.gymapp.bd.GymDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
class FragmentPerfil:Fragment() {
    private val permisoCamara=registerForActivityResult(ActivityResultContracts.RequestPermission()) { concedido ->
        if(concedido) camara.launch(null)
        else android.widget.Toast.makeText(requireContext(),
            "Permiso de cámara denegado",android.widget.Toast.LENGTH_SHORT).show()
    }
    private fun abrirCamara() {
        if(ContextCompat.checkSelfPermission(requireContext(),Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED)
            camara.launch(null)
        else permisoCamara.launch(Manifest.permission.CAMERA)
    }
    private var nuevaFoto:ByteArray?=null
    private val camara=registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { imagen ->
        if(imagen!=null) {
            nuevaFoto=fotoBytes(imagen)
            view?.findViewById<android.widget.ImageView>(R.id.ivFoto)?.setImageBitmap(imagen)
        }
    }
    override fun onCreateView(inflater:LayoutInflater,container:ViewGroup?,state:Bundle?):View =
        inflater.inflate(R.layout.fragment_perfil,container,false)
    override fun onViewCreated(v:View,state:Bundle?) {
        val db=GymDatabase(requireContext())
        val preferencias=requireContext().getSharedPreferences("ajustes",0)
        val tema=v.findViewById<Switch>(R.id.swTema)
        tema.isChecked=preferencias.getBoolean("oscuro",false)
        tema.setOnCheckedChangeListener { _, oscuro ->
            preferencias.edit().putBoolean("oscuro",oscuro).apply()
            AppCompatDelegate.setDefaultNightMode(
                if(oscuro) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
            )
        }
        val idioma=v.findViewById<RadioGroup>(R.id.rgIdioma)
        idioma.check(if(preferencias.getString("idioma","es")=="en") R.id.rbEn else R.id.rbEs)
        idioma.setOnCheckedChangeListener { _, id ->
            val codigo=if(id==R.id.rbEn) "en" else "es"
            preferencias.edit().putString("idioma",codigo).apply()
            AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(codigo))
        }
        v.findViewById<Button>(R.id.btnFoto).setOnClickListener { abrirCamara() }
        fun edit(id:Int)=v.findViewById<EditText>(id)
        v.findViewById<Button>(R.id.btnVolver).setOnClickListener { parentFragmentManager.popBackStack() }
        viewLifecycleOwner.lifecycleScope.launch {
            val usuario=withContext(Dispatchers.IO){db.getUsuarioDao().getById(Sesion.usuarioId)}
            if(usuario!=null) {
                usuario.foto?.let { bytes ->
                    v.findViewById<android.widget.ImageView>(R.id.ivFoto)
                        .setImageBitmap(BitmapFactory.decodeByteArray(bytes,0,bytes.size))
                }
                edit(R.id.etNombre).setText(usuario.nombre)
                edit(R.id.etApellidos).setText(usuario.apellidos)
                edit(R.id.etEmail).setText(usuario.email)
                edit(R.id.etFecha).setText(usuario.fechaNacimiento)
                v.findViewById<Button>(R.id.btnGuardar).setOnClickListener {
                    val nombreNuevo=edit(R.id.etNombre).text.toString().trim()
                    val apellidoNuevo=edit(R.id.etApellidos).text.toString().trim()
                    val emailNuevo=edit(R.id.etEmail).text.toString().trim()
                    val fechaNueva=edit(R.id.etFecha).text.toString().trim()
                    if(nombreNuevo.isBlank() || apellidoNuevo.isBlank() || fechaNueva.isBlank() ||
                        !Patterns.EMAIL_ADDRESS.matcher(emailNuevo).matches()) {
                        Toast.makeText(requireContext(),"Revisa los datos del perfil",Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                    usuario.nombre=nombreNuevo
                    usuario.apellidos=apellidoNuevo
                    usuario.email=emailNuevo
                    usuario.fechaNacimiento=fechaNueva
                    nuevaFoto?.let { usuario.foto=it }
                    val nueva=edit(R.id.etPassword).text.toString()
                    if(nueva.isNotBlank()) usuario.pass=nueva
                    viewLifecycleOwner.lifecycleScope.launch {
                        withContext(Dispatchers.IO){db.getUsuarioDao().update(usuario)}
                        Toast.makeText(requireContext(),"Perfil guardado",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
