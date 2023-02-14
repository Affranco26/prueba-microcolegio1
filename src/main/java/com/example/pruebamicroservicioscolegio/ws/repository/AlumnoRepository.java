package com.example.pruebamicroservicioscolegio.ws.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.pruebamicroservicioscolegio.ws.dto.AlumnosAddDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.DatosCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.entity.Alumnos;
import com.example.pruebamicroservicioscolegio.ws.entity.Salon;

public interface AlumnoRepository extends JpaRepository<Alumnos, Integer> {

	Alumnos findByNombreAlumno(String nombreAlumno); 
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "INSERT INTO \"tbl_alumnos\"(\"documentoAlumno\", \"nombreAlumno\", \"fechaNacimiento\", \"direccionVivienda\", \"nombreAcudiente\", \"numeroContacto\", \"idSalon\")VALUES(:documentoAlumno, :nombre, :fecha, :direccion, :acudiente, :contacto, :idSalon)")
	void alumnoAdd(String documentoAlumno, String nombre, Date fecha, String direccion, String acudiente, String contacto, Integer idSalon);

	@Query(nativeQuery = true, value = "SELECT * FROM \"tbl_alumnos\" where \"tbl_alumnos\".\"nombreAlumno\" =:nombreAlumno")
	List<Map<String, Object>> respuestaAlumnoAdd(String nombreAlumno);

}
