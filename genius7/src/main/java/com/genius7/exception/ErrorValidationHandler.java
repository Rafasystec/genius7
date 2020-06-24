package com.genius7.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorValidationHandler {

	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorValidation> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    List<ErrorValidation> errors = new ArrayList<>();
	    ex.getBindingResult().getFieldErrors().forEach((error) -> {
	        String fieldName = error.getField();
	        String errorMessage = messageSource.getMessage(error, LocaleContextHolder.getLocale());
	        errors.add(new ErrorValidation(fieldName, errorMessage));
	    });
	    return errors;
	}
}
