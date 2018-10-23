package com.cg.bs.ac.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.bs.ac.entities.UserTable;

public interface UserTableService extends MongoRepository<UserTable, Integer>{

}
