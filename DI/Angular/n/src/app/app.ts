import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  imports: [RouterOutlet],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('héroe borrado');

   heroes: string[] = ['Iron Man', 'Spider-Man', 'Thor', 'Black Widow'];
  
  // Almacena el nombre del héroe eliminado
  heroeBorrado: string | undefined = '';
  
  // Controla los tres estados requeridos en las condiciones
  estadoBorrado: 'ninguno' | 'borrado' | 'otro' = 'ninguno';

  // Método para borrar todos los héroes
  borrarTodos(): void {
    this.heroes = [];
    this.heroeBorrado = undefined;
    this.estadoBorrado = 'otro'; // Activa la condición "En cualquier otro caso"
  }

  // Método para borrar el último héroe
  borrarUltimo(): void {
    if (this.heroes.length > 0) {
      this.heroeBorrado = this.heroes.pop();
      this.estadoBorrado = 'borrado';
    }
  }

  // Método para borrar el primer héroe
  borrarPrimero(): void {
    if (this.heroes.length > 0) {
      this.heroeBorrado = this.heroes.shift();
      this.estadoBorrado = 'borrado';
    }
  }
}
