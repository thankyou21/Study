package com.cg.ftf.dao;

import com.cg.ftf.entities.Query;

public interface QueryDao 
{
	Query fetchQuery(int queryId);		//the method to talk with database
}
