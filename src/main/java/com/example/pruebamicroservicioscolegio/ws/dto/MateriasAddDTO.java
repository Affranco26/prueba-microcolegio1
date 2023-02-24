package com.example.pruebamicroservicioscolegio.ws.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MateriasAddDTO {

	//@NotEmpty
	//@NotNull(message = "El campo nombre Materia no puede ser nulo")
	@NotBlank(message = "El campo nombre Materia no puede ser nulo ni vacio")
	@Size(min=3, max=15, message= "Nombre curso debe tener minimo 3 caracteres y maximo 15")
	private String nombreMateria;
	@NotNull(message = "El campo nota Final no puede ser nulo")
	private Double notaFinal;
	@NotNull(message = "El campo id Alumno no puede ser nulo")
	private Integer idAlumno;

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public Double getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(Double notaFinal) {
		this.notaFinal = notaFinal;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

}
