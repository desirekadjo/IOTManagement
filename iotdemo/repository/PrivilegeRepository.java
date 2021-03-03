package com.iot.iotdemo.repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iot.iotdemo.model.Privilege;
import com.iot.iotdemo.shared.Level;
import com.iot.iotdemo.shared.Log;
import com.iot.iotdemo.utils.Utils;

@Repository
public class PrivilegeRepository implements ObjectRepository<Privilege> {

	private Map<Integer, Privilege> repository;

	public PrivilegeRepository() throws Exception {
		final ObjectMapper objectMapper = new ObjectMapper();
		File file = Utils.readJsonFile("privileges.json");
		List<Privilege> privileges;
		try {
			privileges = objectMapper.readValue(file, new TypeReference<List<Privilege>>() {
			});
			this.repository = privileges.stream().collect(Collectors.toMap(Privilege::getId, privilege -> privilege));
		} catch (JsonParseException e) {
			Log.log(Level.ERROR, getClass().getSimpleName(), "Json Parsing from file error ");
			throw new Exception();
		} catch (JsonMappingException e) {
			Log.log(Level.ERROR, getClass().getSimpleName(), "Json Mapping from file error ");
			throw new RuntimeException();
		} catch (IOException e) {
			Log.log(Level.ERROR, getClass().getSimpleName(), "Could not parse the json file");
			throw new IOException(e.getCause());
		}

	}

	@Override
	public void save(Privilege p) {
		repository.put(p.getId(), p);

	}

	@Override
	public Privilege findById(int id) {
		return repository.get(id);
	}

	@Override
	public Privilege search(String name) {
		return repository.values().stream().filter(p -> p.getDescription().equalsIgnoreCase(name)).findFirst()
				.orElse(null);

	}

	@Override
	public Privilege delete(int id) {
		Privilege privilege = repository.get(id);
		this.repository.remove(id);
		return privilege;
	}

	@Override
	public List<Privilege> findAll() {
		return repository.values().stream().collect(Collectors.toList());
	}

	@Override
	public void deleteAll() {
		repository.clear();
		
	}

}
