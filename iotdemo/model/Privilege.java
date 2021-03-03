package com.iot.iotdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Privilege {

	private int id;
	private int accessLevel;
	private String description;

	Privilege(int accessLevel) {
		this.accessLevel = accessLevel;
	}

}
