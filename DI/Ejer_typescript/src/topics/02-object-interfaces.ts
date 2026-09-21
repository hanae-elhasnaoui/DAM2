// 1. Declara el array de habilidades
const habilidades: string[] = ['Bash', 'Counter', 'Healing'];

// 2. Crea la interfaz con la propiedad opcional (?)
interface Personaje {
  nombre: string;
  hp: number;
  habilidades: string[];
  puebloNatal?: string; 
}

// 3. Crea la constante basada en la interfaz
const personaje: Personaje = {
  nombre: 'Strider',
  hp: 100,
  habilidades: ['Bash', 'Counter'] 
};

// 4. Añade posteriormente la propiedad opcional
personaje.puebloNatal = 'Pueblo Paleta';

// 5. Muestra los resultados en la consola de dos formas distintas
console.table(personaje);
console.log(personaje);
