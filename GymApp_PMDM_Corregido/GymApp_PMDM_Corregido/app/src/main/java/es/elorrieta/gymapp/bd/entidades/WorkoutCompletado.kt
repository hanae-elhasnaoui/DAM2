package es.elorrieta.gymapp.bd.entidades

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

// @Entity: tabla que guarda QUÉ workouts ha completado CADA usuario
// Una fila = "el usuario X ha completado el workout Y". Borrar la fila = desmarcar.
@Entity(
    tableName = "t_workouts_completados",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["id"],
            childColumns = ["usuarioId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Workout::class,
            parentColumns = ["id"],
            childColumns = ["workoutId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("usuarioId"), Index("workoutId"), Index(value = ["usuarioId", "workoutId"], unique = true)]
)
data class WorkoutCompletado(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var usuarioId: Long,
    var workoutId: Long
)