package com.cg.bs.vt.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bs.vt.entities.Admin;
import com.cg.bs.vt.entities.Transactions;
import com.cg.bs.vt.service.AdminService;
import com.cg.bs.vt.service.ViewTransactionsService;

@RestController
public class ViewTransactions 
{
	@Autowired
	ViewTransactionsService vts;
	
	@Autowired
	AdminService ad;
	
	Transactions txn=null;
	Admin adm=null;
	
	List<Transactions> tList = null;
	String msg;
	
	@PostMapping(value="/insertTransactions")
	public String insertDetails(@RequestBody Transactions txn)
	{
		if(!vts.existsById(txn.getAccountNo()))
		{
			vts.save(txn);
			msg= "Success";
			
		}
		else
		{
			msg= "This account already exists";
		}
		return msg;
	}
	
	@PostMapping(value="/insertAdminDetails")
	public String insertAdminDetails(@RequestBody Admin adm)
	{
		if(!ad.existsById(adm.getAdminId()))
		{
			ad.save(adm);
			msg= "Success";
			
		}
		else
		{
			msg= "This admin already exists";
		}
		return msg;
	}
	
	@PostMapping(value="/ViewTransactions")
	public String viewTransactions(@RequestBody Admin ad)
	{
		System.out.println(ad.getAdminId()+ad.getPassword());
		String msg="Tnx ID\tA/c No.\tType\tAmount\tTnx Description\n";
		int check = verifyCredentials(ad.getAdminId(),ad.getPassword());
		if(check==1)
		{
			tList=vts.findAll();
			System.out.println(tList);
			for(Transactions t:tList)
				msg=msg+t.getTransactionId()+"\t"+t.getAccountNo()+"\t"+t.getTransactionType()+"\t"+t.getTranAmount()+"\t"+t.getTranDescription()+"\n";
		}
		
		else
		{
			msg= "1";
		}
		return msg;
	}
	
	public int verifyCredentials(int adminId, String password)//@PathVariable("userId")int userId, @PathVariable("pwd")String pwd ){
	{
		
		if(ad.existsById(adminId))
		{
			Admin adm = ad.findById(adminId).get();
			if(adm.getPassword().equals(password))
			{
				return 1;
			}
			else
				return 0;
		}
		else
			return -1;
	}
	
}
