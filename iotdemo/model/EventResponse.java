package com.iot.iotdemo.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventResponse {
	
	private int status;
	private String message;
	private boolean isAccessGranted;
	
}
