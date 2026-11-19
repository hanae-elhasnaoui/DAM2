package es.elorrieta.gymapp
import es.elorrieta.gymapp.bd.GymDatabase
import es.elorrieta.gymapp.bd.entidades.EjercicioCompletado
import es.elorrieta.gymapp.bd.entidades.WorkoutCompletado
// Ejecutar estos métodos dentro de Dispatchers.IO
object Progreso {
    fun workout(db:GymDatabase, usuarioId:Long, workoutId:Long, completar:Boolean) {
        val ejercicios=db.getEjercicioDao().getByWorkout(workoutId)
        for(e in ejercicios) {
            val dao=db.getEjercicioCompletadoDao()
            if(completar && dao.contar(usuarioId,e.id)==0)
                dao.insert(EjercicioCompletado(usuarioId=usuarioId,ejercicioId=e.id))
            if(!completar) dao.borrar(usuarioId,e.id)
        }
        val dao=db.getWorkoutCompletadoDao()
        if(completar && dao.contar(usuarioId,workoutId)==0)
            dao.insert(WorkoutCompletado(usuarioId=usuarioId,workoutId=workoutId))
        if(!completar) dao.borrar(usuarioId,workoutId)
        nivel(db,usuarioId)
    }
    fun ejercicio(db:GymDatabase,usuarioId:Long,ejercicioId:Long,completar:Boolean) {
        val e=db.getEjercicioDao().getById(ejercicioId)?:return
        val lista=db.getEjercicioDao().getByWorkout(e.workoutId)
        val dao=db.getEjercicioCompletadoDao()
        for(item in lista) {
            if(completar && item.orden<=e.orden && dao.contar(usuarioId,item.id)==0)
                dao.insert(EjercicioCompletado(usuarioId=usuarioId,ejercicioId=item.id))
            if(!completar && item.orden>=e.orden) dao.borrar(usuarioId,item.id)
        }
        val todos=lista.isNotEmpty() && lista.all { dao.contar(usuarioId,it.id)>0 }
        val wc=db.getWorkoutCompletadoDao()
        if(todos && wc.contar(usuarioId,e.workoutId)==0)
            wc.insert(WorkoutCompletado(usuarioId=usuarioId,workoutId=e.workoutId))
        if(!todos) wc.borrar(usuarioId,e.workoutId)
        nivel(db,usuarioId)
    }
    private fun nivel(db:GymDatabase,usuarioId:Long) {
        val u=db.getUsuarioDao().getById(usuarioId)?:return
        u.nivel=db.getWorkoutCompletadoDao().getNivelMaximo(usuarioId)?:0
        db.getUsuarioDao().update(u)
    }
}
