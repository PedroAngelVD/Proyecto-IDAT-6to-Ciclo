import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarCursoComponent } from './Curso/listar-curso/listar-curso.component';
import { ActualizarCursoComponent } from './Curso/actualizar-curso/actualizar-curso.component';
import { CrearCursoComponent } from './Curso/crear-curso/crear-curso.component';

import { ListarProfesorComponent } from './Profesor/listar-profesor/listar-profesor.component';
import { ActualizarProfesorComponent } from './Profesor/actualizar-profesor/actualizar-profesor.component';
import { CrearProfesorComponent } from './Profesor/crear-profesor/crear-profesor.component';

import { ListarMatriculaComponent } from './Matricula/listar-matricula/listar-matricula.component';
import { ActualizarMatriculaComponent } from './Matricula/actualizar-matricula/actualizar-matricula.component';
import { CrearMatriculaComponent } from './Matricula/crear-matricula/crear-matricula.component';

import {LoginComponent} from './Login/login/login.component';

import {LoginGuard} from './login.guard';
import { NoLoginGuard } from './no-login.guard';

import { DashboardComponent } from './dashboard/dashboard.component';

import { ListarMensualidadComponent } from './Mensualidad/listar-mensualidad/listar-mensualidad.component';
import { ActualizarMensualidadComponent } from './Mensualidad/actualizar-mensualidad/actualizar-mensualidad.component';
import { CrearMensualidadComponent } from './Mensualidad/crear-mensualidad/crear-mensualidad.component';
import { ListarPagoMensualidadComponent } from './Pagos/listar-pago-mensualidad/listar-pago-mensualidad.component'

import { ListarReinscripcionComponent } from './Reinscripcion/listar-reinscripcion/listar-reinscripcion.component';
import { ActualizarReinscripcionComponent } from './Reinscripcion/actualizar-reinscripcion/actualizar-reinscripcion.component';
import { CrearReinscripcionComponent } from './Reinscripcion/crear-reinscripcion/crear-reinscripcion.component';
import { ListarPagoReinscripcionComponent } from './Pagos/listar-pago-reinscripcion/listar-pago-reinscripcion.component';

import { ListarHorarioComponent } from './Horario/listar-horario/listar-horario.component'
import { ActualizarHorarioComponent } from './Horario/actualizar-horario/actualizar-horario.component'

import { ListarAlumnoComponent } from './Alumno/listar-alumno/listar-alumno.component'
import { ActualizarAlumnoComponent } from './Alumno/actualizar-alumno/actualizar-alumno.component'

const routes: Routes = [
  {path: 'listarCurso', component: ListarCursoComponent, canActivate: [LoginGuard]},
  {path: 'actualizarCurso', component: ActualizarCursoComponent, canActivate: [LoginGuard]},
  {path: 'crearCurso', component: CrearCursoComponent, canActivate: [LoginGuard]},

  {path: 'listarProfesor', component: ListarProfesorComponent, canActivate: [LoginGuard]},
  {path: 'actualizarProfesor', component: ActualizarProfesorComponent, canActivate: [LoginGuard]},
  {path: 'crearProfesor', component: CrearProfesorComponent, canActivate: [LoginGuard]},

  {path: 'listarMatricula', component: ListarMatriculaComponent, canActivate: [LoginGuard]},
  {path: 'actualizarMatricula', component: ActualizarMatriculaComponent, canActivate: [LoginGuard]},
  {path: 'crearMatricula', component: CrearMatriculaComponent, canActivate: [LoginGuard]},

  {path: 'listarMensualidad', component: ListarMensualidadComponent, canActivate: [LoginGuard]},
  {path: 'actualizarMensualidad', component: ActualizarMensualidadComponent, canActivate: [LoginGuard]},
  {path: 'crearMensualidad', component: CrearMensualidadComponent, canActivate: [LoginGuard]},
  {path: 'listarPagoMensualidad', component: ListarPagoMensualidadComponent, canActivate: [LoginGuard]},

  {path: 'listarReinscripcion', component: ListarReinscripcionComponent, canActivate: [LoginGuard]},
  {path: 'actualizarReinscripcion', component: ActualizarReinscripcionComponent, canActivate: [LoginGuard]},
  {path: 'crearReinscripcion', component: CrearReinscripcionComponent, canActivate: [LoginGuard]},
  {path: 'listarPagoReinscripcion', component: ListarPagoReinscripcionComponent, canActivate: [LoginGuard]},

  {path: 'listarHorario', component: ListarHorarioComponent, canActivate: [LoginGuard]},
  {path: 'actualizarHorario', component: ActualizarHorarioComponent, canActivate: [LoginGuard]},

  {path: 'listarAlumno', component: ListarAlumnoComponent, canActivate: [LoginGuard]},
  {path: 'actualizarAlumno', component: ActualizarAlumnoComponent, canActivate: [LoginGuard]},

  {path: 'login', component: LoginComponent, canActivate: [NoLoginGuard]},

  {path: 'dashboard', component: DashboardComponent, canActivate: [LoginGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
