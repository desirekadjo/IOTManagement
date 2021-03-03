package com.iot.iotdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iot.iotdemo.model.EventRequest;
import com.iot.iotdemo.model.EventResponse;
import com.iot.iotdemo.service.EventService;

@RestController
public class EventController {

	@Autowired
	private EventService eventService;

	@PostMapping("/access")
	public EventResponse getAccessToDoor(@Valid @RequestBody EventRequest eventRequest) {
		return eventService.getAccessToDoor(eventRequest);
	}
		
}
