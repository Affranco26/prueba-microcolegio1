package com.example.pruebamicroservicioscolegio.ws.service;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pruebamicroservicioscolegio.ws.dto.CountryDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.MarcaDTO;
import com.example.pruebamicroservicioscolegio.ws.dto.ServiciosWsdlDTO;
import com.example.pruebamicroservicioscolegio.ws.exception.SiecaException;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class CapitalCitySoap {
	
	public String capitalCity(String code) {
		RespuestConsumo resp= new RespuestConsumo();
		code=code.toUpperCase();
		System.out.println(".... "+code);
		// UtilidadesSoap utilidadesSoap = new UtilidadesSoap();
		// UUID id = UUID.randomUUID();
		// Code to make a webservice HTTP request
		String responseString = "";
		String outputString = "";
		try {
			String wsURL = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";
			URL url = new URL(wsURL);
			URLConnection connection = url.openConnection();
			HttpURLConnection httpConn = (HttpURLConnection) connection;
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://www.oorsprong.org/websamples.countryinfo\">\r\n"
					+ "   <soapenv:Header/>\r\n"
					+ "   <soapenv:Body>\r\n"
					+ "      <web:CapitalCity>\r\n"
					+ "         <web:sCountryISOCode>"+code+"</web:sCountryISOCode>\r\n"
					+ "      </web:CapitalCity>\r\n"
					+ "   </soapenv:Body>\r\n"
					+ "</soapenv:Envelope>";
			byte[] buffer = new byte[xmlInput.length()];
			buffer = xmlInput.getBytes();
			bout.write(buffer);
			byte[] b = bout.toByteArray();
			String SOAPAction = "CapitalCity";
			// Set the appropriate HTTP parameters.
			httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
			httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			httpConn.setRequestProperty("SOAPAction", SOAPAction);
			httpConn.setRequestMethod("POST");
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			OutputStream out = httpConn.getOutputStream();
			// Write the content of the request to the outputstream of the HTTP Connection.
			out.write(b);
			out.close();
			// Ready with sending the request.             // Read the response.
			// InputStreamReader isr = new
			// InputStreamReader(httpConn.getInputStream());
			InputStreamReader isr = null;
			if (httpConn.getResponseCode() == 200) {
				isr = new InputStreamReader(httpConn.getInputStream());
			} else {
				isr = new InputStreamReader(httpConn.getErrorStream());
			}
			BufferedReader in = new BufferedReader(isr);
			// Write the SOAP message response to a String.
			while ((responseString = in.readLine()) != null) {
				outputString = outputString + responseString;
			}
		} catch (Exception me) {
			log.info("el error es: " + me.getMessage());
		}
		log.info(outputString);
		//return outputString;
		return resp.respuestaCity(outputString);
	}

	public CountryDTO infoCountry(String code) {
		RespuestConsumo resp= new RespuestConsumo();
		code=code.toUpperCase();
		System.out.println(".... "+code);
		// UtilidadesSoap utilidadesSoap = new UtilidadesSoap();
		// UUID id = UUID.randomUUID();
		// Code to make a webservice HTTP request
		String responseString = "";
		String outputString = "";
		try {
			String wsURL = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";
			URL url = new URL(wsURL);
			URLConnection connection = url.openConnection();
			HttpURLConnection httpConn = (HttpURLConnection) connection;
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://www.oorsprong.org/websamples.countryinfo\">\r\n"
					+ "   <soapenv:Header/>\r\n"
					+ "   <soapenv:Body>\r\n"
					+ "      <web:FullCountryInfo>\r\n"
					+ "         <web:sCountryISOCode>"+code+"</web:sCountryISOCode>\r\n"
					+ "      </web:FullCountryInfo>\r\n"
					+ "   </soapenv:Body>\r\n"
					+ "</soapenv:Envelope>";
			byte[] buffer = new byte[xmlInput.length()];
			buffer = xmlInput.getBytes();
			bout.write(buffer);
			byte[] b = bout.toByteArray();
			String SOAPAction = "FullCountryInfo";
			// Set the appropriate HTTP parameters.
			httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
			httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			httpConn.setRequestProperty("SOAPAction", SOAPAction);
			httpConn.setRequestMethod("POST");
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			OutputStream out = httpConn.getOutputStream();
			// Write the content of the request to the outputstream of the HTTP Connection.
			out.write(b);
			out.close();
			// Ready with sending the request.             // Read the response.
			// InputStreamReader isr = new
			// InputStreamReader(httpConn.getInputStream());
			InputStreamReader isr = null;
			if (httpConn.getResponseCode() == 200) {
				isr = new InputStreamReader(httpConn.getInputStream());
			} else {
				isr = new InputStreamReader(httpConn.getErrorStream());
			}
			BufferedReader in = new BufferedReader(isr);
			// Write the SOAP message response to a String.
			while ((responseString = in.readLine()) != null) {
				outputString = outputString + responseString;
			}
		} catch (Exception me) {
			log.info("el error es: " + me.getMessage());
		}
		log.info(outputString);
		//return outputString;
		return resp.respuestaCountry(outputString);
	}
	
	
	
	
	
	public String selector(String soapaction, String code) {
		String respuesta = "";
		
		switch (soapaction) {
		case "FullCountryInfo":
			respuesta = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://www.oorsprong.org/websamples.countryinfo\">\r\n"
					+ "   <soapenv:Header/>\r\n"
					+ "   <soapenv:Body>\r\n"
					+ "      <web:FullCountryInfo>\r\n"
					+ "         <web:sCountryISOCode>"+code+"</web:sCountryISOCode>\r\n"
					+ "      </web:FullCountryInfo>\r\n"
					+ "   </soapenv:Body>\r\n"
					+ "</soapenv:Envelope>";
			
			return respuesta;
		case "CapitalCity":
			respuesta= "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://www.oorsprong.org/websamples.countryinfo\">\r\n"
					+ "   <soapenv:Header/>\r\n"
					+ "   <soapenv:Body>\r\n"
					+ "      <web:CapitalCity>\r\n"
					+ "         <web:sCountryISOCode>"+code+"</web:sCountryISOCode>\r\n"
					+ "      </web:CapitalCity>\r\n"
					+ "   </soapenv:Body>\r\n"
					+ "</soapenv:Envelope>";
			
			return respuesta;
			
		case "CountriesUsingCurrency":
			respuesta= "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://www.oorsprong.org/websamples.countryinfo\">\r\n"
					+ "   <soapenv:Header/>\r\n"
					+ "   <soapenv:Body>\r\n"
					+ "      <web:CountriesUsingCurrency>\r\n"
					+ "         <web:sISOCurrencyCode>"+code+"</web:sISOCurrencyCode>\r\n"
					+ "      </web:CountriesUsingCurrency>\r\n"
					+ "   </soapenv:Body>\r\n"
					+ "</soapenv:Envelope>";
			
			return respuesta;

		default:
			break;
		}
		
		return respuesta;
	}
	
	
	public Object todosServiciosSoap(ServiciosWsdlDTO se) {
		RespuestConsumo resp= new RespuestConsumo();
	
	//	System.out.println(".... "+code);
		// UtilidadesSoap utilidadesSoap = new UtilidadesSoap();
		// UUID id = UUID.randomUUID();
		// Code to make a webservice HTTP request
		String responseString = "";
		String outputString = "";
		try {
			String wsURL = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";
			URL url = new URL(wsURL);
			URLConnection connection = url.openConnection();
			HttpURLConnection httpConn = (HttpURLConnection) connection;
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			String xmlInput = selector(se.getSoapaction(), se.getCode());
			
			byte[] buffer = new byte[xmlInput.length()];
			buffer = xmlInput.getBytes();
			bout.write(buffer);
			byte[] b = bout.toByteArray();
			String SOAPAction = se.getSoapaction();
			// Set the appropriate HTTP parameters.
			httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
			httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			httpConn.setRequestProperty("SOAPAction", SOAPAction);
			httpConn.setRequestMethod("POST");
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			OutputStream out = httpConn.getOutputStream();
			// Write the content of the request to the outputstream of the HTTP Connection.
			out.write(b);
			out.close();
			// Ready with sending the request.             // Read the response.
			// InputStreamReader isr = new
			// InputStreamReader(httpConn.getInputStream());
			InputStreamReader isr = null;
			if (httpConn.getResponseCode() == 200) {
				isr = new InputStreamReader(httpConn.getInputStream());
			} else {
				isr = new InputStreamReader(httpConn.getErrorStream());
			}
			BufferedReader in = new BufferedReader(isr);
			// Write the SOAP message response to a String.
			while ((responseString = in.readLine()) != null) {
				outputString = outputString + responseString;
			}
		} catch (Exception me) {
			log.info("el error es: " + me.getMessage());
		}
		log.info(outputString);
		//return outputString;
		return resp.todosCountry( outputString, se.getSoapaction());
	}

}
