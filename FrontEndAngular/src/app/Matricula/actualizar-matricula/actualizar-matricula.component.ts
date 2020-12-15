import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Matricula } from '../Modelo/Matricula';

@Component({
  selector: 'app-actualizar-matricula',
  templateUrl: './actualizar-matricula.component.html',
  styleUrls: ['./actualizar-matricula.component.css']
})
export class ActualizarMatriculaComponent implements OnInit {

  constructor(private router:Router, private service:ServiceService) { }

  matricula:Matricula = new Matricula();

  ngOnInit() {
    this.Editar();
  }

  Editar(){
    let id = localStorage.getItem("idMatricula");
    this.service.getMatriculaId(+id)
    .subscribe(data =>{
      this.matricula = data;
    })
  }

  Actualizar(matricula:Matricula){
    this.service.updateMatricula(matricula)
    .subscribe(data => {
      this.router.navigate(["listarMatricula"]);
    })
  }

}
