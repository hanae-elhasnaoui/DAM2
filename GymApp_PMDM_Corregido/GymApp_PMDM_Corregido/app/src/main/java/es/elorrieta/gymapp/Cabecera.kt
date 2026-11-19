package es.elorrieta.gymapp
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import es.elorrieta.gymapp.bd.GymDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
fun Fragment.mostrarCabecera(v:View,titulo:String) {
    v.findViewById<TextView>(R.id.tvCabecera)?.text=titulo
    viewLifecycleOwner.lifecycleScope.launch {
        val usuario=withContext(Dispatchers.IO) {
            GymDatabase(requireContext()).getUsuarioDao().getById(Sesion.usuarioId)
        }
        v.findViewById<TextView>(R.id.tvNivel)?.text="Nivel ${usuario?.nivel ?: 0}"
    }
}
