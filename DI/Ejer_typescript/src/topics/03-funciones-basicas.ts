

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