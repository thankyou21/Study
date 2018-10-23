package com.cg.ftf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.ftf.entities.Query;
import com.cg.ftf.service.QueryService;

@Controller					//mapping controller class
public class ForumController 
{
	@Autowired		//autowiring the service object
	QueryService qSer;
	
	@RequestMapping("search")			//mapping the method with search.obj
	public String searchQuery(@RequestParam("queryId")Integer queryId, Model model)
	{		
		if(queryId>0)					//checking whether the query is valid or not if valid, proceed
		{
			Query qdetail = qSer.fetchQuery(queryId);		//calling fetchQuery method of service class
			if(qdetail!=null)
			{
				model.addAttribute("qdetails",qdetail);		//adding the fetched object to model view attribute
				return "result";
			}
			else
			{
				model.addAttribute("queryId",queryId);
				return "notFound";
			}
		}
		else							//else return invalid query id page
		{
			return "invalidQueryId";
		}
	}
}
