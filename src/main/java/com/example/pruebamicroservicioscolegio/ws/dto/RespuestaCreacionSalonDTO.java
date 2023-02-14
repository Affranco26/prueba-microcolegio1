package com.example.pruebamicroservicioscolegio.ws.dto;

public class RespuestaCreacionSalonDTO {
	private Integer idSalon;
	private String nombreSalon;
	private Integer cantidad;

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

}
