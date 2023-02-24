package com.example.pruebamicroservicioscolegio.ws.entity;

import javax.persistence.*;

@Entity
@Table(name = "\"tbl_salon\"")
public class Salon {

	@Id
	@Column(name = "\"idSalon\"")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSalon;

	@Column(name = "\"nombreCurso\"")
	private String nombreCurso;

	@Column(name = "\"capacidadAlumnos\"")
	private Integer capacidadAlumnos;

	
	public Salon() {
	
	}

	public Integer getIdSalon() {
		return idSalon;
	}

	public void setIdSalon(Integer idSalon) {
		this.idSalon = idSalon;
	}

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
