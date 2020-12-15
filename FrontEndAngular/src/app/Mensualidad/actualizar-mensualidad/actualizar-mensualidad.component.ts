import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Mensualidad } from '../Modelo/Mensualidad';

@Component({
  selector: 'app-actualizar-mensualidad',
  templateUrl: './actualizar-mensualidad.component.html',
  styleUrls: ['./actualizar-mensualidad.component.css']
})
export class ActualizarMensualidadComponent implements OnInit {

  constructor(private router:Router, private service:ServiceService) { }

  mensualidad:Mensualidad = new Mensualidad();

  ngOnInit() {
    this.Editar();
  }

  Editar(){
    let id = localStorage.getItem("idMensualidad");
    this.service.getMensualidadId(+id)
    .subscribe(data =>{
      this.mensualidad = data;
    })
  }

  Actualizar(monto: string, vencimiento: string){
    this.mensualidad.monto=+monto;
    this.mensualidad.vencimiento=vencimiento;
    this.service.updateMensualidad(this.mensualidad)
    .subscribe(data => {
      this.router.navigate(["listarMensualidad"]);
    })
  }

}
