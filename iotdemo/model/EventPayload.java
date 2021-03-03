package com.iot.iotdemo.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class EventPayload {

	@NotNull(message = "EmployeeId cannot be null")
	@Min(1)
	private int employeeId;
	@NotNull(message = "accessLevel cannot be null")
	@Min(1)
	private int doorId;
	@NotNull(message = "accessLevel cannot be null")
	@Min(1)
	private int accessLevel;



}
