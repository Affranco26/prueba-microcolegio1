package com.example.pruebamicroservicioscolegio.ws.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServiciosWsdlDTO {

	private String soapaction;
	private String code;
}
