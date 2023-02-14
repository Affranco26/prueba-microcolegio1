package com.example.pruebamicroservicioscolegio.ws.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "\"tbl_alumnos\"")
public class Alumnos {
	@Id
	@Column(name = "\"idAlumno\"")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlumno;
	
	@Column(name = "\"documentoAlumno\"")
	private String documentoAlumno;
	
	@Column(name = "\"nombreAlumno\"")
	private String nombreAlumno;
	
	@Column(name = "\"fechaNacimiento\"")
	private Date fechaNacimiento;
	
	@Column(name = "\"direccionVivienda\"")
	private String direccionVivienda;
	
	@Column(name = "\"nombreAcudiente\"")
	private String nombreAcudiente;
	
	@Column(name = "\"numeroContacto\"")
	private String numeroContacto;
	
	@Column(name = "\"idSalon\"")
	private Integer idSalon;

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

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
