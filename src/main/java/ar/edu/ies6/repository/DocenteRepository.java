package ar.edu.ies6.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.ies6.model.docente;


@Repository
public interface DocenteRepository extends CrudRepository <docente, Integer > {
	public List<docente>findEyEstado(Boolean estado);
}
