package es.elorrieta.gymapp
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import es.elorrieta.gymapp.bd.GymDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
class FragmentEjercicios:Fragment() {
    override fun onCreateView(inflater:LayoutInflater,container:ViewGroup?,state:Bundle?):View =
        inflater.inflate(R.layout.fragment_ejercicios,container,false)
    override fun onViewCreated(v:View,state:Bundle?) {
        mostrarCabecera(v,getString(R.string.ejercicios))
        val db=GymDatabase(requireContext())
        v.findViewById<Button>(R.id.btnVolver).setOnClickListener { parentFragmentManager.popBackStack() }
        v.findViewById<Button>(R.id.btnFiltrar).setOnClickListener { cargar(v) }
        v.findViewById<Button>(R.id.btnCompletar).setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                withContext(Dispatchers.IO){Progreso.workout(db,Sesion.usuarioId,Sesion.workoutId,true)}
                cargar(v)
            }
        }
        v.findViewById<Button>(R.id.btnDesmarcar).setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                withContext(Dispatchers.IO){Progreso.workout(db,Sesion.usuarioId,Sesion.workoutId,false)}
                cargar(v)
            }
        }
        cargar(v)
    }
    override fun onResume() {
        super.onResume()
        view?.let { cargar(it) }
    }
    private fun cargar(v:View) {
        val db=GymDatabase(requireContext())
        val filtro=v.findViewById<EditText>(R.id.etFiltro).text.toString()
        viewLifecycleOwner.lifecycleScope.launch {
            val datos=withContext(Dispatchers.IO) {
                db.getEjercicioDao().getByWorkout(Sesion.workoutId)
                    .filter { it.nombre.contains(filtro,true) }
                    .map { Pair(it,db.getEjercicioCompletadoDao().contar(Sesion.usuarioId,it.id)>0) }
            }
            val rv=v.findViewById<RecyclerView>(R.id.rvLista)
            rv.layoutManager=LinearLayoutManager(requireContext())
            rv.adapter=EjercicioAdapter(datos) { e ->
                Sesion.ejercicioId=e.id
                irA(FragmentDetalleEjercicio())
            }
        }
    }
}
