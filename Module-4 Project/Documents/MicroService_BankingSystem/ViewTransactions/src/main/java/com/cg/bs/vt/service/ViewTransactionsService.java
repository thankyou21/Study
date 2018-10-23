package com.cg.bs.vt.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.bs.vt.entities.Transactions;

public interface ViewTransactionsService extends MongoRepository<Transactions, Integer>{

}
