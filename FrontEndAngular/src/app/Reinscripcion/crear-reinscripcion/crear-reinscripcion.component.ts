import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Reinscripcion } from '../Modelo/Reinscripcion';

@Component({
  selector: 'app-crear-reinscripcion',
  templateUrl: './crear-reinscripcion.component.html',
  styleUrls: ['./crear-reinscripcion.component.css']
})
export class CrearReinscripcionComponent implements OnInit {

  constructor(private service: ServiceService, private router: Router) {

  }

  res:Reinscripcion = new Reinscripcion();
  
  ngOnInit() {
  }

  Guardar(descripcion: string, monto: string, vencimiento: string){
    this.res.descripcion=descripcion;
    this.res.monto=+monto;
    this.res.vencimiento=vencimiento;
    this.service.addReinscripcion(this.res)
    .subscribe(data=>{
      this.router.navigate(["listarReinscripcion"]);
    })
  }

}
