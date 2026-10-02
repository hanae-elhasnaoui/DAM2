import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  imports: [RouterOutlet],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})

interface userProfile{
  email?:string ;
  password?:string

}
export class App {

  protected readonly title = signal('ejercicio Contador');

  name = signal( 'Angular' );
  current ='';
  user:userProfile = {

  };


  Modifname(){
    this.name.set("hanae");
  }

  save(val: string){

    this.name.set(val);

  }
  read(vall :string){
    this.current = vall ?? '';
  }
  
  login(emailes ?:string  , passes ?:string ){

    
    this.user ={
      email : emailes ?? '',
      password:passes ?? ''
    }

    if (this.user?.email === 'admin@gmail.com' && this.user.password === '1234') {
    alert('¡Inicio de sesión correcto!');
  } 
  else {
    alert('Credenciales incorrectas');
  }
  }
    
}
