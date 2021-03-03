package com.iot.iotdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.iotdemo.model.Privilege;
import com.iot.iotdemo.repository.PrivilegeRepository;

@Service
public class PrivilegeService {

	@Autowired
	private PrivilegeRepository privilegeReposiroty;

	public Privilege getPriviligeByAccess(int accessLevel) {

		final Privilege privilege = privilegeReposiroty.findById(accessLevel);
		return privilege;
	}

}
