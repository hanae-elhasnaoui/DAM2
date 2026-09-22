/**
 * 
 * Crear una interfaz para representar pasajeros y comprobar cuántos hijos tiene cada uno.

Define una interfaz llamada Pasajero que contenga:

nombre: de tipo string.

hijos: un array de string que sea opcional.

Crea dos pasajeros:

pasajero1, llamado "Jorge", sin indicar hijos.

pasajero2, llamado "Felipe", con dos hijos: "Natalia" y "Gabriel".

Crea una función imprimirHijos que reciba un pasajero y muestre por consola el número de hijos. Utiliza el operador ?. para acceder de forma segura a la propiedad hijos y obtener su longitud.

Comprueba el resultado de la función con ambos pasajeros. El pasajero sin hijos debe producir undefined, mientras que el segundo debe mostrar 2.

Crea una segunda función llamada imprimirHijos2 que haga lo mismo, pero utilizando el operador || para mostrar 0 cuando el pasajero no tenga hijos.

Objetivo: practicar las propiedades opcionales (?), el encadenamiento opcional (?.) y el operador || para establecer valores por defecto.
*/

interface Pasajeros{
    nombre:string
    hijos?:string[]
}
const pasajero1:Pasajeros ={
    nombre:"jorge"
}
const pasajero2:Pasajeros={
    nombre:"Felipe",
    hijos:["Natalia","Gabrial"]
}

function imprimirHijos(p:Pasajeros){
     // Evalúa de forma segura: si 'pasajero' o 'hijos' no existen (son null/undefined), 
    // el operador ?. detiene la ejecución y devuelve undefined sin romper el programa.
    const numeroDeHijos=p?.hijos?.length;

    console.log(`el persomaje ${p?.nombre} tiene  ${numeroDeHijos} hijos`)

}

imprimirHijos(pasajero1)
imprimirHijos(pasajero2)

function imprimirHijos2(p:Pasajeros){
     // Evalúa de forma segura: si 'pasajero' o 'hijos' no existen (son null/undefined), 
    // el operador ?. detiene la ejecución y devuelve undefined sin romper el programa.
    // si
    const numeroDeHijos=p?.hijos?.length  || "no tenga hijos";

    console.log(`el persomaje ${p?.nombre} tiene  ${numeroDeHijos} hijos`)

}
imprimirHijos2(pasajero1)
imprimirHijos2(pasajero2)
