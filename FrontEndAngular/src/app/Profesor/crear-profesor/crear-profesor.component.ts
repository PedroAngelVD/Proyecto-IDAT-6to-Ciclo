import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Profesor } from '../Modelo/Profesor';

@Component({
  selector: 'app-crear-profesor',
  templateUrl: './crear-profesor.component.html',
  styleUrls: ['./crear-profesor.component.css']
})
export class CrearProfesorComponent implements OnInit {

  constructor(private service: ServiceService, private router: Router) {

  }

 prof:Profesor = new Profesor();

 ngOnInit() {
 }

 Guardar(nombres:string, apellidos:string, dni:string, direccion:string, telefono:string, celular:string, sexo:string){
   this.prof.nombres=nombres;
   this.prof.apellidos=apellidos;
   this.prof.dni=dni;
   this.prof.direccion=direccion;
   this.prof.telefono=telefono;
   this.prof.celular=celular;
   this.prof.sexo=sexo;
   this.service.addProfesor(this.prof)
   .subscribe(data=>{
     this.router.navigate(["listarProfesor"]);
   })
 }

}
