import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { ListarHorario } from '../Modelo/ListarHorario';
import jsPDF from 'jspdf';
import 'jspdf-autotable';

declare var $:any;

@Component({
  selector: 'app-listar-horario',
  templateUrl: './listar-horario.component.html',
  styleUrls: ['./listar-horario.component.css']
})
export class ListarHorarioComponent implements OnInit {

  listarhorario: ListarHorario[];

  constructor(private service: ServiceService, private router: Router) { }

  imprimirLista(){
    const doc = new jsPDF(); 
  
    doc.autoTable({html: '#frmHorario',
    columns: [{header: 'ID'},
    {header: 'CURSO'},
    {header: 'CODIGO'},
    {header: 'NOMBRES'},
    {header: 'GRADO'},
    {header: 'SECCION'},
    {header: 'PRIM/SEC'},
    {header: 'INICIO'},
    {header: 'FIN'}
  ],
  theme: 'striped',
  styles: {
    font: "helvetica",
    halign: 'center'}
  });
    doc.save('Lista Horario');
  }

  ngOnInit() {
    this.service.getHorario().subscribe(data => {
      this.listarhorario = data;
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

  Editar(listarhorario:ListarHorario):void{
    localStorage.setItem("idActualizarHorario", listarhorario.id_curso_grado_detalle.toString());
    this.router.navigate(["actualizarHorario"]);
  }

}
