package com.iot.iotdemo.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Door {

	private int id;
	private Privilege privilege;
	private String fromDt;
	private String toDate;

}
