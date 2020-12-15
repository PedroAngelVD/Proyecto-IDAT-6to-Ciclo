import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Alumno } from '../Modelo/Alumno';
import jsPDF from 'jspdf';
import 'jspdf-autotable';

declare var $:any;

@Component({
  selector: 'app-listar-alumno',
  templateUrl: './listar-alumno.component.html',
  styleUrls: ['./listar-alumno.component.css']
})
export class ListarAlumnoComponent implements OnInit {

  alumno: Alumno[];

  constructor(private service: ServiceService, private router: Router) { }

  imprimirLista(){
    const doc = new jsPDF(); 
  
    doc.autoTable({html: '#frmAlumno',
    columns: [{header: 'ID'},
    {header: 'CODIGO'},
    {header: 'NOMBRES'},
    {header: 'APELLIDOS'},
    {header: 'GRADO'},
    {header: 'SECCION'},
    {header: 'PRIM/SEC'}
  ],
  theme: 'striped',
  styles: {
    font: "helvetica",
    halign: 'center'}
  });
    doc.save('Lista Alumnos');
  }

  ngOnInit() {
    this.service.getAlumno().subscribe(data => {
      this.alumno = data;
    });

    $(document).ready(function(){
      $("#myInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#myTable tr").filter(function() {
          $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
      });
    });
  }

  Editar(alumno:Alumno):void{
    localStorage.setItem("idAlumno", alumno.id_alumno.toString());
    this.router.navigate(["actualizarAlumno"]);
  }

}
