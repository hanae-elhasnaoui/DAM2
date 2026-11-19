package es.elorrieta.gymapp.bd.dao



import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import es.elorrieta.gymapp.bd.entidades.Usuario

// @Dao: interfaz con las operaciones sobre la tabla t_usuarios
// Los valores que empiezan por ":" (:login, :pass...) son los parámetros del método
@Dao
interface UsuarioDao {

    // Login: devuelve el usuario si login, pass y tipo coinciden; si no, null
    @Query("SELECT * FROM t_usuarios WHERE login = :login AND pass = :pass AND tipo = :tipo")
    fun login(login: String, pass: String, tipo: String): Usuario?

    // Registro: para comprobar si el login ya existe
    @Query("SELECT * FROM t_usuarios WHERE login = :login")
    fun getByLogin(login: String): Usuario?

    // Perfil y cabecera: cargar el usuario que ha iniciado sesión
    @Query("SELECT * FROM t_usuarios WHERE id = :id")
    fun getById(id: Long): Usuario?

    @Query("SELECT * FROM t_usuarios ORDER BY id")
    fun getAll(): List<Usuario>

    // Registro: inserta un usuario y devuelve su id
    @Insert
    fun insert(usuario: Usuario): Long

    // Precarga: inserta varios usuarios de golpe
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(vararg usuarios: Usuario)

    // Perfil: guarda los cambios (y el nivel cuando se recalcula)
    @Update
    fun update(usuario: Usuario)
}