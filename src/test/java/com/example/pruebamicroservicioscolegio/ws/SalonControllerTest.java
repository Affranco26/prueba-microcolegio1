package com.example.pruebamicroservicioscolegio.ws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.pruebamicroservicioscolegio.ws.dto.AlumnosAddDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.AlumnosDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.DatosCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.MateriasAddDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.MateriasDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.RespuestaAlumnosAddDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.RespuestaCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.RespuestaMateriasAddDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.SalonDTO;
import com.example.pruebamicroservicioscolegio.ws.entity.Alumnos;
import com.example.pruebamicroservicioscolegio.ws.entity.Materias;
import com.example.pruebamicroservicioscolegio.ws.entity.Salon;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;
import com.example.pruebamicroservicioscolegio.ws.repository.AlumnoRepository;
import com.example.pruebamicroservicioscolegio.ws.repository.MateriaRepository;
import com.example.pruebamicroservicioscolegio.ws.repository.SalonRepository;
import com.example.pruebamicroservicioscolegio.ws.service.AlumnoService;
import com.example.pruebamicroservicioscolegio.ws.service.MateriaService;
import com.example.pruebamicroservicioscolegio.ws.service.SalonService;

class SalonControllerTest {
	@InjectMocks
	SalonService service;

	@InjectMocks
	AlumnoService aService;

	@InjectMocks
	MateriaService mService;

	@Mock
	SalonRepository sRepository;

	@Mock
	AlumnoRepository aRepository;

	@Mock
	MateriaRepository mRepository;

	Salon salon;
	Alumnos alumno;
	Alumnos alu;
	Materias materia;
	List<Map<String, Object>> materias;
	AlumnosAddDTO a;
	SalonDTO salonDTO1;
	List<SalonDTO> listaColegio;

	List<SalonDTO> listaColegio2;

