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
class FragmentDetalleEjercicio:Fragment() {
    override fun onCreateView(inflater:LayoutInflater,container:ViewGroup?,state:Bundle?):View =
        inflater.inflate(R.layout.fragment_detalle_ejercicio,container,false)
    override fun onViewCreated(v:View,state:Bundle?) {
        mostrarCabecera(v,getString(R.string.ejercicios))
        val db=GymDatabase(requireContext())
        v.findViewById<Button>(R.id.btnVolver).setOnClickListener { parentFragmentManager.popBackStack() }
        viewLifecycleOwner.lifecycleScope.launch {
            val datos=withContext(Dispatchers.IO) {
                val e=db.getEjercicioDao().getById(Sesion.ejercicioId)
                val w=e?.let { db.getWorkoutDao().getById(it.workoutId) }
                Pair(e,w)
            }
            v.findViewById<LinearLayout>(R.id.contenido).addView(TextView(requireContext()).apply {
                text="${datos.first?.nombre}\n${datos.first?.descripcion ?: ""}\nWorkout: ${datos.second?.nombre ?: ""}"
            })
        }
        fun cambiar(completar:Boolean) {
            viewLifecycleOwner.lifecycleScope.launch {
                withContext(Dispatchers.IO) { Progreso.ejercicio(db,Sesion.usuarioId,Sesion.ejercicioId,completar) }
                Toast.makeText(requireContext(),"Progreso actualizado",Toast.LENGTH_SHORT).show()
            }
        }
        v.findViewById<Button>(R.id.btnCompletar).setOnClickListener { cambiar(true) }
        v.findViewById<Button>(R.id.btnDesmarcar).setOnClickListener { cambiar(false) }
    }
}
