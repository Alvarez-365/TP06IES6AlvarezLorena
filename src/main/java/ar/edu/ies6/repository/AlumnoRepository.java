package ar.edu.ies6.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.ies6.model.alumno;



@Repository
public interface AlumnoRepository extends CrudRepository <alumno, Integer > {

}