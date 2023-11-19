package ar.edu.ies6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.ies6.model.alumno;
import ar.edu.ies6.repository.AlumnoRepository;

@Service
public class AlumnoService {
	@Autowired 
	AlumnoRepository alumnoRepository;
	public void guardarAlumno(alumno alumno) {
		//metodo para guardar}
		alumno.setEstado(true);
		alumnoRepository.save(alumno);
}
	public void eliminarAlumno (Integer dni) throws Exception {
		//eliminar un objeto por su identificador
		alumno auxiliar = new alumno();
		auxiliar = encontrarUnAlumno(dni);
		auxiliar.setEstado(false);
		alumnoRepository.save(auxiliar);
	}
	
		
		public List <alumno> buscarTodosAlumnos(){
		//algoritmos para buscar alunos
		//List<alumno> listado = new ArrayList<>();
		//return listado;
		return (List<alumno>) alumnoRepository.findAll();
	}
	public void modificarAlumno (alumno alumno) {
		
	}
		public alumno encontrarUnAlumno(Integer dni) throws Exception {
	
		return alumnoRepository.findById(dni).orElseThrow(()-> new Exception("Alumno no encontrado"));
		}
	}