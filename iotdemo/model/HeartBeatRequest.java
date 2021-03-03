package com.iot.iotdemo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeartBeatRequest {

	@NotNull
	private String deviceId;
	@NotNull
	@Pattern(regexp = "^heartbeat$", message = "event passed must be heartbeat")
	private String event;
}
