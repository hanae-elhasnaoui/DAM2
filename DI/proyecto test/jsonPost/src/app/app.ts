import { Component, inject, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Servicearticulos } from './service/servicearticulos';
import se from '@angular/common/locales/extra/se';
import { Articulo } from './models/articulo';

@Component({
  imports: [RouterOutlet],
  providers:[Servicearticulos],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App  implements OnInit{

  articulos: Articulo[] = [];

  
  protected readonly title = signal('jsonPost');
  private servicio= inject(Servicearticulos);

  ngOnInit(): void {

    this.servicio.recuperarTodos().subscribe(datos =>{
      this.articulos=datos ;
      console.log(datos);
    })
  }
  

}
