import {Component, Input} from '@angular/core';

@Component({
  imports: [],
  selector: 'app-dado',
  styleUrl: './dado.css',
  templateUrl: './dado.html',
})
export class Dado {
  @Input() valor: number = 0;
}
