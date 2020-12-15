import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../../Service/service.service';
import { Curso } from '../Modelo/Curso';

@Component({
  selector: 'app-crear-curso',
  templateUrl: './crear-curso.component.html',
  styleUrls: ['./crear-curso.component.css']
})
export class CrearCursoComponent implements OnInit {

  constructor(private service: ServiceService, private router: Router) {

   }

  cur:Curso = new Curso();

  ngOnInit() {
  }

  Guardar(curso:string){
    this.cur.curso=curso;
    this.service.addCursos(this.cur)
    .subscribe(data=>{
      this.router.navigate(["listarCurso"]);
    })
  }

}
