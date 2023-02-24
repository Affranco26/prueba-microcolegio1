package com.example.pruebamicroservicioscolegio.ws.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Marca {
	
	@JsonProperty("idMarca")
	private int idMarca;
	@JsonProperty("descripcionMarca")
	private String descripcionMarca;
	@JsonProperty("nombreMarca")
	private String nombreMarca;

}
