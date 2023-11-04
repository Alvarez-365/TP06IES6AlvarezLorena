package ar.edu.ies6.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.ies6.model.alumno;

@Service
public class AlumnoService {
	public void guardarAlumno(alumno alumno) {
		//metodo para guardar
}
	public void eliminarAlumno (Integer dni) {
		//eliminar un objeto por su identificador
	}
	public List <alumno> buscarTodosAlumnos(){
		//algoritmos para buscar alunos
		List<alumno> listado = new ArrayList<>();
		return listado;
	}
	}