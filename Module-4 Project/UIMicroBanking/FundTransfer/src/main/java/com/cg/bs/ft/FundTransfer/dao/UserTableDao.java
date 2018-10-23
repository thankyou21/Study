package com.cg.bs.ft.FundTransfer.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.bs.ft.FundTransfer.entities.UserTable;

public interface UserTableDao extends MongoRepository<UserTable, Integer>
{

}
