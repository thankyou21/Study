package com.cg.bs.ac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bs.ac.entities.AccountMaster;
import com.cg.bs.ac.entities.AddNewCustomer;
import com.cg.bs.ac.entities.Customer;
import com.cg.bs.ac.entities.UserTable;
import com.cg.bs.ac.service.AccountMasterService;
import com.cg.bs.ac.service.CustomerService;
import com.cg.bs.ac.service.UserTableService;

@RestController
public class AddCustomer 
{
 @Autowired
 CustomerService cs;
 
 @Autowired
 UserTableService uts;
 
 @Autowired
 AccountMasterService ams; 
 
 Customer cst=null;
 AccountMaster am=null;
 UserTable ut=null;
 
 String msg="";
	 @PostMapping(value="/addCustomer")
	 public String addCustomer(@RequestBody AddNewCustomer ans)
	 {
		 if(cs.existsById(ans.getPancard()))
		 {
			msg= "1";
		 }
		 
		 else if(uts.existsById(ans.getUserId()))
		 {
			msg= "2";
		 }
		 else if(ams.existsById(ans.getAccountId()))
		 {
			msg= "3";
		 }
		 else if(ans.getAccountBalance()<3000)
		 {
			 msg= "4";
		 }
		 else
		 {
			 cst=new Customer(ans.getPancard(), ans.getCustomerName(),ans.getEmail(), ans.getAddress());
			 cs.save(cst);
			 
			 ut=new UserTable(ans.getUserId(), ans.getLoginPassword(), ans.getSecretQuestion(), ans.getTransactionPassword(), ans.getLockStatus(), ans.getPancard());
			 uts.save(ut);
			 
			 am=new AccountMaster(ans.getAccountId(), ans.getUserId(), ans.getAccountType(), ans.getAccountBalance());
			 ams.save(am);
			 msg= "Records of Customer, User and Account is inserted" + "\nYour User ID is:"+ ans.getUserId()+ "\nYour Account Id is:"+ans.getAccountId();
		 }	
		 
		 return msg;
	 }
}
