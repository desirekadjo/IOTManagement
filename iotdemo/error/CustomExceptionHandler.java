package com.iot.iotdemo.error;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {

	private final int BAD_REQUEST = HttpStatus.BAD_REQUEST.value();
	private final int NOT_FOUND = HttpStatus.NOT_FOUND.value();
	
	@ExceptionHandler({MethodArgumentNotValidException.class})
	public final ResponseEntity<ApiError> hadleValidationException(MethodArgumentNotValidException exception,
			HttpServletRequest request) {
		ApiError apiError = new ApiError();
		apiError.setMessage("validation error");
		apiError.setStatus(BAD_REQUEST);
		apiError.setUrl(request.getServletPath());

		BindingResult result = exception.getBindingResult();
		Map<String, String> validationErrors = new HashMap<>();

		for (FieldError fieldError : result.getFieldErrors()) {
			System.out.println("field: "+fieldError.getField()+" "+"value: "+fieldError.getDefaultMessage());
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		apiError.setValidationErrors(validationErrors);
		apiError.toString();
		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<ApiError> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
		ApiError apiError = new ApiError(NOT_FOUND, ex.getLocalizedMessage(), request.getContextPath());
		return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
	}
}
