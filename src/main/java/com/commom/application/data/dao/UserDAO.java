package com.commom.application.data.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.commom.application.data.entity.User;

@Component
public class UserDAO {

	@Autowired
	MongoOperations mongoTemplate;

	public User saveUser(User user) {
		mongoTemplate.save(user);
		return user;
	}

	public List<User> getUsers() {
		return mongoTemplate.findAll(User.class);
	}

	public User findByUsername(String username) {
		Query searchUserQuery = new Query(Criteria.where("username").is(
				username));
		User user = mongoTemplate.findOne(searchUserQuery, User.class);
		System.out.println("2. find - savedUser : " + user);
		return user;
	}

	public void updatePassword(String username) {
		Query searchUserQuery = new Query(Criteria.where("username").is(
				username));
		mongoTemplate.updateFirst(searchUserQuery,
				Update.update("password", "new password"), User.class);
	}

	public void deleteUser(String username) {
		Query searchUserQuery = new Query(Criteria.where("username").is(
				username));
		mongoTemplate.remove(searchUserQuery, User.class);
	}

}
