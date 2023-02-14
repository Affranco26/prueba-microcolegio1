package com.example.pruebamicroservicioscolegio.ws.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebamicroservicioscolegio.ws.dto.AlumnosAddDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.AlumnosDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.RespuestaAlumnosAddDTO;
import com.example.pruebamicroservicioscolegio.ws.entity.Alumnos;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;
import com.example.pruebamicroservicioscolegio.ws.repository.AlumnoRepository;

@Service
public class AlumnoService {
	@Autowired
	AlumnoRepository alumnoRepository;

	public AlumnosDTO consultarId(String nombreAlumno) throws SiecaException {
		try {
			Alumnos nuAlum = alumnoRepository.findByNombreAlumno(nombreAlumno);

			if (nuAlum != null) {
				AlumnosDTO alResp = new AlumnosDTO();
				alResp.setIdAlumno(nuAlum.getIdAlumno());
				alResp.setNombreAlumno(nuAlum.getNombreAlumno());
				alResp.setDocumentoAlumno(nuAlum.getDocumentoAlumno());
				alResp.setFechaNacimiento(nuAlum.getFechaNacimiento());
				alResp.setNombreAcudiente(nuAlum.getNombreAcudiente());
				alResp.setNumeroContacto(nuAlum.getNumeroContacto());
				alResp.setDireccionVivienda(nuAlum.getDireccionVivienda());
				alResp.setIdSalon(nuAlum.getIdSalon());

				return alResp;
			}
		} catch (Exception e) {
			// TODO: handle exception
			// throw new SiecaException("400", e.getMessage());
			return null;
		}

		return null;
	}

	public RespuestaAlumnosAddDTO addAlumno(AlumnosAddDTO alumno) {

		AlumnosAddDTO alum = new AlumnosAddDTO();
		RespuestaAlumnosAddDTO respuestaAlum = new RespuestaAlumnosAddDTO();
		String documentoAlumno = alumno.getDocumentoAlumno();
		String nombre = alumno.getNombreAlumno();
		Date fecha =alumno.getFechaNacimiento();
		String direccion = alumno.getDireccionVivienda();
		String Acudiente= alumno.getNombreAcudiente();
		String contacto= alumno.getNumeroContacto();
		Integer idSalon = alumno.getIdSalon();
		
		alumnoRepository.alumnoAdd(documentoAlumno, nombre, fecha, direccion, Acudiente, contacto, idSalon);
		List<Map<String, Object>> resp = alumnoRepository.respuestaAlumnoAdd(nombre);

		for (Map<String, Object> map : resp) {
			
			respuestaAlum.setIdAlumno(Integer.parseInt(map.get("idAlumno").toString()));
			respuestaAlum.setNombreAlumno(map.get("nombreAlumno").toString());
			respuestaAlum.setDireccionVivienda(map.get("direccionVivienda").toString());
			respuestaAlum.setDocumentoAlumno(map.get("documentoAlumno").toString());
			respuestaAlum.setFechaNacimiento(fecha);
			respuestaAlum.setIdSalon(Integer.parseInt(map.get("idSalon").toString()));
			respuestaAlum.setNombreAcudiente(map.get("nombreAcudiente").toString());
			respuestaAlum.setNumeroContacto(map.get("numeroContacto").toString());
	}
		return respuestaAlum;
	}

	public RespuestaAlumnosAddDTO addAlumno1(AlumnosAddDTO alumno) {

		Alumnos alum = new Alumnos();
		RespuestaAlumnosAddDTO respuestaAlum = new RespuestaAlumnosAddDTO();

		alum.setNombreAlumno(alumno.getNombreAlumno());
		alum.setDocumentoAlumno(alumno.getDocumentoAlumno());
		alum.setFechaNacimiento(alumno.getFechaNacimiento());
		alum.setDireccionVivienda(alumno.getDireccionVivienda());
		alum.setNombreAcudiente(alumno.getNombreAcudiente());
		alum.setNumeroContacto(alumno.getNumeroContacto());
		alum.setIdSalon(alumno.getIdSalon());
		alumnoRepository.save(alum);

		Alumnos al = alumnoRepository.save(alum);

		if (al != null) {

			respuestaAlum.setIdAlumno(al.getIdAlumno());
			respuestaAlum.setNombreAlumno(al.getNombreAlumno());
			respuestaAlum.setDireccionVivienda(al.getDireccionVivienda());
			respuestaAlum.setDocumentoAlumno(al.getDocumentoAlumno());
			respuestaAlum.setFechaNacimiento(al.getFechaNacimiento());
			respuestaAlum.setIdSalon(al.getIdSalon());
			respuestaAlum.setNombreAcudiente(al.getNombreAcudiente());
			respuestaAlum.setNumeroContacto(al.getNumeroContacto());
		}

		return respuestaAlum;
	}

}
