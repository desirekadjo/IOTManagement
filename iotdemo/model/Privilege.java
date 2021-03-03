package com.iot.iotdemo.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Privilege {

	private int id;
	private int accessLevel;
	private String description;

	Privilege(int accessLevel) {
		this.accessLevel = accessLevel;
	}

}
