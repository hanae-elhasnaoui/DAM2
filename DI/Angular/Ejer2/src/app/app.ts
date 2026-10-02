import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  imports: [RouterOutlet],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('Ejer2');
  base:number=5;

   sumar( valor: number ): void {
    this.base += valor;
  }

  restar( valor: number ): void {
    this.base -= valor;
  }
  
}
