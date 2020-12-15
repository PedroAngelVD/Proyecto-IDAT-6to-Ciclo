import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Mensualidad } from '../Modelo/Mensualidad';
import jsPDF from 'jspdf';
import 'jspdf-autotable';

declare var $:any;

@Component({
  selector: 'app-listar-mensualidad',
  templateUrl: './listar-mensualidad.component.html',
  styleUrls: ['./listar-mensualidad.component.css']
})
export class ListarMensualidadComponent implements OnInit {
  
  mensualidad: Mensualidad[];

  constructor(private service: ServiceService, private router: Router) { }

  imprimirLista(){
    const doc = new jsPDF(); 
  
    doc.autoTable({html: '#frmMensualidad',
    columns: [{header: 'ID'},
    {header: 'CODIGO'},
    {header: 'DESCRIPCION'},
    {header: 'MONTO'},
    {header: 'VENCIMIENTO'},
    {header: 'COD_REINSCRIPCION'}
  ],
  theme: 'striped',
  styles: {
    font: "helvetica",
    halign: 'center'}
  });
    doc.save('Lista Mensualidad');
  }

  ngOnInit() {
    this.service.getMensualidad().subscribe(data => {
      this.mensualidad = data;
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

  Agregar(mensualidad:number){
    this.router.navigate(["crearMensualidad"]);
  }

  Editar(mensualidad:Mensualidad):void{
    localStorage.setItem("idMensualidad", mensualidad.id_hab_mensualidad.toString());
    this.router.navigate(["actualizarMensualidad"]);
  }

  Eliminar(mensualidad:Mensualidad){
    this.service.deleteMensualidad(mensualidad)
    .subscribe(data =>{
      this.mensualidad=this.mensualidad.filter(c=>c!==mensualidad);
    })
  }

}
