package com.iot.iotdemo.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iot.iotdemo.model.EventResponse;
import com.iot.iotdemo.model.HeartBeatRequest;
import com.iot.iotdemo.service.LogsDataService;
import com.iot.iotdemo.shared.AccessEnum;

@RestController
public class HeartBeatController {

	final LogsDataService LogsDataService;

	public HeartBeatController(final LogsDataService logsDataService) {
		this.LogsDataService = logsDataService;
	}

	@PostMapping("/heartbeat")
	public ResponseEntity<EventResponse> postHeartBeat(@Valid @RequestBody HeartBeatRequest heartBeatRequest) {
		LogsDataService.writeHeartbeatToLog(heartBeatRequest);
		return new ResponseEntity<EventResponse>(
				 EventResponse.builder().status(AccessEnum.OK.getStatusCode()).message(AccessEnum.OK.getAccessStatus()).build(), HttpStatus.OK);

	}
}
