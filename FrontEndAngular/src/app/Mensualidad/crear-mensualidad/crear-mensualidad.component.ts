import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Mensualidad } from '../Modelo/Mensualidad';

@Component({
  selector: 'app-crear-mensualidad',
  templateUrl: './crear-mensualidad.component.html',
  styleUrls: ['./crear-mensualidad.component.css']
})
export class CrearMensualidadComponent implements OnInit {

  constructor(private service: ServiceService, private router: Router) {

  }

  mensu:Mensualidad = new Mensualidad();
  
  ngOnInit() {
  }

  Guardar(monto: string, vencimiento: string){
    this.mensu.monto=+monto;
    this.mensu.vencimiento=vencimiento;
    this.service.addMensualidad(this.mensu)
    .subscribe(data=>{
      this.router.navigate(["listarMensualidad"]);
    })
  }
}
