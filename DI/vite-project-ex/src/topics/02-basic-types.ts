/** https://www.typescriptlang.org/docs/handbook/basic-types.html

https://www.typescriptlang.org/docs/handbook/2/everyday-types.html

Creamos un nuevo archivo llamado 02-basic-types.ts

Declara y muestra variables utilizando diferentes tipos de datos en TypeScript.

Declara una constante aaa con el valor "Strider". (const significa que esa variable no puede recibir otro valor después de su declaración.)

Declara una variable bbb con el mismo valor utilizando let.

Declara una variable nombre de tipo string con tu nombre y muéstrala por consola.

Declara una variable ccc de tipo number con el valor 95.

Declara una variable ddd de tipo boolean con el valor false.

Muestra todas las variables (aaa, bbb, ccc y ddd) por consola en una misma línea.

Finalmente, muestra las mismas variables como un objeto, utilizando la sintaxis abreviada de propiedades de JavaScript/TypeScript. */

const aaa = "Strider";
let bbb = "Strider";

let nombre: string = "hanae";
console.log(nombre);

let ccc: number = 95;
let ddd: boolean = false;

console.log(aaa, bbb, ccc, ddd);

console.log({ aaa, bbb, ccc, ddd });
