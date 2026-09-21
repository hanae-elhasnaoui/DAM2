// 1. Array vacío: TypeScript le asigna por defecto el tipo 'any[]' (cualquier cosa) 
// porque no tiene elementos para adivinar su tipo.
const habilidades1 = [];


// 2. Elementos mezclados: TypeScript infiere de forma automática una unión de tipos.
// El tipo resultante será: (string | number | boolean | number[] | { nombre: string })[]
const habilidades2 = [
  42, 
  'Bash', 
  true, , 
  { nombre: 'Fighter' }
];


// 3. Textos y un número: TypeScript vuelve a inferir automáticamente.
// El tipo resultante será: (string | number)[]
const habilidades3 = ['Healing', 'Counter', 100];


// 4. Declaración explícita (Unión de tipos con el operador '|'):
// Obligamos al array a aceptar ÚNICAMENTE los tres tipos indicados.
const habilidades4: (boolean | string | number)[] = [true, 'Slash', 250];
