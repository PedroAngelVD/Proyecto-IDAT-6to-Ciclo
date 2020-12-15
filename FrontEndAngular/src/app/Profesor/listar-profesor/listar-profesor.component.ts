import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Profesor } from '../Modelo/Profesor';
import jsPDF from 'jspdf';
import 'jspdf-autotable';

declare var $:any;

@Component({
  selector: 'app-listar-profesor',
  templateUrl: './listar-profesor.component.html',
  styleUrls: ['./listar-profesor.component.css']
})
export class ListarProfesorComponent implements OnInit {

  profesores: Profesor[];

  constructor(private service: ServiceService, private router: Router) { }

  imprimirLista(){
    const doc = new jsPDF(); 
  
    doc.autoTable({html: '#frmProfesores',
    columns: [{header: 'ID', dataKey: 'id'},
    {header: 'NOMBRES', dataKey: 'nombres'},
    {header: 'APELLIDOS', dataKey: 'apellidos'},
    {header: 'DNI', dataKey: 'dni'},
    {header: 'DIRECCION', dataKey: 'direccion'},
    {header: 'TELEFONO', dataKey: 'telefono'},
    {header: 'CELULAR', dataKey: 'celular'}
  ],
  theme: 'striped',
  styles: {
    font: "helvetica",
    halign: 'center'}
  });
    doc.save('Lista de Profesores');
  }

  ngOnInit() {
    this.service.getProfesor().subscribe(data => {
      this.profesores = data;
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

  

  Agregar(profesores:string){
    this.router.navigate(["crearProfesor"]);
  }

  Editar(profesores:Profesor):void{
    localStorage.setItem("idProfesor", profesores.id_profesor.toString());
    this.router.navigate(["actualizarProfesor"]);
  }

  Eliminar(profesores:Profesor){
    this.service.deleteProfesor(profesores)
    .subscribe(data =>{
      this.profesores=this.profesores.filter(c=>c!==profesores);
    })
  }

}
