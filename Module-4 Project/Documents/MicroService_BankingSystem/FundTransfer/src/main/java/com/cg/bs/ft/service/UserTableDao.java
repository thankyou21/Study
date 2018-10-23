package com.cg.bs.ft.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.bs.ft.entities.UserTable;

public interface UserTableDao extends MongoRepository<UserTable, Integer>
{

}
