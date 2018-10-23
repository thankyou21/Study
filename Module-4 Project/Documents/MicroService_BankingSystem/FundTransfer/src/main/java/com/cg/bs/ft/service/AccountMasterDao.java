package com.cg.bs.ft.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.bs.ft.entities.AccountMaster;


public interface AccountMasterDao extends MongoRepository<AccountMaster, Integer>
{

}
