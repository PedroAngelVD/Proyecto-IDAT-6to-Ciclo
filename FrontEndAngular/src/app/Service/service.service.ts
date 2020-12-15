import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Curso } from '../Curso/Modelo/Curso';
import { Profesor } from '../Profesor/Modelo/Profesor';
import { Login } from '../Login/Modelo/login';
import { Matricula } from '../Matricula/Modelo/Matricula';
import { Reinscripcion } from '../Reinscripcion/Modelo/Reinscripcion';
import { Mensualidad } from '../Mensualidad/Modelo/Mensualidad';
import { PagoMensualidad } from '../Pagos/Modelo/PagoMensualidad';
import { PagoReinscripcion } from '../Pagos/Modelo/PagoReinscripcion';
import { ListarHorario } from '../Horario/Modelo/ListarHorario';
import { ActualizarHorario } from '../Horario/Modelo/ActualizarHorario';
import { Alumno } from '../Alumno/Modelo/Alumno';
import { Datos } from '../dashboard/Modelo/Datos';
import { DatosCAP } from '../dashboard/Modelo/DatosCAP';
import { DatosCAS } from '../dashboard/Modelo/DatosCAS';
import { DatosCMY } from '../dashboard/Modelo/DatosCMY';
import { DatosCRY } from '../dashboard/Modelo/DatosCRY';
import { DatosCMM } from '../dashboard/Modelo/DatosCMM';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) { 
    
  }

  usuario='usuario';
  profesor='profesor';
  curso='curso';
  matricula='matricula';
  reinscripcion='reinscripcion';
  mensualidad='mensualidad';
  pago='pago';
  listarHorario='listarHorario';
  alumno='alumno';
  datos='datos';

  Url='/rest/';

  /** Usuario Login*/

  getUsuarios(){
    return this.http.get<Login[]>(this.Url+this.usuario);
  }

  /** Curso */

  getCursos(){
    return this.http.get<Curso[]>(this.Url+this.curso);
  }

  addCursos(curso:Curso){
    return this.http.post<Curso>(this.Url+this.curso,curso);
  }

  getCursoId(id:number){
    return this.http.get<Curso>(this.Url+this.curso+'/'+id);
  }

  updateCurso(curso:Curso){
    return this.http.put<Curso>(this.Url+this.curso+'/'+curso.id_curso, curso);
  }

  deleteCurso(curso:Curso){
    return this.http.delete<Curso>(this.Url+this.curso+'/'+curso.id_curso);
  }

  /** Profesor */

  getProfesor(){
    return this.http.get<Profesor[]>(this.Url+this.profesor);
  }

  addProfesor(profesor:Profesor){
    return this.http.post<Profesor>(this.Url+this.profesor,profesor);
  }

  getProfesorId(id:number){
    return this.http.get<Profesor>(this.Url+this.profesor+'/'+id);
  }

  updateProfesor(profesor:Profesor){
    return this.http.put<Profesor>(this.Url+this.profesor+'/'+profesor.id_profesor, profesor);
  }

  deleteProfesor(profesor:Profesor){
    return this.http.delete<Profesor>(this.Url+this.profesor+'/'+profesor.id_profesor);
  }

    /** Matricula */

    getMatricula(){
      return this.http.get<Matricula[]>(this.Url+this.matricula);
    }
  
    addMatricula(matricula:Matricula){
      return this.http.post<Matricula>(this.Url+this.matricula,matricula);
    }
  
    getMatriculaId(id:number){
      return this.http.get<Matricula>(this.Url+this.matricula+'/'+id);
    }
  
    updateMatricula(matricula:Matricula){
      return this.http.put<Matricula>(this.Url+this.matricula+'/'+matricula.id_matricula, matricula);
    }
  
    deleteMatricula(matricula:Matricula){
      return this.http.delete<Matricula>(this.Url+this.matricula+'/'+matricula.id_matricula);
    }

    /** Reinscripcion */

    getReinscripcion(){
      return this.http.get<Reinscripcion[]>(this.Url+this.reinscripcion);
    }
  
    addReinscripcion(reinscripcion:Reinscripcion){
      return this.http.post<Reinscripcion>(this.Url+this.reinscripcion,reinscripcion);
    }
  
    getReinscripcionId(id:number){
      return this.http.get<Reinscripcion>(this.Url+this.reinscripcion+'/'+id);
    }
  
    updateReinscripcion(reinscripcion:Reinscripcion){
      return this.http.put<Reinscripcion>(this.Url+this.reinscripcion+'/'+reinscripcion.id_hab_reinscripcion, reinscripcion);
    }
  
    deleteReinscripcion(reinscripcion:Reinscripcion){
      return this.http.delete<Reinscripcion>(this.Url+this.reinscripcion+'/'+reinscripcion.id_hab_reinscripcion);
    }

    getPagoReinscripcion(){
      return this.http.get<PagoReinscripcion[]>(this.Url+this.reinscripcion+'/'+this.pago);
    }

     /** Mensualidad */

     getMensualidad(){
      return this.http.get<Mensualidad[]>(this.Url+this.mensualidad);
    }
  
    addMensualidad(mensualidad:Mensualidad){
      return this.http.post<Mensualidad>(this.Url+this.mensualidad,mensualidad);
    }
  
    getMensualidadId(id:number){
      return this.http.get<Mensualidad>(this.Url+this.mensualidad+'/'+id);
    }
  
    updateMensualidad(mensualidad:Mensualidad){
      return this.http.put<Mensualidad>(this.Url+this.mensualidad+'/'+mensualidad.id_hab_mensualidad, mensualidad);
    }
  
    deleteMensualidad(mensualidad:Mensualidad){
      return this.http.delete<Mensualidad>(this.Url+this.mensualidad+'/'+mensualidad.id_hab_mensualidad);
    }

    getPagoMensualidad(){
      return this.http.get<PagoMensualidad[]>(this.Url+this.mensualidad+'/'+this.pago);
    }

    /** Listar Horario*/

    getHorario(){
      return this.http.get<ListarHorario[]>(this.Url+this.listarHorario);
    }

    /** Actualizar Horario */

    getHorariodId(id:number){
      return this.http.get<ActualizarHorario>(this.Url+this.listarHorario+'/'+id);
    }
  
    updateHorario(listarHorario:ActualizarHorario){
      return this.http.put<ActualizarHorario>(this.Url+this.listarHorario+'/'+listarHorario.id_curso_grado_detalle, listarHorario);
    }

    /** Alumno */

    getAlumno(){
      return this.http.get<Alumno[]>(this.Url+this.alumno);
    }

    getAlumnoId(id:number){
      return this.http.get<Alumno>(this.Url+this.alumno+'/'+id);
    }
  
    updateAlumno(alumno:Alumno){
      return this.http.put<Alumno>(this.Url+this.alumno+'/'+alumno.id_alumno, alumno);
    }

    /** Datos */

    getDatos(){
      return this.http.get<Datos[]>(this.Url+this.datos);
    }

    getDatosCAP(){
      return this.http.get<DatosCAP[]>(this.Url+this.datos+'/CAP');
    }

    getDatosCAS(){
      return this.http.get<DatosCAS[]>(this.Url+this.datos+'/CAS');
    }

    getDatosCMY(){
      return this.http.get<DatosCMY[]>(this.Url+this.datos+'/CMY');
    }

    getDatosCRY(){
      return this.http.get<DatosCRY[]>(this.Url+this.datos+'/CRY');
    }

    getDatosCMM(){
      return this.http.get<DatosCMM[]>(this.Url+this.datos+'/CMM');
    } 
}
