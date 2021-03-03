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
import com.iot.iotdemo.model.Door;
import com.iot.iotdemo.utils.Utils;

@Repository
public class DoorReposiroty implements ObjectRepository<Door> {

	private Map<Integer, Door> repository;

	public DoorReposiroty() throws IOException {
		final ObjectMapper objectMapper = new ObjectMapper();
		File file = Utils.readJsonFile("doors.json");
		List<Door> doors;
		try {
			doors = objectMapper.readValue(file, new TypeReference<List<Door>>() {});
			this.repository = doors.stream().collect(Collectors.toMap(Door::getId, door -> door));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void save(Door d) {
		repository.put(d.getId(), d);

	}

	@Override
	public Door findById(int id) {
		return repository.get(id);
	}

	@Override
	public Door search(String name) {
		return new Door();

	}

	@Override
	public Door delete(int id) {
		Door door = repository.get(id);
		this.repository.remove(id);
		return door;
	}

	@Override
	public List<Door> findAll() {
		return repository.values().stream()
			.collect(Collectors.toList());
	}

	@Override
	public void deleteAll() {
		repository.clear();
		
	}

}
