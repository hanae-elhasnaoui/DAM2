import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {Dado} from './dado/dado';

@Component({
  imports: [Dado],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('Juego con 3dados ');
  dado1: number = 1;
  dado2: number = 1;
  dado3: number = 1;
  resultado:String='Prueba tu suerte'

  jugar(){
    this.dado1  =Math.floor(Math.random()*9)+1 ;
    this.dado2=Math.floor(Math.random()*9)+1 ;
    this.dado3=Math.floor(Math.random()*9)+1 ;

    if(this.dado1===this.dado2 && this.dado2===this.dado3){
      this.resultado="has ganado"
    }else {
      this.resultado="has perdido"
    }
  }
}
