package es.elorrieta.gymapp.bd.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import es.elorrieta.gymapp.bd.entidades.Ejercicio

// @Dao: operaciones sobre la tabla t_ejercicios (el CRUD completo)
@Dao
interface EjercicioDao {

    // Ejercicios de un workout, en orden de serie (1, 2, 3...)
    @Query("SELECT * FROM t_ejercicios WHERE workoutId = :workoutId ORDER BY orden")
    fun getByWorkout(workoutId: Long): List<Ejercicio>

    @Query("SELECT * FROM t_ejercicios WHERE id = :id")
    fun getById(id: Long): Ejercicio?

    // Cuántos ejercicios tiene un workout (para calcular el %)
    @Query("SELECT COUNT(*) FROM t_ejercicios WHERE workoutId = :workoutId")
    fun contarDeWorkout(workoutId: Long): Int

    @Insert
    fun insert(ejercicio: Ejercicio): Long

    @Insert
    fun insertAll(vararg ejercicios: Ejercicio)

    @Update
    fun update(ejercicio: Ejercicio)

    @Delete
    fun delete(ejercicio: Ejercicio)
}