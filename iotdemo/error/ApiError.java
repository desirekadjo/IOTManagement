package com.iot.iotdemo.error;

import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ApiError {

	private int status;
	private String message;
	private boolean isAccessGranted;
	private String url;

	private Map<String, String> validationErrors;

	private LocalDateTime timestamp = LocalDateTime.now();

	public ApiError(int status, String message, String url) {
		super();
		this.status = status;
		this.message = message;
		this.isAccessGranted = false;
		this.url = url;
	}

}
