import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { PagoMensualidad } from '../Modelo/PagoMensualidad';
import jsPDF from 'jspdf';
import 'jspdf-autotable';

declare var $:any;

@Component({
  selector: 'app-listar-pago-mensualidad',
  templateUrl: './listar-pago-mensualidad.component.html',
  styleUrls: ['./listar-pago-mensualidad.component.css']
})
export class ListarPagoMensualidadComponent implements OnInit {

  pagomensualidad: PagoMensualidad[];

  constructor(private service: ServiceService, private router: Router) { }

  imprimirLista(){
    const doc = new jsPDF(); 
  
    doc.autoTable({html: '#frmPagoMensualidad',
    columns: [{header: 'ID'},
    {header: 'CODIGO'},
    {header: 'DESCRIPCION'},
    {header: 'MONTO'},
    {header: 'VENCIMIENTO'},
    {header: 'FECHA'},
    {header: 'COD_REINSCRIPCION'},
    {header: 'ESTADO'},
    {header: 'USUARIO'}
  ],
  theme: 'striped',
  styles: {fontSize: 8,
    font: "helvetica",
    halign: 'center'}
  });
    doc.save('Lista Pago de Mensualidad');
  }

  ngOnInit() {
    this.service.getPagoMensualidad().subscribe(data => {
      this.pagomensualidad = data;
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
