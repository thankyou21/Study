package com.cg.bs.ft.FundTransfer.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.bs.ft.FundTransfer.entities.Transactions;

public interface TransactionDao extends MongoRepository<Transactions, Integer>
{
	public int getMaxByTnxId();
}
