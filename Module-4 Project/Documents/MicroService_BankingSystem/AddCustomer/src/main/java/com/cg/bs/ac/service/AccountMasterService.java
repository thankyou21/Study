package com.cg.bs.ac.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.bs.ac.entities.AccountMaster;

public interface AccountMasterService extends MongoRepository<AccountMaster, Integer>{

}
