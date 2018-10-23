package com.cg.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.cg.bean.User;

public class UserDaoImpl implements UserDao
{
	private static final String COLLECTION = "users";
	@Autowired
	MongoTemplate mongoTemplate;
	public void create(User user) 
	{
		if (user != null)
		{
			this.mongoTemplate.insert(user, COLLECTION);
		}
	}
	//----------This will drop database----------
	public void drop() 
	{
		this.mongoTemplate.dropCollection(COLLECTION);
	}
	public List<User> getAllUser()
	{
		Query query = new Query();
		query.fields().include("name").include("age").include("id");
		List<User> usrs = mongoTemplate.find(query, User.class);
		return usrs;

	}

}
