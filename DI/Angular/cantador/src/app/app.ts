import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  imports: [RouterOutlet],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  
  protected readonly title = signal('cantador app');

  public contador =signal<number>(10);


  sumar(): void {
    this.contador.update(val => val + 1);
  }

  restar(): void {
    this.contador.update(val => val - 1);
  }

}
