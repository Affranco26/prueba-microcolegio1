package com.example.pruebamicroservicioscolegio.ws.ui.contoller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebamicroservicioscolegio.ws.dto.CountryDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.MarcaDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.ResponseDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.ServiciosWsdlDTO;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;
import com.example.pruebamicroservicioscolegio.ws.service.CapitalCitySoap;
import com.example.pruebamicroservicioscolegio.ws.service.PruebaConsumoSoap;
import com.example.pruebamicroservicioscolegio.ws.service.RespuestConsumo;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

@RestController
public class ConsumoSoapControllerImpl implements ConsumoSoapController {
	@Autowired
	PruebaConsumoSoap pruebaConsumoSoap;
	@Autowired
	RespuestConsumo respuestConsumo;
	@Autowired
	CapitalCitySoap capitalCitySoap;

	@Override
	public ResponseEntity<ResponseDTO> consumoSoap(int idMarca) throws SiecaException {
		// TODO Auto-generated method stub
		MarcaDTO respuesta = pruebaConsumoSoap.pruebaConsumoSoap(idMarca);
		// MarcaDTO respuesta = respuestConsumo.respuesta1(idMarca);
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
			responseDTO.getServiceException().setVariables("Soap No tiene informacion sobre el id registrado.");
			return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<ResponseDTO> consumoSoapCity(String code) throws SiecaException {
		// TODO Auto-generated method stub
		String respuesta = capitalCitySoap.capitalCity(code);

		ResponseDTO responseDTO = new ResponseDTO();
		if (!respuesta.equals("Country not found in the database") && respuesta != null) {
			responseDTO.setResponse(respuesta);
			responseDTO.getServiceException().setMessageId("200");
			responseDTO.getServiceException().setText("Capital Encontrada.");
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		} else {
			responseDTO.setResponse(null);
			responseDTO.getServiceException().setMessageId("400");
			responseDTO.getServiceException().setText(respuesta);
			responseDTO.getServiceException().setVariables("Soap No tiene informacion sobre el codigo registrado.");
			return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<ResponseDTO> consumoSoapCountry(String code) throws SiecaException {
		// TODO Auto-generated method stub
		CountryDTO respuesta = capitalCitySoap.infoCountry(code);

		ResponseDTO responseDTO = new ResponseDTO();
		if (respuesta != null && !respuesta.getSName().equals("Country not found in the database")) {

			responseDTO.setResponse(respuesta);
			responseDTO.getServiceException().setMessageId("200");
			responseDTO.getServiceException().setText("Capital Encontrada.");
			return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
		} else {
			responseDTO.setResponse(null);
			responseDTO.getServiceException().setMessageId("400");
			responseDTO.getServiceException().setText(respuesta.getSName());
			responseDTO.getServiceException().setVariables("Soap No tiene informacion sobre el codigo registrado.");
			return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<ResponseDTO> todosService(ServiciosWsdlDTO datosIngresados) throws SiecaException {
		// TODO Auto-generated method stub
		
	Object respuesta = capitalCitySoap.todosServiciosSoap(datosIngresados);
	ResponseDTO responseDTO = new ResponseDTO();
	if (respuesta != null) {

		responseDTO.setResponse(respuesta);
		responseDTO.getServiceException().setMessageId("200");
		responseDTO.getServiceException().setText("Capital Encontrada.");
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	} else {
		responseDTO.setResponse(null);
		responseDTO.getServiceException().setMessageId("400");
		responseDTO.getServiceException().setText("prueba");
		responseDTO.getServiceException().setVariables("Soap No tiene informacion sobre el codigo registrado.");
		return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
	}
		
		
	}

}
