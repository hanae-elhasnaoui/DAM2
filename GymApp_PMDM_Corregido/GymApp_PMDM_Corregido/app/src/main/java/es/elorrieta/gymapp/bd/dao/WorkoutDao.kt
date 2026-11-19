package es.elorrieta.gymapp.bd.dao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import es.elorrieta.gymapp.bd.entidades.Workout

// @Dao: operaciones sobre la tabla t_workouts (el CRUD completo)
@Dao
interface WorkoutDao {

    // Lista de Workouts ordenada por nivel (lo pide la rúbrica)
    @Query("SELECT * FROM t_workouts ORDER BY nivel, nombre")
    fun getAll(): List<Workout>

    // Filtro por nivel
    @Query("SELECT * FROM t_workouts WHERE nivel = :nivel ORDER BY nombre")
    fun getByNivel(nivel: Int): List<Workout>

    @Query("SELECT * FROM t_workouts WHERE id = :id")
    fun getById(id: Long): Workout?

    // Create: devuelve el id del workout nuevo
    @Insert
    fun insert(workout: Workout): Long

    @Insert
    fun insertAll(vararg workouts: Workout)

    // Update
    @Update
    fun update(workout: Workout)

    // Delete (sus ejercicios se borran solos por el CASCADE)
    @Delete
    fun delete(workout: Workout)
}