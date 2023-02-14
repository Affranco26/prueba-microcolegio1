package com.example.pruebamicroservicioscolegio.ws.ui.contoller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Controller {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> exeptions(MethodArgumentNotValidException ex){
		Map<String, String> errores = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
		String fielName= ((FieldError)error).getField();
		String message = error.getDefaultMessage();
		errores.put(fielName, message);
		});
		
	return errores;
		
	}
} 
