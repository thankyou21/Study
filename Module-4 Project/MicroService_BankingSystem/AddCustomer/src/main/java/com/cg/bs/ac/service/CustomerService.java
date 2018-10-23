package com.cg.bs.ac.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.bs.ac.entities.Customer;

public interface CustomerService extends MongoRepository<Customer, String>{

}
