package com.example.pruebamicroservicioscolegio.ws.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebamicroservicioscolegio.ws.dto.AlumnosDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.DatosCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.MateriasDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.RespuestaCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.SalonDTO;
import com.example.pruebamicroservicioscolegio.ws.entity.Alumnos;
import com.example.pruebamicroservicioscolegio.ws.entity.Materias;
import com.example.pruebamicroservicioscolegio.ws.entity.Salon;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;
import com.example.pruebamicroservicioscolegio.ws.repository.AlumnoRepository;
import com.example.pruebamicroservicioscolegio.ws.repository.MateriaRepository;
import com.example.pruebamicroservicioscolegio.ws.repository.SalonRepository;

@Service
public class SalonService {

	@Autowired
	SalonRepository salonRepository;

	@Autowired
	AlumnoRepository alumnoRepository;

	@Autowired
	MateriaRepository materiaRepository;

	public SalonDTO consultarSalon(String nombreSalon) {
		// Salon respSa = salonRepository.findByNombreCurso(nombreSalon);
		// Salon respSa = salonRepository.getById(null)
		Map<String, Object> respSa = salonRepository.salonPorNombre(nombreSalon);
		if (respSa != null) {
			SalonDTO respuesta = new SalonDTO();
			// System.out.println("Esto es lo que devuelve la consulta " + respSa);
			respuesta.setIdSalon(Integer.parseInt(respSa.get("idSalon").toString()));
			respuesta.setNombreSalon(respSa.get("nombreCurso").toString());
			respuesta.setCantidad(Integer.parseInt(respSa.get("capacidadAlumnos").toString()));
			return respuesta;
		}

		return null;
	}

	public SalonDTO consultarId(Integer idSalon) throws SiecaException {
		try {
			Salon idSa = salonRepository.getById(idSalon);

			if (idSa != null) {
				SalonDTO idResp = new SalonDTO();
				idResp.setIdSalon(idSa.getIdSalon());
				idResp.setNombreSalon(idSa.getNombreCurso());
				idResp.setCantidad(idSa.getCapacidadAlumnos());
				return idResp;
			}
		} catch (Exception e) {
			// TODO: handle exception
			// throw new SiecaException("400", e.getMessage());
			return null;
		}

		return null;
	}

	public SalonDTO consultarNombreNota(String nombreAlumno) {
		try {
			List<Map<String, Object>> respuestaNotas = salonRepository.materiasNombre(nombreAlumno);

			if (respuestaNotas != null && !respuestaNotas.isEmpty()) {

				SalonDTO saDTO = new SalonDTO();
				saDTO.setNombreSalon(respuestaNotas.get(0).get("nombreCurso") == null ? "No se encontro nombre"
						: respuestaNotas.get(0).get("nombreCurso").toString());
				List<AlumnosDTO> listaAlumnos = new ArrayList<>();
				AlumnosDTO alumno = new AlumnosDTO();
				alumno.setNombreAlumno(respuestaNotas.get(0).get("nombreAlumno") == null ? null
						: respuestaNotas.get(0).get("nombreAlumno").toString());
				alumno.setNombreAcudiente(
						respuestaNotas.get(0).get("nombreAcudiente") == null ? "No se encontro nombre Acudiente"
								: respuestaNotas.get(0).get("nombreAcudiente").toString());
				listaAlumnos.add(alumno);

				List<MateriasDTO> listaMaterias = new ArrayList<>();

				for (Map<String, Object> map : respuestaNotas) {

					MateriasDTO matDTO = new MateriasDTO();
					matDTO.setNombreMateria(
							map.get("nombreMateria") == null ? "No existe dato" : map.get("nombreMateria").toString());
					matDTO.setNotaFinal(
							map.get("notaFinal") == null ? null : Double.parseDouble(map.get("notaFinal").toString()));
					matDTO.setIdMateria(
							map.get("idMateria") == null ? null : Integer.parseInt(map.get("idMateria").toString()));
					listaMaterias.add(matDTO);

				}
				alumno.setMateria(listaMaterias);
				saDTO.setAlumnos(listaAlumnos);
				return saDTO;
			}
			return null;

		} catch (Exception e) {

			return null;
		}
	}

