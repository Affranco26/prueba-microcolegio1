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
public class CountryDTO {

	private String sISOCode;
	private String sName;
	private String sCapitalCity;
	private String sPhoneCode;
	private String sContinentCode;
	private String sCurrencyISOCode;
	private String sCountryFlag;
	private LanguagesCountryDTO Languages;
	
	
}
