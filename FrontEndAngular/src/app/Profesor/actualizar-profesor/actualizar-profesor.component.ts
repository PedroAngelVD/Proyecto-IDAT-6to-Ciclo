import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Profesor } from '../Modelo/Profesor';

@Component({
  selector: 'app-actualizar-profesor',
  templateUrl: './actualizar-profesor.component.html',
  styleUrls: ['./actualizar-profesor.component.css']
})
export class ActualizarProfesorComponent implements OnInit {

  constructor(private router:Router, private service:ServiceService) { }

  profesor:Profesor = new Profesor();

  ngOnInit() {
    this.Editar();
  }

  Editar(){
    let id = localStorage.getItem("idProfesor");
    this.service.getProfesorId(+id)
    .subscribe(data =>{
      this.profesor = data;
    })
  }

  Actualizar(profesor:Profesor){
    this.service.updateProfesor(profesor)
    .subscribe(data => {
      this.router.navigate(["listarProfesor"]);
    })
  }

}
