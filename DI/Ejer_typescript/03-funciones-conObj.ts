interface PersonajeLOR {
    nombre: string;
    pv: number;
}


function curar(personaje: PersonajeLOR, puntosCuracion: number): void {
    personaje.pv += puntosCuracion;
    
    console.log('Personaje actualizado:', personaje);
}
const nuevoPersonaje: PersonajeLOR = {
    nombre: 'Strider',
    pv: 50
};

console.log(nuevoPersonaje);

curar(nuevoPersonaje, 20);
