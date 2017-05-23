package com.commom.application.data.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;
import com.commom.application.data.entity.User;

@Component
public class UserDAO {
	
    @Autowired
	MongoOperations mongoTemplate;

	public User saveUser(User user) {
		 mongoTemplate.save(user);;
		 return user;
	}

	public List<User> getUsers() {
		return mongoTemplate.findAll(User.class);
	}
	
}
