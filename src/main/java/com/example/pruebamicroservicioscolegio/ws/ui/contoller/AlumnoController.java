package com.example.pruebamicroservicioscolegio.ws.ui.contoller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pruebamicroservicioscolegio.ws.dto.AlumnosAddDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.ResponseDTO;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;

@RequestMapping("/nttdata/service/v1/prueba-microcolegio1")
public interface AlumnoController {
	
	@GetMapping("/alumnoNombre")
	public ResponseEntity<ResponseDTO> consultarSalonNombre(@RequestParam(required = true) String nombreAlumno)
			throws SiecaException;
	
	@PostMapping("/alumnoAdd")
	public ResponseEntity<ResponseDTO> ingresarAlumno(@Valid
			@RequestBody AlumnosAddDTO alumnosAdd) throws SiecaException;
	
	
}
