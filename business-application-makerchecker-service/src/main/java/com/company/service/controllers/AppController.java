package com.company.service.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.company.service.dao.GenericDao;
import com.company.service.domain.User;

@RestController
public class AppController {

	@Autowired
	private GenericDao genericDao;

	
	@PostMapping(value = "/save")
	@ResponseStatus(HttpStatus.CREATED)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	List<User> save() {
		User user1 = new User("Mayank", 37);
		User user2 = new User("Parul", 36);
		Stream<User> stream = Stream.of(user1, user2);
		List<User> userList = stream.collect(Collectors.toList());

		genericDao.persist(userList);

		System.out.println("User1 Identity " + user1.getId());
		System.out.println("User2 Identity " + user2.getId());

		return userList;

	}

	@GetMapping(value = "/fetch")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	List<User> fetch() {
		Map<String, Object> params = new HashMap<>();
		params.put("name", "Mayank");
		List<User> userList = genericDao.executeNamedQuery("User.findByUserName", params);
		return userList;

	}

}
