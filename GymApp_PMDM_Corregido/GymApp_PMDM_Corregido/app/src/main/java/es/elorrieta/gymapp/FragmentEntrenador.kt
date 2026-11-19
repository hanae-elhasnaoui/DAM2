package es.elorrieta.gymapp
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import es.elorrieta.gymapp.bd.GymDatabase
import es.elorrieta.gymapp.bd.entidades.Workout
import es.elorrieta.gymapp.bd.entidades.Ejercicio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
class FragmentEntrenador:Fragment() {
    override fun onCreateView(inflater:LayoutInflater,container:ViewGroup?,state:Bundle?):View =
        inflater.inflate(R.layout.fragment_entrenador,container,false)
    override fun onViewCreated(v:View,state:Bundle?) {
        mostrarCabecera(v,getString(R.string.entrenador))
        v.findViewById<Button>(R.id.btnPerfil).setOnClickListener { irA(FragmentPerfil()) }
        v.findViewById<Button>(R.id.btnSalir).setOnClickListener { Sesion.usuarioId=0; irA(FragmentLogin()) }
        fun entrada(id:Int)=v.findViewById<EditText>(id).text.toString().trim()
        v.findViewById<Button>(R.id.btnCrearEjercicio).setOnClickListener {
            val wid=entrada(R.id.etWorkoutId).toLongOrNull()
            val orden=entrada(R.id.etEjercicioOrden).toIntOrNull()
            val tiempo=entrada(R.id.etEjercicioTiempo).toIntOrNull()
            val nombre=entrada(R.id.etEjercicioNombre)
            val tipo=entrada(R.id.etEjercicioTipo)
            val descripcion=entrada(R.id.etEjercicioDescripcion)
            if(wid==null || orden==null || orden<1 || tiempo==null || tiempo<0 || nombre.isBlank()) {
                Toast.makeText(requireContext(),"Faltan datos del ejercicio",Toast.LENGTH_SHORT).show()
            } else viewLifecycleOwner.lifecycleScope.launch {
                val ok=withContext(Dispatchers.IO) {
                    val db=GymDatabase(requireContext())
                    if(db.getWorkoutDao().getById(wid)==null) false
                    else {
                        db.getEjercicioDao().insert(Ejercicio(workoutId=wid,orden=orden,
                            nombre=nombre,tipo=tipo,
                            descripcion=descripcion,tiempoEstimado=tiempo))
                        true
                    }
                }
                Toast.makeText(requireContext(),if(ok) "Ejercicio creado" else "Workout no existe",Toast.LENGTH_SHORT).show()
            }
        }
        v.findViewById<Button>(R.id.btnVerEjercicios).setOnClickListener {
            val wid=entrada(R.id.etWorkoutId).toLongOrNull()
            if(wid!=null) listarEjercicios(v,wid)
        }
        v.findViewById<Button>(R.id.btnListar).setOnClickListener { cargar(v) }
        v.findViewById<Button>(R.id.btnCrear).setOnClickListener {
            val nombre=v.findViewById<EditText>(R.id.etNombre).text.toString()
            val nivel=v.findViewById<EditText>(R.id.etNivel).text.toString().toIntOrNull()
            if(nombre.isBlank() || nivel==null || nivel<0) {
                Toast.makeText(requireContext(),"Introduce nombre y nivel",Toast.LENGTH_SHORT).show()
            } else viewLifecycleOwner.lifecycleScope.launch {
                withContext(Dispatchers.IO){GymDatabase(requireContext()).getWorkoutDao().insert(Workout(nombre=nombre,nivel=nivel,video=entrada(R.id.etVideo).ifBlank { null }))}
                cargar(v)
            }
        }
        cargar(v)
    }
    private fun cargar(v:View) {
        val db=GymDatabase(requireContext())
        viewLifecycleOwner.lifecycleScope.launch {
            val datos=withContext(Dispatchers.IO){db.getWorkoutDao().getAll()}
            val cont=v.findViewById<LinearLayout>(R.id.contenido)
            cont.removeAllViews()
            datos.forEach { w ->
                cont.addView(TextView(requireContext()).apply { text="${w.nombre} · nivel ${w.nivel}" })
                cont.addView(Button(requireContext()).apply {
                    text="Editar ${w.nombre}"
                    setOnClickListener {
                        val nuevoNombre=v.findViewById<EditText>(R.id.etNombre).text.toString().trim()
                        val nuevoNivel=v.findViewById<EditText>(R.id.etNivel).text.toString().toIntOrNull()
                        if(nuevoNombre.isBlank() || nuevoNivel==null || nuevoNivel<0) {
                            Toast.makeText(requireContext(),"Introduce nombre y nivel válidos",Toast.LENGTH_SHORT).show()
                        } else viewLifecycleOwner.lifecycleScope.launch {
                            w.nombre=nuevoNombre
                            w.nivel=nuevoNivel
                            w.video=v.findViewById<EditText>(R.id.etVideo).text.toString().ifBlank { null }
                            withContext(Dispatchers.IO){db.getWorkoutDao().update(w)}
                            cargar(v)
                        }
                    }
                })
                cont.addView(Button(requireContext()).apply {
                    text="Eliminar ${w.nombre}"
                    setOnClickListener {
                        android.app.AlertDialog.Builder(requireContext())
                            .setMessage("¿Eliminar ${w.nombre}?")
                            .setPositiveButton("Sí") { _,_ ->
                                viewLifecycleOwner.lifecycleScope.launch {
                                    withContext(Dispatchers.IO){db.getWorkoutDao().delete(w)}
                                    cargar(v)
                                }
                            }.setNegativeButton("No",null).show()
                    }
                })
            }
        }
    }
    private fun listarEjercicios(v:View, workoutId:Long) {
        val db=GymDatabase(requireContext())
        viewLifecycleOwner.lifecycleScope.launch {
            val datos=withContext(Dispatchers.IO){db.getEjercicioDao().getByWorkout(workoutId)}
            val cont=v.findViewById<LinearLayout>(R.id.contenido)
            cont.removeAllViews()
            datos.forEach { e ->
                cont.addView(TextView(requireContext()).apply { text="${e.orden}. ${e.nombre}" })
                cont.addView(Button(requireContext()).apply {
                    text="Editar ${e.nombre}"
                    setOnClickListener {
                        val nombre=v.findViewById<EditText>(R.id.etEjercicioNombre).text.toString()
                        if(nombre.isBlank()) {
                            Toast.makeText(requireContext(),"Escribe nombre nuevo",Toast.LENGTH_SHORT).show()
                        } else viewLifecycleOwner.lifecycleScope.launch {
                            e.nombre=nombre
                            e.tipo=v.findViewById<EditText>(R.id.etEjercicioTipo).text.toString()
                            e.descripcion=v.findViewById<EditText>(R.id.etEjercicioDescripcion).text.toString()
                            e.orden=v.findViewById<EditText>(R.id.etEjercicioOrden).text.toString().toIntOrNull()?:e.orden
                            e.tiempoEstimado=v.findViewById<EditText>(R.id.etEjercicioTiempo).text.toString().toIntOrNull()?:e.tiempoEstimado
                            withContext(Dispatchers.IO){db.getEjercicioDao().update(e)}
                            listarEjercicios(v,workoutId)
                        }
                    }
                })
                cont.addView(Button(requireContext()).apply {
                    text="Eliminar ${e.nombre}"
                    setOnClickListener {
                        android.app.AlertDialog.Builder(requireContext())
                            .setMessage("¿Eliminar ${e.nombre}?")
                            .setPositiveButton("Sí") { _,_ ->
                                viewLifecycleOwner.lifecycleScope.launch {
                                    withContext(Dispatchers.IO){db.getEjercicioDao().delete(e)}
                                    listarEjercicios(v,workoutId)
                                }
                            }.setNegativeButton("No",null).show()
                    }
                })
            }
        }
    }
}
