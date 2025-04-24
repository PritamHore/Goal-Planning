package com.pritam.spring.ai.common.exception;


import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;


public enum ServiceStatus {
	E000("E000", "Operation Failed"),
	E001("E001", "Failed to create, User Type is already present.");
	
	
	private String code;
	private String message;
	private String errorType;
	
	private ServiceStatus(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	private ServiceStatus(String code, String message, String type) {
		this.code = code;
		this.message = message;
		this.errorType = type;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public static ServiceStatus getByCode(String code2) {
		for (ServiceStatus status : ServiceStatus.values()) {
			if (StringUtils.equalsIgnoreCase(status.getCode(), code2))
				return status;
		}
		return null;
	}
	public String formatMessage(Object... args) {
        return MessageFormat.format(message, args);
    }
}
