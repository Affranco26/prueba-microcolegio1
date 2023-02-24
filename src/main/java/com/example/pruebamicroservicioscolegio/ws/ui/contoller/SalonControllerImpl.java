package com.example.pruebamicroservicioscolegio.ws.ui.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebamicroservicioscolegio.ws.dto.AlumnosAddDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.DatosCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.ResponseDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.RespuestaAlumnosAddDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.RespuestaCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.SalonAlumnoMateriaDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.SalonDTO;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;
import com.example.pruebamicroservicioscolegio.ws.service.SalonService;

@RestController
public class SalonControllerImpl implements SalonController {

	@Autowired
	SalonService salonService;

	@Override
	public ResponseEntity<ResponseDTO> consultarSalonNombre(String nombreSalon) throws SiecaException {

		SalonDTO respuesta = salonService.consultarSalon(nombreSalon);
		ResponseDTO responseDTO = new ResponseDTO();
		if (respuesta != null) {
			responseDTO.setResponse(respuesta);
			responseDTO.getServiceException().setMessageId("200");
			responseDTO.getServiceException().setText("La operación fue exitosa.");
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		} else {
			responseDTO.setResponse(null);
			responseDTO.getServiceException().setMessageId("400");
			responseDTO.getServiceException().setText("Fallo en la operación.");
			responseDTO.getServiceException().setVariables("No existe salon con el nombre registrado.");
			return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
		}

	}

	@Override
	public ResponseEntity<ResponseDTO> consultarSalonId(Integer idSalon) throws SiecaException {

		SalonDTO respuesta = salonService.consultarId(idSalon);
		ResponseDTO responseDTO = new ResponseDTO();
		if (respuesta != null) {
			responseDTO.setResponse(respuesta);
			responseDTO.getServiceException().setMessageId("200");
			responseDTO.getServiceException().setText("Lista de salones registrados.");
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		} else {
			responseDTO.setResponse(null);
			responseDTO.getServiceException().setMessageId("400");
			responseDTO.getServiceException().setText("Fallo en la operación.");
			responseDTO.getServiceException().setVariables("No existe salon con el id registrado.");
			return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<ResponseDTO> consultarNombreNota(String nombreAlumno) throws SiecaException {

		if (nombreAlumno != null && !nombreAlumno.isEmpty()) {
			SalonDTO respuesta = salonService.consultarNombreNota(nombreAlumno);
			ResponseDTO responseDTO = new ResponseDTO();
			if (respuesta != null) {
				responseDTO.setResponse(respuesta);
				responseDTO.getServiceException().setMessageId("200");
				responseDTO.getServiceException().setText("La operación fue exitosa.");
				return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
			} else {
				responseDTO.setResponse(null);
				responseDTO.getServiceException().setMessageId("400");
				responseDTO.getServiceException().setText("Fallo en la operación.");
				responseDTO.getServiceException().setVariables("No existe salon con el nombre registrado.");
				return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
			}
		} else {
			List<SalonDTO> respuesta = salonService.datosColegio();
			ResponseDTO responseDTO = new ResponseDTO();
			if (respuesta != null) {
				responseDTO.setResponse(respuesta);
				responseDTO.getServiceException().setMessageId("200");
				responseDTO.getServiceException().setText("La operación fue exitosa.");
				return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
			} else {
				responseDTO.setResponse(null);
				responseDTO.getServiceException().setMessageId("400");
				responseDTO.getServiceException().setText("Fallo en la operación.");
				responseDTO.getServiceException().setVariables("No existe salon con el nombre registrado.");
				return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
			}
		}
	}

	@Override
	public ResponseEntity<ResponseDTO> consultarColegio() throws SiecaException {

		List<SalonDTO> respuesta = salonService.datosColegio();
		ResponseDTO responseDTO = new ResponseDTO();
		if (respuesta != null) {
			responseDTO.setResponse(respuesta);
			responseDTO.getServiceException().setMessageId("200");
			responseDTO.getServiceException().setText("La operación fue exitosa.");
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		} else {
			responseDTO.setResponse(null);
			responseDTO.getServiceException().setMessageId("400");
			responseDTO.getServiceException().setText("Fallo en la operación.");
			responseDTO.getServiceException().setVariables("No existe salon con el nombre registrado.");
			return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<ResponseDTO> ingresarColegio(DatosCreacionSalonDTO datosIngresados) throws SiecaException {
		RespuestaCreacionSalonDTO respuesta = salonService.ingresarSalon1(datosIngresados);
		ResponseDTO responseDTO = new ResponseDTO();
		if (respuesta != null) {
			responseDTO.setResponse(respuesta);
			responseDTO.getServiceException().setMessageId("200");
			responseDTO.getServiceException().setText("La operación fue exitosa.");
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		} else {
			responseDTO.setResponse(null);
			responseDTO.getServiceException().setMessageId("400");
			responseDTO.getServiceException().setText("Fallo en la operación.");
			responseDTO.getServiceException().setVariables("No existe salon con el nombre registrado.");
			return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
		}
	}





}
