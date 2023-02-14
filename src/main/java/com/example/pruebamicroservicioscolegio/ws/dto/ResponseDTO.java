package com.example.pruebamicroservicioscolegio.ws.dto;

public class ResponseDTO {

	private Object response;
	private ServiceException serviceException;

	public ResponseDTO() {
		serviceException = new ServiceException();
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public ServiceException getServiceException() {
		return serviceException;
	}

	public void setServiceException(ServiceException serviceException) {
		this.serviceException = serviceException;
	}

}