	public List<SalonDTO> datosColegio() {
		try {
			List<Map<String, Object>> datosSalon = salonRepository.datosSalon();
			List<Map<String, Object>> datosAlumnos = salonRepository.datosAlumnos();
			List<Map<String, Object>> datosMaterias = salonRepository.datosMaterias();

			List<SalonDTO> listaSalon = new ArrayList<>();
			for (Map<String, Object> mapDatosSalones : datosSalon) {
				int llaveSalon = Integer.parseInt(mapDatosSalones.get("idSalon").toString());
				SalonDTO salon = new SalonDTO();
				salon.setNombreSalon(mapDatosSalones.get("nombreCurso").toString());
				salon.setCantidad(Integer.parseInt(mapDatosSalones.get("capacidadAlumnos").toString()));
				salon.setIdSalon(Integer.parseInt(mapDatosSalones.get("idSalon").toString()));

				List<AlumnosDTO> listaAlumnos = new ArrayList<>();
				for (Map<String, Object> mapDatosAlumnos : datosAlumnos) {
					int llaveAlumnosSalon = Integer.parseInt(mapDatosAlumnos.get("idSalon").toString());

					if (llaveAlumnosSalon == llaveSalon) {
						AlumnosDTO alumno = new AlumnosDTO();
						alumno.setIdAlumno(Integer.parseInt(mapDatosAlumnos.get("idAlumno").toString()));
						alumno.setNombreAlumno(mapDatosAlumnos.get("nombreAlumno").toString());
						alumno.setDireccionVivienda(mapDatosAlumnos.get("direccionVivienda").toString());
						alumno.setDocumentoAlumno(mapDatosAlumnos.get("documentoAlumno").toString());
						alumno.setIdSalon(Integer.parseInt(mapDatosAlumnos.get("idSalon").toString()));
						alumno.setFechaNacimiento(Date.valueOf(mapDatosAlumnos.get("fechaNacimiento").toString()));
						alumno.setNombreAcudiente(mapDatosAlumnos.get("nombreAcudiente").toString());
						alumno.setNumeroContacto(mapDatosAlumnos.get("numeroContacto").toString());

						List<MateriasDTO> listaMaterias = new ArrayList<>();
						for (Map<String, Object> mapDatosMaterias : datosMaterias) {
							int llaveMateria = Integer.parseInt(mapDatosMaterias.get("idAlumno").toString());
							if (llaveMateria == alumno.getIdAlumno()) {
								MateriasDTO materia = new MateriasDTO();
								materia.setIdMateria(Integer.parseInt(mapDatosMaterias.get("idMateria").toString()));
								materia.setIdAlumno(Integer.parseInt(mapDatosMaterias.get("idAlumno").toString()));
								materia.setNombreMateria(mapDatosMaterias.get("nombreMateria").toString());
								materia.setNotaFinal(Double.parseDouble(mapDatosMaterias.get("notaFinal").toString()));
								listaMaterias.add(materia);
							}
						}
						alumno.setMateria(listaMaterias);
						listaAlumnos.add(alumno);
					}
				}
				salon.setAlumnos(listaAlumnos);
				listaSalon.add(salon);
			}
			return listaSalon;

		} catch (Exception e) {

			return null;
		}

	}

