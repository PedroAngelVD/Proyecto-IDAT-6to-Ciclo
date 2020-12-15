import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Matricula } from '../Modelo/Matricula';
import jsPDF from 'jspdf';
import 'jspdf-autotable';

declare var $:any;


@Component({
  selector: 'app-listar-matricula',
  templateUrl: './listar-matricula.component.html',
  styleUrls: ['./listar-matricula.component.css']
})
export class ListarMatriculaComponent implements OnInit {

  matriculas: Matricula[];

  constructor(private service: ServiceService, private router: Router) { }

  imprimirLista(){
    const doc = new jsPDF(); 
  
    doc.autoTable({html: '#frmMatricula',
    columns: [{header: 'ID'},
    {header: 'N°'},
    {header: 'CODIGO'},
    {header: 'NOMBRES'},
    {header: 'APELLIDOS'},
    {header: 'NACIMIENTO'},
    {header: 'FECHA'},
    {header: 'DNI'},
    {header: 'DIRECCION'},
    {header: 'TELEFONO'},
    {header: 'CELULAR'},
    {header: 'SEXO'}
  ],
  theme: 'striped',
  styles: {fontSize: 6,
    font: "helvetica",
    halign: 'center'}
  });
    doc.save('Lista Matricula');
  }


  ngOnInit() {
    this.service.getMatricula().subscribe(data => {
      this.matriculas = data;
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

  Agregar(matriculas:string){
    this.router.navigate(["crearMatricula"]);
  }

  Editar(matriculas:Matricula):void{
    localStorage.setItem("idMatricula", matriculas.id_matricula.toString());
    this.router.navigate(["actualizarMatricula"]);
  }

  Eliminar(matriculas:Matricula){
    this.service.deleteMatricula(matriculas)
    .subscribe(data =>{
      this.matriculas=this.matriculas.filter(c=>c!==matriculas);
    })
  }

}
