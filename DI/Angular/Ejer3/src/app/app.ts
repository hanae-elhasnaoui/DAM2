import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  imports: [RouterOutlet],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('Bienvenido a contador App');
  empleado:string="jorge"
  edad:number=25
  sueldos=[4000,12000,125]
  SumarSueldosFor():number{
     let suma=0

    for ( const sueldo of this.sueldos ){
      suma+=sueldo
    }
    return suma
  }

  SumarSueldosForEach():number{
      let suma2=0

      this.sueldos.forEach(sueldo => suma2 +=sueldo)
      return suma2

  }
  
}