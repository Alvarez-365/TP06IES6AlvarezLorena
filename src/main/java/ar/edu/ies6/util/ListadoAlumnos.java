package ar.edu.ies6.util;

import java.util.ArrayList;
import java.util.List;
import ar.edu.ies6.model.alumno;


 public class ListadoAlumnos {

	private static List <alumno> listado = new ArrayList<>();
	
	public ListadoAlumnos() {
		// TODO Auto-generated constructor stub
	}
	public static List<alumno> getListado() {
	return listado;
	}


	public static void setListado(List<alumno> listado) {
	ListadoAlumnos.listado = listado;
	}



}
