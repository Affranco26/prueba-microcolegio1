package com.example.pruebamicroservicioscolegio.ws.dto;

import java.util.Date;
import java.util.List;

public class AlumnosDTO {

	private Integer idAlumno;
	private String documentoAlumno;
	private String nombreAlumno;
	private Date fechaNacimiento;
	private String direccionVivienda;
	private String nombreAcudiente;
	private String numeroContacto;
	private Integer idSalon;
	private List<MateriasDTO> materia;

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

	public List<MateriasDTO> getMateria() {
		return materia;
	}

	public void setMateria(List<MateriasDTO> materia) {
		this.materia = materia;
	}

}
