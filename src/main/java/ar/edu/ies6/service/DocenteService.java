package ar.edu.ies6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.ies6.model.docente;
import ar.edu.ies6.repository.DocenteRepository;

public class DocenteService {
	@Autowired
	DocenteRepository docenteRepository;
	public void guardarDocente(docente docente) {
		//metodo para guardar
		docente.setEstado(true);
		docenteRepository.save(docente);
		
}
	public void eliminarDocente (Integer dni) throws Exception {
		//eliminar un objeto por su identificador
		docente auxiliar = new docente();
		auxiliar = encontrarUnDocente(dni);
		auxiliar.setEstado(false);
		docenteRepository.save(auxiliar);
	}
	
	public List <docente> buscarTodosDocente(){
		//algoritmos para buscar DOCENTE
		//List<docente> listado = new ArrayList<>();
		//return listado;
		return (List<docente>) docenteRepository.findAll();
	}
	public void modificarDocente (docente docente) {
		
	}
		public docente encontrarUnDocente(Integer dni) throws Exception {
	
			return docenteRepository.findById(dni).orElseThrow(()-> new Exception("docente no encontrado"));
		}
	}


