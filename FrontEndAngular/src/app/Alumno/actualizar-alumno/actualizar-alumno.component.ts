import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Alumno } from '../Modelo/Alumno';

@Component({
  selector: 'app-actualizar-alumno',
  templateUrl: './actualizar-alumno.component.html',
  styleUrls: ['./actualizar-alumno.component.css']
})
export class ActualizarAlumnoComponent implements OnInit {

  constructor(private router:Router, private service:ServiceService) { }

  alumno:Alumno = new Alumno();

  objeto: Object[] = [
    {primasecu: 'Primaria'},{primasecu: 'Secundaria'}
  ] 

  objeto2: Object[] = [
    {secciones: 'A'},{secciones: 'B'},{secciones: 'C'}
  ] 

  objeto3: Object[] = [
    {grados: 1},{grados: 2},{grados: 3},{grados: 4},{grados: 5},{grados: 6}
  ] 
  
  ngOnInit() {
    this.Editar()
  }

  Editar(){
    let id = localStorage.getItem("idAlumno");
    this.service.getAlumnoId(+id)
    .subscribe(data =>{
      this.alumno = data;
    })
  }

  Actualizar(alumno:Alumno){
    this.service.updateAlumno(alumno)
    .subscribe(data => {
      this.router.navigate(["listarAlumno"]);
    })
  }

}
