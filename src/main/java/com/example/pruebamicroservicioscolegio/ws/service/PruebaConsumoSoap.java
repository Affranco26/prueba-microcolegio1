package com.example.pruebamicroservicioscolegio.ws.service;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Service;

import com.example.pruebamicroservicioscolegio.ws.dto.MarcaDTO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class PruebaConsumoSoap {

	public MarcaDTO pruebaConsumoSoap(int idMarca) {
		RespuestConsumo resp= new RespuestConsumo();
		// UtilidadesSoap utilidadesSoap = new UtilidadesSoap();
		// UUID id = UUID.randomUUID();
		// Code to make a webservice HTTP request
		String responseString = "";
		String outputString = "";
		try {
			String wsURL = "http://localhost:1521/WS/getnombreMarca";
			URL url = new URL(wsURL);
			URLConnection connection = url.openConnection();
			HttpURLConnection httpConn = (HttpURLConnection) connection;
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://services.ws.nttdata.co.com/\">\r\n"
					+ "   <soapenv:Header/>\r\n"
					+ "   <soapenv:Body>\r\n"
					+ "      <ser:consultarMarcaId>\r\n"
					+ "         <arg0>"+idMarca+"</arg0>\r\n"
					+ "      </ser:consultarMarcaId>\r\n"
					+ "   </soapenv:Body>\r\n"
					+ "</soapenv:Envelope>";
			byte[] buffer = new byte[xmlInput.length()];
			buffer = xmlInput.getBytes();
			bout.write(buffer);
			byte[] b = bout.toByteArray();
			String SOAPAction = "consultarMarcaId";
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
		return resp.respuesta(outputString);
	}


	
}
