package com.example.pruebamicroservicioscolegio.ws.ui.contoller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.pruebamicroservicioscolegio.ws.dto.ResponseDTO;

@RestControllerAdvice
public class Controller {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseDTO  exeptions(MethodArgumentNotValidException ex){
	  List<ResponseDTO> validaciones =new ArrayList<>();
	  ResponseDTO errores = new ResponseDTO();
		ex.getBindingResult().getAllErrors().forEach((error)->{
		String fielName= ((FieldError)error).getField();
		String message = error.getDefaultMessage();
		errores.getServiceException().setMessageId("400");
		errores.getServiceException().setText(message);
		errores.getServiceException().setVariables(fielName);
		});
	
	return errores;
		
	}
} 
