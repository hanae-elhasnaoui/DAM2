import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { inject } from '@angular/core';
import { Articulo } from '../models/articulo';

@Injectable()
export class Servicearticulos {
  private http = inject(HttpClient);
  // Creamos un método que utiliza HTTP GET para solicitar los datos JSON al servidor y devuelve un Observable.
  recuperarTodos() {
    return this.http.get<Articulo[]>('https://jsonplaceholder.typicode.com/posts');
  }
}
