import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { PagoReinscripcion } from '../Modelo/PagoReinscripcion';
import jsPDF from 'jspdf';
import 'jspdf-autotable';

declare var $:any;

@Component({
  selector: 'app-listar-pago-reinscripcion',
  templateUrl: './listar-pago-reinscripcion.component.html',
  styleUrls: ['./listar-pago-reinscripcion.component.css']
})
export class ListarPagoReinscripcionComponent implements OnInit {

  pagoreinscripcion: PagoReinscripcion[];

  constructor(private service: ServiceService, private router: Router) { }

  imprimirLista(){
    const doc = new jsPDF(); 
  
    doc.autoTable({html: '#frmPagoReinscripcion',
    columns: [{header: 'ID'},
    {header: 'CODIGO'},
    {header: 'DESCRIPCION'},
    {header: 'MONTO'},
    {header: 'VENCIMIENTO'},
    {header: 'FECHA'},
    {header: 'USUARIO'}
  ],
  theme: 'striped',
  styles: {
    font: "helvetica",
    halign: 'center'}
  });
    doc.save('Lista Pago de Reinscripcion');
  }

  ngOnInit() {
    this.service.getPagoReinscripcion().subscribe(data => {
      this.pagoreinscripcion = data;
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


}
