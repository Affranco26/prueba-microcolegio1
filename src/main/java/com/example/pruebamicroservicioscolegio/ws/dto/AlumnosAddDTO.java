package com.example.pruebamicroservicioscolegio.ws.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AlumnosAddDTO {
	@NotNull(message= "El campo documento Alumno no puede ser vacio")
	@NotEmpty (message= "el campo documento Alumno  no puede ser nulo")
	@NotBlank
	private String documentoAlumno;
	@NotEmpty  
	@NotNull
	@NotBlank(message= "El campo nombre Alumno no puede ser nulo o vacio")
	private String nombreAlumno;
	@NotNull(message= "El campo fecha Nacimiento no puede ser vacio")
	private Date fechaNacimiento;
	
	@NotEmpty (message= "el campo direccionVivienda no puede ser nulo")
	@NotNull(message= "El campo direccion Vivienda no puede ser vacio")
	@NotBlank
	private String direccionVivienda;
	@NotEmpty (message= "el campo nombre Acudiente no puede ser nulo")
	@NotNull(message= "El campo nombre Acudiente no puede ser vacio")
	@NotBlank
	private String nombreAcudiente;
	@NotEmpty (message= "el campo numero Contacto no puede ser nulo")
	@NotNull(message= "El campo numero Contacto no puede ser vacio")
	@NotBlank
	private String numeroContacto;
	@NotNull(message= "El campo id Salon no puede ser vacio")
	private Integer idSalon;

	public String getDocumentoAlumno() {
		return documentoAlumno;
	}

	public void setDocumentoAlumno(String documentoAlumno) {
		this.documentoAlumno = documentoAlumno;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccionVivienda() {
		return direccionVivienda;
	}

	public void setDireccionVivienda(String direccionVivienda) {
		this.direccionVivienda = direccionVivienda;
	}

	public String getNombreAcudiente() {
		return nombreAcudiente;
	}

	public void setNombreAcudiente(String nombreAcudiente) {
		this.nombreAcudiente = nombreAcudiente;
	}

	public String getNumeroContacto() {
		return numeroContacto;
	}

	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}

	public Integer getIdSalon() {
		return idSalon;
	}

	public void setIdSalon(Integer idSalon) {
		this.idSalon = idSalon;
	}

}
