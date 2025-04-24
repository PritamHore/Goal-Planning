package com.pritam.spring.ai.common.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.ObjectError;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GlobalException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private String code;
	private Object[] params;
	private List<ObjectError> codes = new ArrayList<>();
	
	public GlobalException(String code) {
		super();
		this.code = code;
	}

	public GlobalException(String code, Object[] params) {
		super();
		this.code = code;
		this.params = params;
	}
	
	
	
}
