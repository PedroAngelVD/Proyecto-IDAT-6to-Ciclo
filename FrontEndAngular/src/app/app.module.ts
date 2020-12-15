import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule } from '@angular/forms';
import { ServiceService } from './Service/service.service';
import { HttpClientModule } from '@angular/common/http';
import { ListarCursoComponent } from './Curso/listar-curso/listar-curso.component';
import { CrearCursoComponent } from './Curso/crear-curso/crear-curso.component';
import { ActualizarCursoComponent } from './Curso/actualizar-curso/actualizar-curso.component';
import { ListarProfesorComponent } from './Profesor/listar-profesor/listar-profesor.component';
import { ActualizarProfesorComponent } from './Profesor/actualizar-profesor/actualizar-profesor.component';
import { CrearProfesorComponent } from './Profesor/crear-profesor/crear-profesor.component';
import { LoginComponent } from './Login/login/login.component';
import { LoginGuard } from './login.guard';
import { NoLoginGuard } from './no-login.guard';
//Gráficos
import { ChartsModule } from 'ng2-charts';
import { DashboardComponent } from './dashboard/dashboard.component';

import { NgxSpinnerModule } from "ngx-spinner";
import { ListarMatriculaComponent } from './Matricula/listar-matricula/listar-matricula.component';
import { CrearMatriculaComponent } from './Matricula/crear-matricula/crear-matricula.component';
import { ActualizarMatriculaComponent } from './Matricula/actualizar-matricula/actualizar-matricula.component';
import { ListarMensualidadComponent } from './Mensualidad/listar-mensualidad/listar-mensualidad.component';
import { CrearMensualidadComponent } from './Mensualidad/crear-mensualidad/crear-mensualidad.component';
import { ActualizarMensualidadComponent } from './Mensualidad/actualizar-mensualidad/actualizar-mensualidad.component';
import { ListarReinscripcionComponent } from './Reinscripcion/listar-reinscripcion/listar-reinscripcion.component';
import { CrearReinscripcionComponent } from './Reinscripcion/crear-reinscripcion/crear-reinscripcion.component';
import { ActualizarReinscripcionComponent } from './Reinscripcion/actualizar-reinscripcion/actualizar-reinscripcion.component';
import { ListarPagoMensualidadComponent } from './Pagos/listar-pago-mensualidad/listar-pago-mensualidad.component';
import { ListarPagoReinscripcionComponent } from './Pagos/listar-pago-reinscripcion/listar-pago-reinscripcion.component';
import { ListarHorarioComponent } from './Horario/listar-horario/listar-horario.component';
import { ActualizarHorarioComponent } from './Horario/actualizar-horario/actualizar-horario.component';
import { ListarAlumnoComponent } from './Alumno/listar-alumno/listar-alumno.component';
import { ActualizarAlumnoComponent } from './Alumno/actualizar-alumno/actualizar-alumno.component';
import { ServiceWorkerModule } from '@angular/service-worker';
import { environment } from '../environments/environment';

@NgModule({
  declarations: [
    AppComponent,
    ListarCursoComponent,
    CrearCursoComponent,
    ActualizarCursoComponent,
    ListarProfesorComponent,
    ActualizarProfesorComponent,
    CrearProfesorComponent,
    LoginComponent,
    DashboardComponent,
    ListarMatriculaComponent,
    CrearMatriculaComponent,
    ActualizarMatriculaComponent,
    ListarMensualidadComponent,
    CrearMensualidadComponent,
    ActualizarMensualidadComponent,
    ListarReinscripcionComponent,
    CrearReinscripcionComponent,
    ActualizarReinscripcionComponent,
    ListarPagoMensualidadComponent,
    ListarPagoReinscripcionComponent,
    ListarHorarioComponent,
    ActualizarHorarioComponent,
    ListarAlumnoComponent,
    ActualizarAlumnoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ChartsModule,
    NgxSpinnerModule,
    ServiceWorkerModule.register('ngsw-worker.js', { enabled: environment.production })
  ],
  providers: [ServiceService, LoginGuard, NoLoginGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
