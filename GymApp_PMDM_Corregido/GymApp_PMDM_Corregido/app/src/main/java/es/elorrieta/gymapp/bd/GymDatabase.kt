package es.elorrieta.gymapp.bd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import es.elorrieta.gymapp.bd.dao.EjercicioCompletadoDao
import es.elorrieta.gymapp.bd.dao.EjercicioDao
import es.elorrieta.gymapp.bd.dao.UsuarioDao
import es.elorrieta.gymapp.bd.dao.WorkoutCompletadoDao
import es.elorrieta.gymapp.bd.dao.WorkoutDao
import es.elorrieta.gymapp.bd.entidades.Ejercicio
import es.elorrieta.gymapp.bd.entidades.EjercicioCompletado
import es.elorrieta.gymapp.bd.entidades.Usuario
import es.elorrieta.gymapp.bd.entidades.Workout
import es.elorrieta.gymapp.bd.entidades.WorkoutCompletado

// @Database: une las 5 entidades (tablas) con sus DAO
// version = 1: si cambiamos una tabla durante el desarrollo, desinstalar la app del emulador
@Database(
    entities = [
        Usuario::class,
        Workout::class,
        Ejercicio::class,
        WorkoutCompletado::class,
        EjercicioCompletado::class
    ],
    version = 1,
    exportSchema = false
)
abstract class GymDatabase : RoomDatabase() {

    // Patrón Singleton (UD4.2): solo existe UNA instancia de la base de datos en toda la App
    companion object {
        @Volatile
        private var instance: GymDatabase? = null
        private val LOCK = Any()

        // Se usa así desde cualquier pantalla: val db = GymDatabase(requireContext())
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            GymDatabase::class.java,
            "gymDataBase"
        ).build()
    }

    // Un método abstracto por cada DAO
    abstract fun getUsuarioDao(): UsuarioDao
    abstract fun getWorkoutDao(): WorkoutDao
    abstract fun getEjercicioDao(): EjercicioDao
    abstract fun getWorkoutCompletadoDao(): WorkoutCompletadoDao
    abstract fun getEjercicioCompletadoDao(): EjercicioCompletadoDao
}