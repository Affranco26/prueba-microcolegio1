package com.example.pruebamicroservicioscolegio.ws.ui.contoller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pruebamicroservicioscolegio.ws.dto.DatosCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.ResponseDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.ServiciosWsdlDTO;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;

@RequestMapping("/nttdata/service/v1/prueba-microcolegio1")
public interface ConsumoSoapController {
	
	@GetMapping("/consumo")
	public ResponseEntity<ResponseDTO> consumoSoap(@RequestParam(required = true) int idMarca)
			throws SiecaException;

	@GetMapping("/consumoCity")
	public ResponseEntity<ResponseDTO> consumoSoapCity(@RequestParam(required = true) String code)
			throws SiecaException;

	@GetMapping("/FullCountryInfo")
	public ResponseEntity<ResponseDTO> consumoSoapCountry(@RequestParam(required = true) String code)
			throws SiecaException;
	

	@GetMapping("/todosCountry")
	public ResponseEntity<ResponseDTO> todosService(@RequestBody @Valid ServiciosWsdlDTO datosIngresados)
			throws SiecaException;
}
