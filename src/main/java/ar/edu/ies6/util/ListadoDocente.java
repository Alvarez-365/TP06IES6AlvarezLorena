package ar.edu.ies6.util;
import java.util.ArrayList;
import java.util.List;
import ar.edu.ies6.model.docente;


public class ListadoDocente {
private static List <docente> listado = new ArrayList<>();
		
		public ListadoDocente() {
			// TODO Auto-generated constructor stub
		}
		public static List<docente> getListado() {
		return listado;
		}


		public static void setListado(List<docente> listado) {
		ListadoDocente.listado = listado;
		}

}
