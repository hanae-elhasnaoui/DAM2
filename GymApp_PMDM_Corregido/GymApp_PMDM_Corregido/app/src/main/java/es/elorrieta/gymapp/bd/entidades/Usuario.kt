package es.elorrieta.gymapp.bd.entidades

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

// @Entity: esta clase es una TABLA de la base de datos (t_usuarios)
// Index unique: no puede haber dos usuarios con el mismo login
@Entity(
    tableName = "t_usuarios",
    indices = [Index(value = ["login"], unique = true)]
)
data class Usuario(
    // Clave primaria autoincremental: ROOM le da el valor al insertar
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var login: String,
    var pass: String,
    var nombre: String,
    var apellidos: String,
    var email: String,
    var fechaNacimiento: String,   // formato dd/mm/aaaa
    var tipo: String,              // "cliente" o "entrenador"
    var nivel: Int = 0,            // 0 = todavía no ha completado ningún workout
    var foto: ByteArray? = null    // foto de la cámara (opcional)
)