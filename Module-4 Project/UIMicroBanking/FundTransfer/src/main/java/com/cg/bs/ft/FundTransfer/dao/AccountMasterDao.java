package com.cg.bs.ft.FundTransfer.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.bs.ft.FundTransfer.entities.AccountMaster;


public interface AccountMasterDao extends MongoRepository<AccountMaster, Integer>
{

}
