package com.cg.ftf.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ftf.dao.QueryDao;
import com.cg.ftf.entities.Query;

@Service
@Transactional
public class QueryServiceImpl implements QueryService
{
	@Autowired
	QueryDao qDao;
	@Override
	public Query fetchQuery(int queryId) 
	{
		
		return qDao.fetchQuery(queryId);   //returning the object obtained from dao class
	}

}
