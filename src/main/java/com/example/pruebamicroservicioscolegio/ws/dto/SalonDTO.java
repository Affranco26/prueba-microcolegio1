package com.example.pruebamicroservicioscolegio.ws.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalonDTO {

	private Integer idSalon;
	private String nombreSalon;
	private Integer cantidad;
	// private String nombreMateria;
	// private Double notaFinal;
	// private String nombreAlumno;
	private List<AlumnosDTO> alumnos;


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
