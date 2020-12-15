import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Curso } from '../Modelo/Curso';

@Component({
  selector: 'app-actualizar-curso',
  templateUrl: './actualizar-curso.component.html',
  styleUrls: ['./actualizar-curso.component.css']
})
export class ActualizarCursoComponent implements OnInit {

  constructor(private router:Router, private service:ServiceService) { }

  curso:Curso = new Curso();

  ngOnInit() {
    this.Editar();
  }

  Editar(){
    let id = localStorage.getItem("idCurso");
    this.service.getCursoId(+id)
    .subscribe(data =>{
      this.curso = data;
    })
  }

  

  Actualizar(curso:Curso){
    this.service.updateCurso(curso)
    .subscribe(data => {
      this.router.navigate(["listarCurso"]);
    })
  }
}
