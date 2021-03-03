package com.iot.iotdemo.model;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class EventRequest {

	@NotNull
	private UUID deviceId;
	@NotNull
	@Pattern(regexp="^exit|enter", message="event must be either exit or enter")
	private String event;
	@NotNull
	private String time;
	@Valid
	private EventPayload payload;

}
