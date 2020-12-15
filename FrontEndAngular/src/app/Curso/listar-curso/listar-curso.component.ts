import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Curso } from '../Modelo/Curso';
import jsPDF from 'jspdf';
import 'jspdf-autotable';


declare var $:any;

@Component({
  selector: 'app-listar-curso',
  templateUrl: './listar-curso.component.html',
  styleUrls: ['./listar-curso.component.css']
})
export class ListarCursoComponent implements OnInit {

  cursos: Curso[];

  constructor(private service: ServiceService, private router: Router) { }

  imprimirLista(){
    const doc = new jsPDF(); 
  
    doc.autoTable({html: '#frmCurso',
    columns: [{header: 'ID'},
    {header: 'CURSO'}
  ],
  theme: 'striped',
  styles: {
    font: "helvetica",
    halign: 'center'}
  });
    doc.save('Lista Cursos');
  }

  ngOnInit() {
    this.service.getCursos().subscribe(data => {
      this.cursos = data;
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

  Agregar(curso:string){
    this.router.navigate(["crearCurso"]);
  }

  Editar(curso:Curso):void{
    localStorage.setItem("idCurso", curso.id_curso.toString());
    this.router.navigate(["actualizarCurso"]);
  }

  Eliminar(curso:Curso){
    this.service.deleteCurso(curso)
    .subscribe(data =>{
      this.cursos=this.cursos.filter(c=>c!==curso);
    })
  }



}
