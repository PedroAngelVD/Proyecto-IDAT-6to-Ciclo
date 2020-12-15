import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Login } from '../Modelo/login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  log: Login[];

  constructor(private service: ServiceService, private router: Router) { }

  ngOnInit() {
    
  }

  login(form: NgForm){
    this.service.getUsuarios().subscribe(data => {
      this.log = data;

      for(var x = 0; x < this.log.length; x++){
        let usuario = data[x].usuario;
        let password = data[x].password;

        if(form.value.usuario == usuario.toString() && form.value.password == password.toString()){
          localStorage.setItem('usuario', form.value.usuario);
          this.router.navigate(['/'])

          if(localStorage.getItem('usuario')!=null){
            window.location.reload(false);
          }
          
        }
      }
      
    });

    

    

  }

}
