package es.elorrieta.gymapp.bd.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import es.elorrieta.gymapp.bd.entidades.EjercicioCompletado

// @Dao: operaciones sobre t_ejercicios_completados (progreso de cada usuario)
@Dao
interface EjercicioCompletadoDao {

    // Marcar un ejercicio como completado
    @Insert
    fun insert(completado: EjercicioCompletado)

    // Desmarcar: borra la fila de ese usuario y ese ejercicio
    @Query("DELETE FROM t_ejercicios_completados WHERE usuarioId = :usuarioId AND ejercicioId = :ejercicioId")
    fun borrar(usuarioId: Long, ejercicioId: Long)

    // ¿Lo tiene completado? 0 = no, 1 = sí
    @Query("SELECT COUNT(*) FROM t_ejercicios_completados WHERE usuarioId = :usuarioId AND ejercicioId = :ejercicioId")
    fun contar(usuarioId: Long, ejercicioId: Long): Int

    // Ids de todos los ejercicios que tiene completados un usuario
    @Query("SELECT ejercicioId FROM t_ejercicios_completados WHERE usuarioId = :usuarioId")
    fun getIdsCompletados(usuarioId: Long): List<Long>

    // Cuántos ejercicios de UN workout ha completado el usuario (para el %)
    @Query(
        "SELECT COUNT(*) FROM t_ejercicios_completados ec " +
                "INNER JOIN t_ejercicios e ON e.id = ec.ejercicioId " +
                "WHERE ec.usuarioId = :usuarioId AND e.workoutId = :workoutId"
    )
    fun contarDeWorkout(usuarioId: Long, workoutId: Long): Int
}