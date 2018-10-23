package com.cg.ftf.service;

import com.cg.ftf.entities.Query;

public interface QueryService 
{
	Query fetchQuery(int queryId); 		//class and method to talk with controller and dao class
}
