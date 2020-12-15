import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Reinscripcion } from '../Modelo/Reinscripcion';
import jsPDF from 'jspdf';
import 'jspdf-autotable';

declare var $:any;

@Component({
  selector: 'app-listar-reinscripcion',
  templateUrl: './listar-reinscripcion.component.html',
  styleUrls: ['./listar-reinscripcion.component.css']
})
export class ListarReinscripcionComponent implements OnInit {

  reinscripcion: Reinscripcion[];

  constructor(private service: ServiceService, private router: Router) { }

  imprimirLista(){
    const doc = new jsPDF(); 
  
    doc.autoTable({html: '#frmReinscripcion',
    columns: [{header: 'ID'},
    {header: 'CODIGO'},
    {header: 'DESCRIPCION'},
    {header: 'MONTO'},
    {header: 'VENCIMIENTO'}
  ],
  theme: 'striped',
  styles: {
    font: "helvetica",
    halign: 'center'}
  });
    doc.save('Lista Reinscripcion');
  }


  ngOnInit() {
    this.service.getReinscripcion().subscribe(data => {
      this.reinscripcion = data;
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
    this.router.navigate(["crearReinscripcion"]);
  }

  Editar(reinscripcion:Reinscripcion):void{
    localStorage.setItem("idReinscripcion", reinscripcion.id_hab_reinscripcion.toString());
    this.router.navigate(["actualizarReinscripcion"]);
  }

  Eliminar(reinscripcion:Reinscripcion){
    this.service.deleteReinscripcion(reinscripcion)
    .subscribe(data =>{
      this.reinscripcion=this.reinscripcion.filter(c=>c!==reinscripcion);
    })
  }
}
