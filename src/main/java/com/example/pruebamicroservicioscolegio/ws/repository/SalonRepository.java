package com.example.pruebamicroservicioscolegio.ws.repository;

import java.util.List;
import java.util.Map;

import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.pruebamicroservicioscolegio.ws.dto.DatosCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.RespuestaCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.entity.Salon;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Integer> {

	Salon findByNombreCurso(String nombreCurso);
	// Salon findById(int idSalon);

	@Query(nativeQuery = true, value = "select \"idSalon\", \"nombreCurso\", \"capacidadAlumnos\" from \"tbl_salon\"  where \"nombreCurso\" =:nombreCurso")
	Salon salonPorNombre(String nombreCurso);

	@Query(nativeQuery = true, value = "SELECT \"tbl_materias\".\"nombreMateria\", \"tbl_materias\".\"notaFinal\", \"tbl_alumnos\".\"nombreAlumno\", \"tbl_salon\".\"nombreCurso\" from \"tbl_salon\" INNER JOIN \"tbl_alumnos\" ON \"tbl_salon\".\"idSalon\"=\"tbl_alumnos\".\"idSalon\" INNER JOIN \"tbl_materias\" ON \"tbl_materias\".\"idAlumno\"= \"tbl_alumnos\".\"idAlumno\" WHERE \"tbl_alumnos\".\"nombreAlumno\"=:nombreAlumno")
	List<Map<String, Object>> materiasNombre(String nombreAlumno);

	// @Query(nativeQuery = true, value = "Select * from \"tbl_salon\" join
	// \"tbl_alumnos\" on \"tbl_salon\".\"idSalon\"=\"tbl_alumnos\".\"idSalon\" join
	// \"tbl_materias\" on \"tbl_materias\".\"idAlumno\"=
	// \"tbl_alumnos\".\"idAlumno\"")
	@Query(nativeQuery = true, value = "Select \"tbl_salon\".\"idSalon\", \"tbl_salon\".\"nombreCurso\" , \"tbl_salon\".\"capacidadAlumnos\", \"tbl_alumnos\".\"idAlumno\", \"tbl_alumnos\".\"documentoAlumno\" , \"tbl_alumnos\".\"nombreAlumno\" , \"tbl_alumnos\".\"fechaNacimiento\" , \"tbl_alumnos\".\"direccionVivienda\" , \"tbl_alumnos\".\"nombreAcudiente\",\"tbl_alumnos\".\"numeroContacto\" ,\"tbl_materias\".\"idMateria\", \"tbl_materias\".\"nombreMateria\", \"tbl_materias\".\"notaFinal\" from \"tbl_salon\" join \"tbl_alumnos\" on \"tbl_salon\".\"idSalon\"=\"tbl_alumnos\".\"idSalon\" join \"tbl_materias\" on \"tbl_materias\".\"idAlumno\"= \"tbl_alumnos\".\"idAlumno\"")
	List<Map<String, Object>> datosColegio();
	// List<Map<String, Object>> findAllDatosColegio();

	@Query(nativeQuery = true, value = "SELECT * FROM tbl_alumnos")
	List<Map<String, Object>> datosAlumnos();

	@Query(nativeQuery = true, value = "SELECT * FROM tbl_materias")
	List<Map<String, Object>> datosMaterias();

	@Query(nativeQuery = true, value = "SELECT * FROM tbl_salon")
	List<Map<String, Object>> datosSalon();


	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "INSERT INTO \"tbl_salon\"( \"nombreCurso\", \"capacidadAlumnos\")VALUES (:salonA, :num)")
	void salonAdd(String salonA, Integer num);

	@Query(nativeQuery = true, value = "SELECT * FROM \"tbl_salon\" where \"tbl_salon\".\"nombreCurso\" =:nombreSalon")
	List<Map<String, Object>> respuestaSalonAdd(String nombreSalon);

}
