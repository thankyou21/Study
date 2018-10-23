package com.cg.ftf.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.ftf.entities.Query;

@Repository
public class QueryDaoImpl implements QueryDao
{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Query fetchQuery(int queryId) 
	{
		Query getQuery = em.find(Query.class,queryId); 		//finding the record for requested query id
		
		return getQuery;
	}

}
