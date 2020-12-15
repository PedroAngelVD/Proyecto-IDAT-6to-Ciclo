import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { ActualizarHorario } from '../Modelo/ActualizarHorario';


@Component({
  selector: 'app-actualizar-horario',
  templateUrl: './actualizar-horario.component.html',
  styleUrls: ['./actualizar-horario.component.css']
})
export class ActualizarHorarioComponent implements OnInit {

  constructor(private router:Router, private service:ServiceService) { }

  actualizarHorario:ActualizarHorario = new ActualizarHorario();

  ngOnInit() {
    this.Editar()
  }

  Editar(){
    let id = localStorage.getItem("idActualizarHorario");
    this.service.getHorariodId(+id)
    .subscribe(data =>{
      this.actualizarHorario = data;
    })
  }

  Actualizar(actualizarHorario:ActualizarHorario){
    this.service.updateHorario(actualizarHorario)
    .subscribe(data => {
      this.router.navigate(["listarHorario"]);
    })
  }

}
