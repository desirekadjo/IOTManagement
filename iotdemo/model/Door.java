package com.iot.iotdemo.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Door {

	private int id;
	private Privilege privilege;
	private String fromDt;
	private String toDate;

}
