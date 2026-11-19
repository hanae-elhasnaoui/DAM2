package es.elorrieta.gymapp.bd.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

// @Entity: tabla de workouts (t_workouts)
@Entity(tableName = "t_workouts")
data class Workout(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var nombre: String,
    var nivel: Int,
    var video: String? = null      // URL de YouTube, NO obligatoria
)