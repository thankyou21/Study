package com.cg.bs.vt.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.bs.vt.entities.Admin;

public interface AdminService extends MongoRepository<Admin, Integer> {

}
