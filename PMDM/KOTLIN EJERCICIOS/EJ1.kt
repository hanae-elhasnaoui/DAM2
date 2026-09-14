/* Ejercicio 2

Crea un programa Kotlin que solicita un usuario y un password. Si ambos son 'admin', le mostramos un mensaje
de bienvenida. Si no, le mostramos un mensaje de error.*/
fun main() {
    // 1. Solicitar el usuario
    print("Introduce el usuario: ")
    val usuario = readln()

    // 2. Solicitar la contraseña
    print("Introduce la contraseña: ")
    val password = readln()

    // 3. Validar las credenciales
    if (usuario == "admin" && password == "admin") {
        println("¡Bienvenido al sistema!")
    } else {
        println("Error: Usuario o contraseña incorrectos.")
    }
}