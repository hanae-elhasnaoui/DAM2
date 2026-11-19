package es.elorrieta.gymapp.bd.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import es.elorrieta.gymapp.bd.entidades.WorkoutCompletado

// @Dao: operaciones sobre t_workouts_completados (progreso de cada usuario)
@Dao
interface WorkoutCompletadoDao {

    // Marcar un workout como completado
    @Insert
    fun insert(completado: WorkoutCompletado)

    // Desmarcar: borra la fila de ese usuario y ese workout
    @Query("DELETE FROM t_workouts_completados WHERE usuarioId = :usuarioId AND workoutId = :workoutId")
    fun borrar(usuarioId: Long, workoutId: Long)

    // ¿Lo tiene completado? 0 = no, 1 = sí
    @Query("SELECT COUNT(*) FROM t_workouts_completados WHERE usuarioId = :usuarioId AND workoutId = :workoutId")
    fun contar(usuarioId: Long, workoutId: Long): Int

    // Ids de todos los workouts que tiene completados un usuario
    @Query("SELECT workoutId FROM t_workouts_completados WHERE usuarioId = :usuarioId")
    fun getIdsCompletados(usuarioId: Long): List<Long>

    // Nivel más alto de los workouts completados (null si no tiene ninguno)
    // Lo usaremos para recalcular el nivel del usuario
    @Query(
        "SELECT MAX(w.nivel) FROM t_workouts w " +
                "INNER JOIN t_workouts_completados wc ON w.id = wc.workoutId " +
                "WHERE wc.usuarioId = :usuarioId"
    )
    fun getNivelMaximo(usuarioId: Long): Int?
}