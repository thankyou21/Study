package com.cg.bs.cp.service;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.bs.cp.entities.UserTable;


public interface ChangePasswordService extends MongoRepository<UserTable,Integer>{
}