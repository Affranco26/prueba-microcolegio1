package com.example.pruebamicroservicioscolegio.ws.dto;

public class SalonAlumnoMateriaDTO {

	private String nombreMateria;
	private Double notaFinal;
	private String nombreAlumno;
	private String nombreCurso;
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
	public String getNombreAlumno() {
		return nombreAlumno;
	}
	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	
	

}
