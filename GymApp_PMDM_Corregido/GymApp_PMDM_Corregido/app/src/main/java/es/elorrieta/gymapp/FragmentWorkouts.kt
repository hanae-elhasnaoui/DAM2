package es.elorrieta.gymapp
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.content.Intent
import android.net.Uri
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import es.elorrieta.gymapp.bd.GymDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
class FragmentWorkouts:Fragment() {
    override fun onCreateView(inflater:LayoutInflater,container:ViewGroup?,state:Bundle?):View =
        inflater.inflate(R.layout.fragment_workouts,container,false)
    override fun onViewCreated(v:View,state:Bundle?) {
        mostrarCabecera(v,getString(R.string.workouts))
        v.findViewById<Button>(R.id.btnPerfil).setOnClickListener { irA(FragmentPerfil()) }
        v.findViewById<Button>(R.id.btnSalir).setOnClickListener { Sesion.usuarioId=0; irA(FragmentLogin()) }
        v.findViewById<Button>(R.id.btnFiltrar).setOnClickListener { cargar(v) }
        cargar(v)
    }
    override fun onResume() {
        super.onResume()
        view?.let { cargar(it) }
    }
    private fun cargar(v:View) {
        val db=GymDatabase(requireContext())
        val nivel=v.findViewById<EditText>(R.id.etFiltro).text.toString().toIntOrNull()
        viewLifecycleOwner.lifecycleScope.launch {
            val datos=withContext(Dispatchers.IO) {
                val workouts=if(nivel==null) db.getWorkoutDao().getAll() else db.getWorkoutDao().getByNivel(nivel)
                workouts.map { w ->
                    val total=db.getEjercicioDao().contarDeWorkout(w.id)
                    val hechos=db.getEjercicioCompletadoDao().contarDeWorkout(Sesion.usuarioId,w.id)
                    Triple(w,total,hechos)
                }
            }
            val rv=v.findViewById<RecyclerView>(R.id.rvLista)
            rv.layoutManager=LinearLayoutManager(requireContext())
            rv.adapter=WorkoutAdapter(datos,
                { w -> Sesion.workoutId=w.id; irA(FragmentEjercicios()) },
                { w -> w.video?.let { startActivity(Intent(Intent.ACTION_VIEW,Uri.parse(it))) } })
        }
    }
}