	public List<SalonDTO> datosColegio2() {
		try {
			List<Salon> lisSalones = salonRepository.findAll();
			List<Alumnos> listaAlumnos = alumnoRepository.findAll();
			List<Materias> listaMaterias = materiaRepository.findAll();

			List<SalonDTO> listaSalon = new ArrayList<>();
			for (Salon salon : lisSalones) {
				int llaveSlon = salon.getIdSalon();
				SalonDTO salon2 = new SalonDTO();
				salon2.setNombreSalon(salon.getNombreCurso());
				salon2.setCantidad(salon.getCapacidadAlumnos());
				salon2.setIdSalon(salon.getIdSalon());

				List<AlumnosDTO> lisAlum = new ArrayList<>();
				for (Alumnos alumnos : listaAlumnos) {
					int llaveSalonAlumno = alumnos.getIdSalon();

					if (llaveSalonAlumno == llaveSlon) {
						AlumnosDTO al = new AlumnosDTO();
						al.setNombreAlumno(alumnos.getNombreAlumno());
						al.setIdAlumno(alumnos.getIdAlumno());
						al.setDireccionVivienda(alumnos.getDireccionVivienda());
						al.setDocumentoAlumno(alumnos.getDocumentoAlumno());
						al.setFechaNacimiento(alumnos.getFechaNacimiento());
						al.setIdSalon(alumnos.getIdSalon());
						al.setNombreAcudiente(alumnos.getNombreAcudiente());
						al.setNumeroContacto(alumnos.getNumeroContacto());

						List<MateriasDTO> lisMat = new ArrayList<>();
						for (Materias materias : listaMaterias) {
							int llaveMatAlu = materias.getIdAlumno();
							if (llaveMatAlu == al.getIdAlumno()) {
								MateriasDTO mat = new MateriasDTO();
								mat.setNombreMateria(materias.getNombreMateria());
								mat.setIdAlumno(materias.getIdAlumno());
								mat.setNotaFinal(materias.getNotaFinal());
								mat.setIdMateria(materias.getIdMateria());
								lisMat.add(mat);
							}
						}
						al.setMateria(lisMat);
						lisAlum.add(al);
					}

				}
				salon2.setAlumnos(lisAlum);
				listaSalon.add(salon2);
			}

			return listaSalon;
		} catch (Exception e) {

			return null;
		}
	}

	public RespuestaCreacionSalonDTO ingresarSalon(DatosCreacionSalonDTO datosCreacionSalon) {
		Salon salon = new Salon();
		salon.setNombreCurso(datosCreacionSalon.getNombreCurso());
		salon.setCapacidadAlumnos(datosCreacionSalon.getCapacidadAlumnos());
		salonRepository.save(salon);
		RespuestaCreacionSalonDTO respuesta = new RespuestaCreacionSalonDTO();
		respuesta.setIdSalon(salon.getIdSalon());
		respuesta.setNombreSalon(salon.getNombreCurso());
		respuesta.setCantidad(salon.getCapacidadAlumnos());
		return respuesta;
	}

	public RespuestaCreacionSalonDTO ingresarSalon1(DatosCreacionSalonDTO datosCreacionSalon) {
		try {
			String nombre = datosCreacionSalon.getNombreCurso();
			Integer numero = datosCreacionSalon.getCapacidadAlumnos();
			RespuestaCreacionSalonDTO respuesta = new RespuestaCreacionSalonDTO();
			System.out.println("---** " + datosCreacionSalon.getNombreCurso());
			System.out.println("...** " + datosCreacionSalon.getCapacidadAlumnos());
			salonRepository.salonAdd(nombre, numero);

			List<Map<String, Object>> resp = salonRepository.respuestaSalonAdd(nombre);

			for (Map<String, Object> map : resp) {
				respuesta.setIdSalon(Integer.parseInt(map.get("idSalon").toString()));
				System.out.println(respuesta.getIdSalon());
				respuesta.setNombreSalon(map.get("nombreCurso").toString());
				respuesta.setCantidad(Integer.parseInt(map.get("capacidadAlumnos").toString()));

			}

			return respuesta;
			
		} catch (Exception MethodArgumentNotValidException) {
			// TODO: handle exception
			return null;
		}

	}

	// Servicio que ingrese un alumno a cualquier salon y una materiaal alumno
	// ingresado
	// query nativa, validar body(validar que no vayan nuloos ni en blanco, mensaje
	// de aviso dato faltante)
}
