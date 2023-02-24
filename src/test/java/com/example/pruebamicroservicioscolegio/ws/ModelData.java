package com.example.pruebamicroservicioscolegio.ws;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.example.pruebamicroservicioscolegio.ws.dto.AlumnosAddDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.AlumnosDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.MateriasDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.SalonDTO;
import com.example.pruebamicroservicioscolegio.ws.entity.Alumnos;
import com.example.pruebamicroservicioscolegio.ws.entity.Materias;
import com.example.pruebamicroservicioscolegio.ws.entity.Salon;
import com.example.pruebamicroservicioscolegio.ws.service.AlumnoService;

public class ModelData {

	public Salon consultaNombre() {
		Salon rSa = new Salon();
		rSa.setIdSalon(1);
		rSa.setNombreCurso("primero");
		rSa.setCapacidadAlumnos(21);

		return rSa;
	}
	/*
	 * 
	 * public SalonDTO consultarSalonMateria() { SalonDTO sa = new SalonDTO();
	 * AlumnosDTO al= new AlumnosDTO(); List<MateriasDTO> mat= new ArrayList<>();
	 * List<AlumnosDTO> alum = new ArrayList<>(); al.setMateria(mat);
	 * sa.setAlumnos(alum);
	 * 
	 * return sa;
	 * 
	 * }
	 * 
	 * public List<SalonDTO> alistaSalon() { List<SalonDTO> sa = new ArrayList<>();
	 * SalonDTO sal = new SalonDTO();
	 * 
	 * List<MateriasDTO> ma = new ArrayList<>(); MateriasDTO mat = new
	 * MateriasDTO(); mat.setIdAlumno(1); mat.setNombreMateria("programacion");
	 * mat.setNotaFinal(3.5); mat.setIdMateria(1); ma.add(mat);
	 * 
	 * List<AlumnosDTO> al = new ArrayList<>(); AlumnosDTO alum = new AlumnosDTO();
	 * alum.setIdAlumno(1); alum.setDireccionVivienda("calle 2");
	 * alum.setDocumentoAlumno("456"); alum.setFechaNacimiento(null);
	 * alum.setIdSalon(2); alum.setNombreAcudiente("fer");
	 * alum.setNumeroContacto("879876"); alum.setMateria(ma); al.add(alum);
	 * sal.setIdSalon(1); sal.setNombreSalon("Primero"); sal.setCantidad(33);
	 * sal.setAlumnos(al);
	 * 
	 * sa.add(sal); return sa;
	 * 
	 * }
	 */

	public List<Salon> datoSalon() {
		List<Salon> daS = new ArrayList<>();

		Salon sa = new Salon();
		sa.setIdSalon(1);
		sa.setNombreCurso("Info");
		sa.setCapacidadAlumnos(33);
		daS.add(sa);
		return daS;
	}

	public List<Materias> datoMaterias() {
		List<Materias> mate = new ArrayList<>();
		Materias mat = new Materias();
		mat.setIdAlumno(1);
		mat.setNombreMateria("programacion");
		mat.setNotaFinal(3.5);
		mat.setIdMateria(1);

		mate.add(mat);
		return mate;
	}

	public List<Alumnos> datoAlumnos() {
		List<Alumnos> al = new ArrayList<>();
		Alumnos alum = new Alumnos();
		alum.setIdAlumno(1);
		alum.setNombreAlumno("Ana");
		alum.setDireccionVivienda("calle 2");
		alum.setDocumentoAlumno("456");
		alum.setFechaNacimiento(null);
		alum.setIdSalon(1);
		alum.setNombreAcudiente("fer");
		alum.setNumeroContacto("879876");

		al.add(alum);
		return al;
	}

	public AlumnosAddDTO aggAlum() {

		AlumnosAddDTO alum = new AlumnosAddDTO();
		// alum.setIdAlumno(1);
		alum.setDireccionVivienda("calle 2");
		alum.setDocumentoAlumno("456");
		alum.setFechaNacimiento(null);
		alum.setIdSalon(1);
		alum.setNombreAcudiente("fer");
		alum.setNumeroContacto("879876");
		alum.setNombreAlumno("Ana");

		return alum;
	}

