package es.elorrieta.gymapp.bd.entidades

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

// @Entity: tabla de ejercicios (t_ejercicios)
// @ForeignKey: cada ejercicio pertenece a un workout (workoutId -> t_workouts.id)
// CASCADE: si se borra el workout, se borran también sus ejercicios
@Entity(
    tableName = "t_ejercicios",
    foreignKeys = [
        ForeignKey(
            entity = Workout::class,
            parentColumns = ["id"],
            childColumns = ["workoutId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("workoutId")]
)
data class Ejercicio(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var workoutId: Long,
    var nombre: String,
    var tipo: String,                  // por ejemplo: Pecho, Piernas, Cardio
    var descripcion: String? = null,   // NO obligatoria
    var tiempoEstimado: Int,           // en minutos
    var orden: Int                     // posición en la serie: 1, 2, 3...
)