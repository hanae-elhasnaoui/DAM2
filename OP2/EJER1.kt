package org.example

fun main() {

    pedirElLogin()

}


private fun pedirElLogin() {
    var usuarioIntroducido: String?
    var claveIntroducida: String?
    var claveCorrecta = false
    var intentos = 0
    do {
        print("Usuario: ")
        usuarioIntroducido = readln()

        print("Clave: ")
        claveIntroducida = readln()

        if ((usuarioIntroducido == "admin")
            && ( claveIntroducida == "admin")
        ) {
            claveCorrecta = true
            opciones()

        } else {
            println("Error!!! Usuario o Clave incorrectos")
            intentos++
        }
    } while (!claveCorrecta && intentos<3)
}

fun opciones(){
    var opcion: Int
    do {

        println("\n--- MENÚ DE OPCIONES ---")
        println("1) Nuevo nombre")
        println("2) Mostrar nombres")
        println("3) Buscar nombre")
        println("4) Modificar nombre")
        println("5) Borrar nombre")
        println("6) Salir")
        print("Selecciona una opción: ")
        opcion=readln().toInt()

        when (opcion) {
            1 -> nuevoNombre()
            2 -> mostrarNombres()
            3 -> buscarNombre()
            4 -> modificarNombre()
            5 -> borrarNombre()
            6 -> println("Saliendo del programa... ¡Hasta luego!")
            else -> println("Opción no válida. Por favor, introduce un número del 1 al 6.")
        }

    }while (opcion!=6)


}

fun nuevoNombre() {
     TODO("Not yet implemented")
}

fun borrarNombre() {
    TODO("Not yet implemented")
}

fun modificarNombre() {
    TODO("Not yet implemented")
}

fun mostrarNombres() {
    TODO("Not yet implemented")
}

fun buscarNombre() {
    TODO("Not yet implemented")
}
