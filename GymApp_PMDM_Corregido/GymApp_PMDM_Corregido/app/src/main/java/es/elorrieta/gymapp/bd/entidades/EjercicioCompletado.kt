package es.elorrieta.gymapp.bd.entidades


import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

// @Entity: tabla que guarda QUÉ ejercicios ha completado CADA usuario
// Una fila = "el usuario X ha completado el ejercicio Y". Borrar la fila = desmarcar.
@Entity(
    tableName = "t_ejercicios_completados",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["id"],
            childColumns = ["usuarioId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Ejercicio::class,
            parentColumns = ["id"],
            childColumns = ["ejercicioId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("usuarioId"), Index("ejercicioId"), Index(value = ["usuarioId", "ejercicioId"], unique = true)]
)
data class EjercicioCompletado(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var usuarioId: Long,
    var ejercicioId: Long
)