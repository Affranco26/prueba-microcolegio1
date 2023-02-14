package com.example.pruebamicroservicioscolegio.ws.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pruebamicroservicioscolegio.ws.entity.Materias;

@Repository
public interface MateriaRepository extends JpaRepository<Materias, Integer> {

	//Materias findByNombreMateria(String nombreMateria);

	@Query(nativeQuery = true, value = "select * from \"tbl_materias\" where \"nombreMateria\"=:nombreMateria")
	Map<String, Object> findByNombreMateria(String nombreMateria);
}
