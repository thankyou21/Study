package com.cg.bs.cp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bs.cp.entities.ChangeLoginCredential;
import com.cg.bs.cp.entities.UserTable;
import com.cg.bs.cp.service.ChangePasswordService;

@RestController
public class ChangePassword {
	
	@Autowired
	ChangePasswordService cps;
	
	UserTable ut = null;
	
	
	@PostMapping(value="/changepassword")
	public String acceptCredentials(@RequestBody ChangeLoginCredential lc)
	{
		int check = verifyCredentials(lc.getUserId(),lc.getOldPassword());
		if(check==1)
		{
			if(lc.getNewPassword().equals(lc.getConfirmNewPassword()))
			{
				UserTable ut = cps.findById(lc.getUserId()).get();
				ut.setLoginPassword(lc.getNewPassword());
				cps.save(ut);
				return "Password Updated";
			}
			else
				return "3";
		}
		else if(check==0)
			return "2";
		
		return "1";
	}
	
	
	public int verifyCredentials(int userName, String password)
	{
		System.out.println("in vc");
		if(cps.existsById(userName))
		{
			UserTable ut = cps.findById(userName).get();
			if(ut.getLoginPassword().equals(password))
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
