package com.example.pruebamicroservicioscolegio.ws.ui.contoller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebamicroservicioscolegio.ws.dto.MateriasAddDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.MateriasDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.ResponseDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.RespuestaMateriasAddDTO;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;
import com.example.pruebamicroservicioscolegio.ws.service.MateriaService;

@RestController
public class MateriaControllerImp implements MateriaController {
	@Autowired
	MateriaService materiaService;

	@Override
	public ResponseEntity<ResponseDTO> consultarMateria(String nombreMateria) throws SiecaException {
		// TODO Auto-generated method stub
		MateriasDTO respuesta = materiaService.consultarMat(nombreMateria);
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
	public ResponseEntity<ResponseDTO> ingresarMateria(@Valid MateriasAddDTO materiasAdd) throws SiecaException {
		RespuestaMateriasAddDTO respuesta = materiaService.crearMateria(materiasAdd);
		ResponseDTO responseDTO = new ResponseDTO();
		if (respuesta != null) {
			responseDTO.setResponse(respuesta);
			responseDTO.getServiceException().setMessageId("200");
			responseDTO.getServiceException().setText("Materia agregada.");
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