	public Alumnos buscarAlumnos() {

		Alumnos alum = new Alumnos();
		alum.setIdAlumno(1);
		alum.setNombreAlumno("prueba");
		alum.setDireccionVivienda("calle 2");
		alum.setDocumentoAlumno("456");
	    alum.setFechaNacimiento(null);
		alum.setIdSalon(2);
		alum.setNombreAcudiente("fer");
		alum.setNumeroContacto("879876");
		return alum;
	}

	public Materias consultaMateria() {

		Materias mat = new Materias();
		mat.setIdAlumno(1);
		mat.setNombreMateria("programacion");
		mat.setNotaFinal(3.5);
		mat.setIdMateria(1);

		return mat;

	}

	public Map<String, Object> Materias() {

		Map<String, Object> p = new HashMap<String, Object>();

		p.put("idMateria", "1");
		p.put("nombreMateria", "Fisica");
		p.put("notaFinal", "3.5");
		p.put("idAlumno", "1");
		MateriasDTO resp = new MateriasDTO();

		return p;
	}

	List<Map<String, Object>> consultarNombreMat() {
		List<Map<String, Object>> lisMate = new ArrayList<>();
		Map<String, Object> p = new HashMap<String, Object>();

		p.put("idSalon", "1");
		p.put("nombreCurso", "primero");
		p.put("capacidadAlumnos", "12");
		// p.put( "idAlumno", "2");

		lisMate.add(p);

		return lisMate;
	}

	List<Map<String, Object>> consultarNombreMatEmpyt() {
		List<Map<String, Object>> lisMate = new ArrayList<>();

		return lisMate;
	}

	List<Map<String, Object>> llenadoDatosSalon() {
		List<Map<String, Object>> lisMate = new ArrayList<>();
		Map<String, Object> p = new HashMap<String, Object>();

		p.put("idSalon", "1");
		p.put("nombreCurso", "primero");
		p.put("capacidadAlumnos", "12");
		p.put("idAlumno", "2");

		lisMate.add(p);

		return lisMate;
	}

	List<Map<String, Object>> llenadoDatosMaterias() {
		List<Map<String, Object>> lisMate = new ArrayList<>();
		Map<String, Object> p = new HashMap<String, Object>();

		p.put("idMateria", "1");
		p.put("nombreMateria", "Fisica");
		p.put("notaFinal", "2.6");
		p.put("idAlumno", "1");

		lisMate.add(p);

		return lisMate;
	}

	List<Map<String, Object>> llenadoDatosAlumno() {
		List<Map<String, Object>> lisMate = new ArrayList<>();
		Map<String, Object> p = new HashMap<String, Object>();

		p.put("idAlumno", "1");
		p.put("nombreAlumno", "Ana");
		p.put("documentoAlumno", "123");
		p.put("fechaNacimiento", "25/02/2022");
		p.put("direccionVivienda", "calle 2");
		p.put("nombreAcudiente", "franco");
		p.put("numeroContacto", "312");
		p.put("idSalon", "1");

		lisMate.add(p);

		return lisMate;
	}

	List<Map<String, Object>> llenadoDatosSalon1() {
		List<Map<String, Object>> lisMate = new ArrayList<>();
		Map<String, Object> p = new HashMap<String, Object>();

		p.put("idSalon", "1");
		p.put("nombreCurso", "primero");
		p.put("capacidadAlumnos", "12");
		p.put("idAlumno", "2");

		lisMate.add(p);

		return lisMate;
	}

	List<Map<String, Object>> llenadoDatosMaterias1() {
		List<Map<String, Object>> lisMate = new ArrayList<>();

		Map<String, Object> p = new HashMap<String, Object>();
		p.put("idMateria", "1");
		p.put("nombreMateria", "Fisica");
		p.put("notaFinal", "2.6");
		p.put("idAlumno", "1");

		lisMate.add(p);

		return lisMate;
	}

	List<Map<String, Object>> llenadoDatosAlumno1() {
		List<Map<String, Object>> lisMate = new ArrayList<>();

		Map<String, Object> p = new HashMap<String, Object>();
		p.put("idAlumno", "1");
		p.put("nombreAlumno", "Ana");
		p.put("documentoAlumno", "123");
		// p.put("fechaNacimiento", "25/02/2022");
		p.put("direccionVivienda", "calle 2");
		p.put("nombreAcudiente", "franco");
		p.put("numeroContacto", "312");
		p.put("idSalon", "1");

		lisMate.add(p);

		return lisMate;
	}

}
