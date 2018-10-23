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
 
 
 @PostMapping(value="/addCustomer")
 public String addCustomer(@RequestBody AddNewCustomer ans)
 {
	 if(cs.existsById(ans.getPancard()))
		return "Pancard "+ ans.getPancard()+" exists";
	 
	 if(uts.existsById(ans.getUserId()))
		return "User ID "+ ans.getUserId()+" exists";
	 
	 if(ams.existsById(ans.getAccountId()))
		return "Account Number "+ ans.getAccountId()+" exists";
			
	 if(ans.getAccountBalance()<3000)
	 {
		 return "Balance should be greater than 3000";
	 }
	 
	 cst=new Customer(ans.getPancard(), ans.getCustomerName(),ans.getEmail(), ans.getAddress());
	 cs.save(cst);
	 
	 ut=new UserTable(ans.getUserId(), ans.getLoginPassword(), ans.getSecretQuestion(), ans.getTransactionPassword(), ans.getLockStatus(), ans.getPancard());
	 uts.save(ut);
	 
	 am=new AccountMaster(ans.getAccountId(), ans.getUserId(), ans.getAccountType(), ans.getAccountBalance());
	 ams.save(am);
	 return "Records of Customer, User and Account is inserted" + "\nYour User ID is:"+ ans.getUserId()+ "\nYour Account Id is:"+ans.getAccountId();
		
 }
}
