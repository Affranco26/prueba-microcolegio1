package com.example.pruebamicroservicioscolegio.ws.dto;

import java.util.List;

public class SalonDTO {

	private Integer idSalon;
	private String nombreSalon;
	private Integer cantidad;
	// private String nombreMateria;
	// private Double notaFinal;
	// private String nombreAlumno;
	private List<AlumnosDTO> alumnos;

	public Integer getIdSalon() {
		return idSalon;
	}

	public void setIdSalon(Integer idSalon) {
		this.idSalon = idSalon;
	}

	public String getNombreSalon() {
		return nombreSalon;
	}

	public void setNombreSalon(String nombreSalon) {
		this.nombreSalon = nombreSalon;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public List<AlumnosDTO> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<AlumnosDTO> alumnos) {
		this.alumnos = alumnos;
	}
	/*
	 * public String getNombreMateria() { return nombreMateria; }
	 * 
	 * public void setNombreMateria(String nombreMateria) { this.nombreMateria =
	 * nombreMateria; }
	 * 
	 * public Double getNotaFinal() { return notaFinal; }
	 * 
	 * public void setNotaFinal(Double notaFinal) { this.notaFinal = notaFinal; }
	 * 
	 * public String getNombreAlumno() { return nombreAlumno; }
	 * 
	 * public void setNombreAlumno(String nombreAlumno) { this.nombreAlumno =
	 * nombreAlumno; }
	 */

}
