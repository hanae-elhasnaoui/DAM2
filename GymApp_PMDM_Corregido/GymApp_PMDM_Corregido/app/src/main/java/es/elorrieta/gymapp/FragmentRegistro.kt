package es.elorrieta.gymapp
import android.os.Bundle
import android.app.DatePickerDialog
import androidx.activity.result.contract.ActivityResultContracts
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import java.util.Calendar
import android.util.Patterns
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import es.elorrieta.gymapp.bd.GymDatabase
import es.elorrieta.gymapp.bd.entidades.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
class FragmentRegistro: Fragment() {
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
    private var foto:ByteArray?=null
    private val camara=registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { imagen ->
        if(imagen!=null) {
            foto=fotoBytes(imagen)
            view?.findViewById<android.widget.ImageView>(R.id.ivFoto)?.setImageBitmap(imagen)
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?): View =
        inflater.inflate(R.layout.fragment_registro,container,false)
    override fun onViewCreated(v: View,state: Bundle?) {
        v.findViewById<EditText>(R.id.etFecha).apply {
            inputType=0
            isFocusable=false
            setOnClickListener {
                val hoy=Calendar.getInstance()
                DatePickerDialog(requireContext(), { _, anio, mes, dia ->
                    setText("%02d/%02d/%04d".format(dia,mes+1,anio))
                },hoy.get(Calendar.YEAR),hoy.get(Calendar.MONTH),hoy.get(Calendar.DAY_OF_MONTH)).apply { datePicker.maxDate=System.currentTimeMillis() }.show()
            }
        }
        v.findViewById<Button>(R.id.btnFoto).setOnClickListener { abrirCamara() }
        fun campo(id:Int)=v.findViewById<EditText>(id).text.toString().trim()
        v.findViewById<Button>(R.id.btnVolver).setOnClickListener { parentFragmentManager.popBackStack() }
        v.findViewById<Button>(R.id.btnRegistrar).setOnClickListener {
            val login=campo(R.id.etLogin)
            val pass=campo(R.id.etPassword)
            val nombre=campo(R.id.etNombre)
            val apellidos=campo(R.id.etApellidos)
            val email=campo(R.id.etEmail)
            val fecha=campo(R.id.etFecha)
            val tipo=if(v.findViewById<RadioGroup>(R.id.rgRol).checkedRadioButtonId==R.id.rbEntrenador) "entrenador" else "cliente"
            if(listOf(login,pass,nombre,apellidos,email,fecha).any { it.isBlank() }) {
                Toast.makeText(requireContext(),"Rellena todos los campos",Toast.LENGTH_SHORT).show()
            } else if(!fecha.matches(Regex("\\d{2}/\\d{2}/\\d{4}"))) {
                Toast.makeText(requireContext(),"Fecha no válida",Toast.LENGTH_SHORT).show()
            } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(requireContext(),"Email incorrecto",Toast.LENGTH_SHORT).show()
            } else {
                viewLifecycleOwner.lifecycleScope.launch {
                    val db=GymDatabase(requireContext())
                    val resultado=withContext(Dispatchers.IO) {
                        val dao=db.getUsuarioDao()
                        if(dao.getByLogin(login)!=null) false
                        else try {
                            dao.insert(Usuario(login=login,pass=pass,nombre=nombre,apellidos=apellidos,email=email,fechaNacimiento=fecha,tipo=tipo,foto=foto))
                            true
                        } catch(e:Exception) { false }
                    }
                    Toast.makeText(requireContext(),if(resultado) "Usuario registrado" else "Login duplicado o error al guardar",Toast.LENGTH_SHORT).show()
                    if(resultado) parentFragmentManager.popBackStack()
                }
            }
        }
    }
}
