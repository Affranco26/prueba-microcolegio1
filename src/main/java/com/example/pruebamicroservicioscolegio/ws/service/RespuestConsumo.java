package com.example.pruebamicroservicioscolegio.ws.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.stream.XMLInputFactory;

import org.hibernate.cfg.annotations.reflection.internal.XMLContext;

import org.springframework.stereotype.Service;

import com.example.pruebamicroservicioscolegio.ws.dto.CountryDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.LanguagesCountryDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.MarcaDTO;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RespuestConsumo {

	/*
	 * public String respuesta1(int idMarca) throws SiecaException { String
	 * respuesta =""; try { PruebaConsumoSoap p = new PruebaConsumoSoap(); String
	 * xmlRes = p.pruebaConsumoSoap(idMarca);
	 * 
	 * ObjectMapper xmlMapper = new XmlMapper(); JsonNode node =
	 * xmlMapper.readTree(xmlRes.getBytes()); ObjectMapper json = new
	 * ObjectMapper(); String a = json.writeValueAsString(node); JsonNode node1 =
	 * xmlMapper.readTree(a); //respuesta =
	 * node.get("Body").get("sendNotificationResponse").get("return").asText();
	 * System.out.println("***-----" + a);
	 * 
	 * return a;
	 * 
	 * } catch (Exception e) { // TODO: handle exception
	 * log.info("el error es  "+e.getMessage());
	 * 
	 * return null; }
	 * 
	 * }
	 */

	public MarcaDTO respuesta(String xml) {

		MarcaDTO respuesta = new MarcaDTO();
		ObjectMapper mapper = new ObjectMapper();
		try {
			XmlMapper xmlMapper = new XmlMapper();
			JsonNode jsonNode = xmlMapper.readTree(xml.getBytes());
			ObjectMapper objectMapper = new ObjectMapper();
			String value = objectMapper.writeValueAsString(jsonNode);
			JsonNode node = mapper.readTree(value);
			log.info("respuesta  " + node);
			respuesta.setIdMarca(Integer
					.parseInt(node.get("Body").get("consultarMarcaIdResponse").get("return").get("idMarca").asText()));
			respuesta.setNombreMarca(
					node.get("Body").get("consultarMarcaIdResponse").get("return").get("nombreMarca").asText());
			respuesta.setDescripcionMarca(
					node.get("Body").get("consultarMarcaIdResponse").get("return").get("descripcionMarca") == null
							? "La marca no contiene descrpcion"
							: node.get("Body").get("consultarMarcaIdResponse").get("return").get("descripcionMarca")
									.asText());
			return respuesta;
		} catch (Exception e) {

			log.error(e.getMessage());
			// respuesta = null;
			return null;
		}
		// return null;
	}

	public String respuestaCity(String xml) {

		String respuesta = "";
		String respuesta2 = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			XmlMapper xmlMapper = new XmlMapper();
			JsonNode jsonNode = xmlMapper.readTree(xml.getBytes());
			ObjectMapper objectMapper = new ObjectMapper();
			String value = objectMapper.writeValueAsString(jsonNode);
			JsonNode node = mapper.readTree(value);
			log.info("respuesta  " + node);
			respuesta = node.get("Body").get("CapitalCityResponse").get("CapitalCityResult").asText();

			return respuesta;

		} catch (Exception e) {
			log.error(e.getMessage());

			return null;
		}

	}

	public CountryDTO respuestaCountry(String xml)  {
		CountryDTO res = new CountryDTO();
		String respuesta = "";

		ObjectMapper mapper = new ObjectMapper();
		try {
			XmlMapper xmlMapper = new XmlMapper();
			JsonNode jsonNode = xmlMapper.readTree(xml.getBytes());
			ObjectMapper objectMapper = new ObjectMapper();
			String value = objectMapper.writeValueAsString(jsonNode);
			JsonNode node = mapper.readTree(value);
			log.info("respuesta  " + node);
			
			res.setSISOCode(node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
					.get("sISOCode").equals("") ? "no" : node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
					.get("sISOCode").asText());
			res.setSName(node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
					.get("sName").equals("") ? "no"
							: node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
									.get("sName").asText());
			res.setSCapitalCity(node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
					.get("sCapitalCity").equals("") ? "no" 
							: node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
									.get("sCapitalCity").asText());
			res.setSPhoneCode(node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
					.get("sPhoneCode").equals("") ? "no" 
							: node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
									.get("sPhoneCode").asText());
			res.setSContinentCode(node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
					.get("sContinentCode").equals("") ? "no" 
							: node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
									.get("sContinentCode").asText());
			res.setSCurrencyISOCode(node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
					.get("sCurrencyISOCode").equals("") ? "no"  :node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
					.get("sCurrencyISOCode").asText());
			res.setSCountryFlag(node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
					.get("sCountryFlag").equals("") ? "no": node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
					.get("sCountryFlag").asText());
		
			 
			LanguagesCountryDTO l = new LanguagesCountryDTO();
			l.setSISOCodel(node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult").get("Languages").isEmpty() ? "no": node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult").get("Languages").get("tLanguage").get("sISOCode").asText());
			l.setSNamel(node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult").get("Languages").isEmpty() ? "no": node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult").get("Languages").get("tLanguage").get("sName").asText());
		 
			res.setLanguages(l);
			 return res;
			// node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult").get("sName").asText();
			// node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult").get("Languages").get("tLanguage").get("sName").asText();
	


		} catch (Exception e) {
			log.error(e.getMessage());

			return null;
		}

	}
	
	
	public Object todosCountry(String xml , String soapaction)  {
		try {
		
		CountryDTO res = new CountryDTO();
		String respuesta = "";

		ObjectMapper mapper = new ObjectMapper();
	
			XmlMapper xmlMapper = new XmlMapper();
			JsonNode jsonNode = xmlMapper.readTree(xml.getBytes());
			ObjectMapper objectMapper = new ObjectMapper();
			String value = objectMapper.writeValueAsString(jsonNode);
			JsonNode node = mapper.readTree(value);
			log.info("respuesta  " + node);
			
			switch (soapaction) {
			case "FullCountryInfo":
				res.setSISOCode(node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
						.get("sISOCode").equals("") ? "no" : node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
						.get("sISOCode").asText());
				res.setSName(node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
						.get("sName").equals("") ? "no"
								: node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
										.get("sName").asText());
				res.setSCapitalCity(node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
						.get("sCapitalCity").equals("") ? "no" 
								: node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
										.get("sCapitalCity").asText());
				res.setSPhoneCode(node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
						.get("sPhoneCode").equals("") ? "no" 
								: node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
										.get("sPhoneCode").asText());
				res.setSContinentCode(node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
						.get("sContinentCode").equals("") ? "no" 
								: node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
										.get("sContinentCode").asText());
				res.setSCurrencyISOCode(node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
						.get("sCurrencyISOCode").equals("") ? "no"  :node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
						.get("sCurrencyISOCode").asText());
				res.setSCountryFlag(node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
						.get("sCountryFlag").equals("") ? "no": node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult")
						.get("sCountryFlag").asText());
			
				 
				LanguagesCountryDTO l = new LanguagesCountryDTO();
				l.setSISOCodel(node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult").get("Languages").isEmpty() ? "no": node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult").get("Languages").get("tLanguage").get("sISOCode").asText());
				l.setSNamel(node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult").get("Languages").isEmpty() ? "no": node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult").get("Languages").get("tLanguage").get("sName").asText());
			 
				res.setLanguages(l);
				 return res;
				// node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult").get("sName").asText();
				// node.get("Body").get("FullCountryInfoResponse").get("FullCountryInfoResult").get("Languages").get("tLanguage").get("sName").asText();

				 
			case "CapitalCity":
				respuesta = node.get("Body").get("CapitalCityResponse").get("CapitalCityResult").asText();

				return respuesta;
			default:
				break;
			}
		
	
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return null;
	}
	
	

}