	List<Salon> daS = new ArrayList<>();
	List<Materias> mate = new ArrayList<>();
	List<Alumnos> al = new ArrayList<>();
	Map<String, Object> mat = new HashMap<>();
	List<Map<String, Object>> alumoAdd;
	List<Map<String, Object>> materiasEmpity;
	List<Map<String, Object>> datosSalon;
	List<Map<String, Object>> datosAlumnos;
	List<Map<String, Object>> datosMaterias;
	List<Map<String, Object>> datosSalon1;
	List<Map<String, Object>> datosAlumnos1;
	List<Map<String, Object>> datosMaterias1;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
		ModelData modelData = new ModelData();
		salon = modelData.consultaNombre();
		alumno = modelData.buscarAlumnos();
		alu = modelData.buscarAlumnos();
		materia = modelData.consultaMateria();
		daS = modelData.datoSalon();
		mate = modelData.datoMaterias();
		al = modelData.datoAlumnos();
		a = modelData.aggAlum();
		alumoAdd = modelData.llenadoDatosAlumno();
		materias = modelData.consultarNombreMat();
		materiasEmpity = modelData.consultarNombreMatEmpyt();
		datosSalon = modelData.llenadoDatosSalon();
		datosAlumnos = modelData.llenadoDatosAlumno();
		datosMaterias = modelData.llenadoDatosMaterias();
		datosSalon1 = modelData.llenadoDatosSalon1();
		datosAlumnos1 = modelData.llenadoDatosAlumno1();
		datosMaterias1 = modelData.llenadoDatosMaterias1();
		mat = modelData.Materias();
		// salonDTO1 = modelData.consultarSalonMateria();
		// p1= modelData.consuNombre();

	}

	@AfterEach
	void finish() {

	}

	@Test
	void ConsultarSalonNombreTest() throws SiecaException {

		Mockito.when(sRepository.salonPorNombre("primero")).thenReturn(salon);
		SalonDTO salDTO = service.consultarSalon("primero");
		assertNotNull(salDTO);
	}

	@Test
	void ConsultarSalonNombreNullTest() throws SiecaException {

		Mockito.when(sRepository.salonPorNombre("primero")).thenReturn(null);
		SalonDTO sa1 = service.consultarSalon("primero");
		assertNull(sa1);
	}

	@Test
	void ConsultarSalonIdTest() throws SiecaException {

		Mockito.when(sRepository.getById(1)).thenReturn(salon);
		SalonDTO sal = service.consultarId(1);
		assertNotNull(sal);
	}

	@Test
	void ConsultarSalonIdNullTest() throws SiecaException {

		Mockito.when(sRepository.getById(1)).thenReturn(null);
		SalonDTO sal = service.consultarId(1);
		assertNull(sal);
	}

	@Test
	void consultarSalonMateriaTest() throws SiecaException {
		Mockito.when(sRepository.materiasNombre("Alumno")).thenReturn(materias);
		salonDTO1 = service.consultarNombreNota("Alumno");
		assertNotNull(salonDTO1);
	}

	@Test
	void consultarSalonMateriaNullTest() throws SiecaException {
		Mockito.when(sRepository.materiasNombre("Alumno")).thenReturn(null);
		salonDTO1 = service.consultarNombreNota("Alumno");
		assertNull(salonDTO1);
	}

	@Test
	void consultarSalonMatEmpyTest() throws SiecaException {
		Mockito.when(sRepository.materiasNombre("Alumno")).thenReturn(materiasEmpity);
		salonDTO1 = service.consultarNombreNota("Alumno");
		assertNull(salonDTO1);
	}

	@Test
	void datosColegioTest1() throws SiecaException {
		Mockito.when(sRepository.datosSalon()).thenReturn(datosSalon1);
		Mockito.when(sRepository.datosAlumnos()).thenReturn(datosAlumnos1);
		Mockito.when(sRepository.datosMaterias()).thenReturn(datosMaterias1);
		listaColegio2 = service.datosColegio();

		assertNotNull(listaColegio2);
	}

	@Test
	void datosColegioNullTest1() throws SiecaException {
		Mockito.when(sRepository.datosSalon()).thenReturn(null);
		Mockito.when(sRepository.datosAlumnos()).thenReturn(null);
		Mockito.when(sRepository.datosMaterias()).thenReturn(null);
		listaColegio2 = service.datosColegio();

		assertNull(listaColegio2);
	}

	@Test
	void datosColegio2() throws SiecaException {

		Mockito.when(sRepository.findAll()).thenReturn(daS);
		Mockito.when(mRepository.findAll()).thenReturn(mate);
		Mockito.when(aRepository.findAll()).thenReturn(al);
		listaColegio2 = service.datosColegio2();
		assertNotNull(listaColegio2);
	}

	@Test
	void datosColegioNull2() throws SiecaException {

		Mockito.when(sRepository.findAll()).thenReturn(null);
		Mockito.when(mRepository.findAll()).thenReturn(null);
		Mockito.when(aRepository.findAll()).thenReturn(null);
		listaColegio2 = service.datosColegio2();
		assertNull(listaColegio2);
	}

	@Test
	void agregarSalonTest() throws SiecaException {

		DatosCreacionSalonDTO sa = new DatosCreacionSalonDTO("Sexto", 20);
		RespuestaCreacionSalonDTO res = service.ingresarSalon1(sa);
		assertNotNull(res);
	}

	@Test
	void agregarSalonTest1() throws SiecaException {

		DatosCreacionSalonDTO sa = new DatosCreacionSalonDTO();
		RespuestaCreacionSalonDTO res = new RespuestaCreacionSalonDTO();
		String nombre = "Quinto";
		Integer numero = 22;
		sa.setNombreCurso(nombre);
		sa.setCapacidadAlumnos(numero);
		res = service.ingresarSalon(sa);
		assertNotNull(res);
	}

	@Test
	void ConsultarAlumnoNombreTest() throws SiecaException {
		Mockito.when(aRepository.findByNombreAlumno("Ana")).thenReturn(alumno);
		AlumnosDTO a1 = aService.consultarId("Ana");
		assertNotNull(a1);

	}

	@Test
	void ConsultarAlumnoNombreNullTest() throws SiecaException {
		Mockito.when(aRepository.findByNombreAlumno("Ana")).thenReturn(null);
		AlumnosDTO a1 = aService.consultarId("Ana");
		assertNull(a1);

	}

	@Test
	void agregarAlumnoTest() throws SiecaException {
		RespuestaAlumnosAddDTO res = aService.addAlumno(a);

		assertNotNull(res);
	}

	@Test
	void agregarAlumno2Test() throws SiecaException {

		AlumnosAddDTO a2 = new AlumnosAddDTO();

		Mockito.when(aRepository.save(alu)).thenReturn(alu);
		RespuestaAlumnosAddDTO res = aService.addAlumno1(a2);
		assertNotNull(res);
	}

	@Test
	void ConsultarMateriaNombreTest() throws SiecaException {

		Mockito.when(mRepository.findByNombreMateria("programacion")).thenReturn(mat);
		MateriasDTO ma = mService.consultarMat("programacion");
		assertNotNull(ma);
	}
	
	@Test
	void ConsultarMateriaNombreNullTest() throws SiecaException {

		Mockito.when(mRepository.findByNombreMateria("programacion")).thenReturn(null);
		MateriasDTO ma = mService.consultarMat("programacion");
		assertNull(ma);
	}

	@Test
	void agregarMateriaTest() throws SiecaException {

		MateriasAddDTO a2 = new MateriasAddDTO();

		Mockito.when(mRepository.save(materia)).thenReturn(materia);
		RespuestaMateriasAddDTO ma = mService.crearMateria(a2);
		assertNotNull(ma);
	}

 
}

