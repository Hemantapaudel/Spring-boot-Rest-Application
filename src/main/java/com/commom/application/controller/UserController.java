package com.commom.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.commom.application.data.dao.UserDAO;
import com.commom.application.data.entity.User;

@RestController
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = { "createUser" }, produces = {
			"application/json", "application/xml" }, method = { RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public User createUser(@RequestBody User user) {
		 return userDAO.saveUser(user);
	}
	
	@RequestMapping(value = { "getUsers" }, produces = { "application/json" },
			method = { RequestMethod.GET })
	@ResponseBody
	public List<User> getUsers() {
		return userDAO.getUsers();
	}
	
}
