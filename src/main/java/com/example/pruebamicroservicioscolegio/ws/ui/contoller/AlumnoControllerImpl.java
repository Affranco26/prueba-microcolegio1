package com.example.pruebamicroservicioscolegio.ws.ui.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebamicroservicioscolegio.ws.dto.AlumnosAddDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.AlumnosDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.ResponseDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.RespuestaAlumnosAddDTO;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;
import com.example.pruebamicroservicioscolegio.ws.service.AlumnoService;

@RestController
public class AlumnoControllerImpl implements AlumnoController {

	@Autowired
	AlumnoService alumnoService;
	
	@Override
	public ResponseEntity<ResponseDTO> consultarSalonNombre(String nombreAlumno) throws SiecaException {
		
		AlumnosDTO respuesta = alumnoService.consultarId(nombreAlumno);
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
	public ResponseEntity<ResponseDTO> ingresarAlumno(AlumnosAddDTO alumnosAdd) throws SiecaException {

		RespuestaAlumnosAddDTO respuesta = alumnoService.addAlumno(alumnosAdd);
		ResponseDTO responseDTO = new ResponseDTO();
		if (respuesta != null) {
			responseDTO.setResponse(respuesta);
			responseDTO.getServiceException().setMessageId("200");
			responseDTO.getServiceException().setText("Alumno registrado");
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		} else {
			responseDTO.setResponse(null);
			responseDTO.getServiceException().setMessageId("400");
			responseDTO.getServiceException().setText("Fallo en la operación.");
			responseDTO.getServiceException().setVariables("No existe salon con el id registrado.");
			return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
		}
	}
}
