package com.example.pruebamicroservicioscolegio.ws.ui.contoller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pruebamicroservicioscolegio.ws.dto.AlumnosAddDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.DatosCreacionSalonDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.ResponseDTO;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;

@RequestMapping("/nttdata/service/v1/prueba-microcolegio1")
public interface SalonController {

	@GetMapping("/colegioNombres")
	public ResponseEntity<ResponseDTO> consultarSalonNombre(@RequestParam(required = true) String nombreSalon)
			throws SiecaException;

	@GetMapping("/colegio")
	public ResponseEntity<ResponseDTO> consultarNombreNota(@RequestParam(required = false) String nombreAlumno)
			throws SiecaException;

	@GetMapping("/datosCol")
	public ResponseEntity<ResponseDTO> consultarColegio() throws SiecaException;

	@GetMapping("/colegioId")
	public ResponseEntity<ResponseDTO> consultarSalonId(@RequestParam(required = true) Integer idSalon)
			throws SiecaException;

	@PostMapping("/creacionColegio")
	public ResponseEntity<ResponseDTO> ingresarColegio(@RequestBody @Valid DatosCreacionSalonDTO datosIngresados)
			throws SiecaException;

}
