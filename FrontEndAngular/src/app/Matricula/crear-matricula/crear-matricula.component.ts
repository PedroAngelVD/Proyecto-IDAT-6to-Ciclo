import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Matricula } from '../Modelo/Matricula';

@Component({
  selector: 'app-crear-matricula',
  templateUrl: './crear-matricula.component.html',
  styleUrls: ['./crear-matricula.component.css']
})
export class CrearMatriculaComponent implements OnInit {

  constructor(private service: ServiceService, private router: Router) {

  }

  matri:Matricula = new Matricula();

  

  ngOnInit() {
  }

  Guardar(nombres_alumno:string, apellidos_alumno:string, fec_nacimiento:string, dni:string, direccion:string, telefono:string, celular:string, sexo:string){
    this.matri.nombres_alumno=nombres_alumno;
    this.matri.apellidos_alumno=apellidos_alumno;
    this.matri.fec_nacimiento=fec_nacimiento;
    this.matri.dni=dni;
    this.matri.direccion=direccion;
    this.matri.telefono=telefono;
    this.matri.celular=celular;
    this.matri.sexo=sexo;
    this.service.addMatricula(this.matri)
    .subscribe(data=>{
      this.router.navigate(["listarMatricula"]);
    })
  }

}
