package com.pritam.spring.ai.common.exception;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.MediaType;

@ControllerAdvice
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class GlobalExceptionHandler {
	
	@ExceptionHandler(GlobalException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<List<ErrorResponse>> handleGlobalException(GlobalException globalException,
			Locale locale) {
		ServiceStatus status = null;
		List<ErrorResponse> errorResponseList = new ArrayList<>();
		if(!globalException.getCodes().isEmpty()) {
			for(ObjectError objErr: globalException.getCodes()) {
				status = ServiceStatus.getByCode(objErr.getDefaultMessage());
		        errorResponseList.add(new ErrorResponse(status.getCode(), status.getMessage()));
			}
		}else {
			status = ServiceStatus.getByCode(globalException.getCode());
			ErrorResponse resposne = new ErrorResponse(status.getCode(), MessageFormat.format(status.getMessage(),globalException.getParams()));
			errorResponseList.add(resposne);
		}
		return ResponseEntity.badRequest().body(errorResponseList);
	}
	
	@ExceptionHandler({Exception.class})
	protected ResponseEntity<?> handleException(Exception e, Locale locale) {
		return ResponseEntity.badRequest().body("Exception occur inside API " + e);
	}
}

