package com.example.pruebamicroservicioscolegio.ws.dto;

public class RespuestaMateriasAddDTO {
	
	private Integer idMateria;
	
	private String nombreMateria;

	private Double notaFinal;

	private Integer idAlumno;

	public Integer getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}

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
