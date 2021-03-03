package com.iot.iotdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.iotdemo.model.Door;
import com.iot.iotdemo.repository.DoorReposiroty;

@Service
public class DoorService {
	
	@Autowired
	private DoorReposiroty doorReposiroty;
	
	public Door getDoorDetailsByDoorId(int doorId) {
		return doorReposiroty.findById(doorId);
	}

}
