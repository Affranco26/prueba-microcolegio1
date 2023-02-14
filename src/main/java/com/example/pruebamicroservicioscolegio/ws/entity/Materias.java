package com.example.pruebamicroservicioscolegio.ws.entity;

import javax.persistence.*;

@Entity
@Table (name="\"tbl_materias\"")
public class Materias {

	@Id
	@Column (name="\"idMateria\"")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMateria;
	
	@Column (name="\"nombreMateria\"")
	private String nombreMateria;
	
	@Column (name="\"notaFinal\"")
	private Double notaFinal; 
	
	@Column (name="\"idAlumno\"")
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
