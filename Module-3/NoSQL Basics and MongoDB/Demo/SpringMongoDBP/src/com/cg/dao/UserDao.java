package com.cg.dao;

import java.util.List;

import com.cg.bean.User;

public interface UserDao 
{
	public void create(User user);
	public void drop();
	public List<User> getAllUser();
}
