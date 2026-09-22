
// ==========================================
// 1. Función para concatenar cadenas de texto
// ==========================================

// Definición de la función sumar (en TypeScript podemos tipar los parámetros como string)
function sumar(a: string, b: string): string {
    return a + b;
}

// Llamada a la función con los textos indicados
const resultado = sumar("Fernando", " Herrera");

// Mostrar el resultado por consola ("Fernando Herrera")
console.log(resultado);


// ==========================================
// 2. Función para sumar valores numéricos
// ==========================================

// Función sumar1 que recibe números y devuelve un número
function sumar1(num1: number, num2: number): number {
    return num1 + num2;
}

// Llamada a la función sumar1 con dos números de ejemplo
const resultadoNumerico = sumar1(10, 5);

// Mostrar el resultado numérico por consola (15)
console.log(resultadoNumerico);

const resultado2= (a:number,b:number):number=>{
    return a+b;
}

const resultado3=resultado2(1,6);

console.log(resultado3);


function multiplicar(n1:number,n2?:number,base:number=3){
    
    return n1*base;
}

const llamda1=multiplicar(4,5);
console.log(llamda1);
const llamada2=multiplicar(4)
console.log(llamada2);
const llamada3=multiplicar(4,5,5);
console.log(llamada3);

const llamada4=multiplicar(6,undefined,undefined)
console.log(llamada4)