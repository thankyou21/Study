package com.cg.bs.ft.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.bs.ft.entities.Transactions;

public interface TransactionDao extends MongoRepository<Transactions, Integer>
{
	public int getMaxByTnxId();
}
