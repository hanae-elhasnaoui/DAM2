package es.elorrieta.gymapp
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import es.elorrieta.gymapp.bd.GymDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
class FragmentLogin: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?): View =
        inflater.inflate(R.layout.fragment_login, container, false)
    override fun onViewCreated(v: View, state: Bundle?) {
        val login=v.findViewById<EditText>(R.id.etLogin)
        val pass=v.findViewById<EditText>(R.id.etPassword)
        val recordar=v.findViewById<CheckBox>(R.id.cbRecordar)
        val roles=v.findViewById<RadioGroup>(R.id.rgRolLogin)
        val preferencias=requireContext().getSharedPreferences("login",0)
        recordar.isChecked=preferencias.getBoolean("recordar",false)
        if(recordar.isChecked) {
            login.setText(preferencias.getString("usuario",""))
            pass.setText(preferencias.getString("clave",""))
            roles.check(if(preferencias.getString("rol","cliente")=="entrenador") R.id.rbEntrenadorLogin else R.id.rbClienteLogin)
        }
        recordar.setOnCheckedChangeListener { _, marcado ->
            if(!marcado) {
                preferencias.edit().clear().apply()
                login.text.clear()
                pass.text.clear()
            }
        }
        v.findViewById<Button>(R.id.btnRegistro).setOnClickListener { irA(FragmentRegistro()) }
        v.findViewById<Button>(R.id.btnLogin).setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                val tipo=if(roles.checkedRadioButtonId==R.id.rbEntrenadorLogin) "entrenador" else "cliente"
                val usuario=withContext(Dispatchers.IO) {
                    val dao=GymDatabase(requireContext()).getUsuarioDao()
                    dao.login(login.text.toString().trim(),pass.text.toString(),tipo)
                }
                if(usuario==null) {
                    Toast.makeText(requireContext(),"Usuario o contraseña incorrectos",Toast.LENGTH_SHORT).show()
                } else {
                    if(recordar.isChecked) {
                        preferencias.edit().putBoolean("recordar",true)
                            .putString("usuario",login.text.toString())
                            .putString("clave",pass.text.toString()).putString("rol",tipo).apply()
                    }
                    Sesion.usuarioId=usuario.id
                    irA(if(usuario.tipo=="entrenador") FragmentEntrenador() else FragmentWorkouts())
                }
            }
        }
    }
}
