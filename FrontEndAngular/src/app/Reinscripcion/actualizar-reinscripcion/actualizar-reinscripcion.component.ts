import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Reinscripcion } from '../Modelo/Reinscripcion';

@Component({
  selector: 'app-actualizar-reinscripcion',
  templateUrl: './actualizar-reinscripcion.component.html',
  styleUrls: ['./actualizar-reinscripcion.component.css']
})
export class ActualizarReinscripcionComponent implements OnInit {

  constructor(private router:Router, private service:ServiceService) { }

  reinscripcion:Reinscripcion = new Reinscripcion();

  ngOnInit() {
    this.Editar();
  }

  Editar(){
    let id = localStorage.getItem("idReinscripcion");
    this.service.getReinscripcionId(+id)
    .subscribe(data =>{
      this.reinscripcion = data;
    })
  }

  Actualizar(descripcion: string, monto: string, vencimiento: string){
    this.reinscripcion.descripcion=descripcion;
    this.reinscripcion.monto=+monto;
    this.reinscripcion.vencimiento=vencimiento;
    this.service.updateReinscripcion(this.reinscripcion)
    .subscribe(data => {
      this.router.navigate(["listarReinscripcion"]);
    })
  }

}
