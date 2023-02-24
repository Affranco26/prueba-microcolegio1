package com.example.pruebamicroservicioscolegio.ws.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class DatosCreacionSalonDTO {

	//@NotEmpty (message= "el campo nombre curso esta vacio")
	//@NotNull(message= "El campo nombre curso no puede ser vacio")
	@NotBlank (message= "El campo nombre curso no puede ser nulo ni vacio")
	@Size(min=3, max=15, message= "Nombre curso debe tener minimo 3 caracteres y maximo 15")
	private String nombreCurso;
	
	@NotNull(message= "El campo capacidad alumnos no puede nulo")
	private Integer capacidadAlumnos;
	
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	public Integer getCapacidadAlumnos() {
		return capacidadAlumnos;
	}
	public void setCapacidadAlumnos(Integer capacidadAlumnos) {
		this.capacidadAlumnos = capacidadAlumnos;
	}
	
	

}
