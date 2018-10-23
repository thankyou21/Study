package com.cg.bs.ca.banking.controller;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.cg.bs.ca.banking.entities.*;
import com.cg.bs.ca.exception.BankingException;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
@RestController
public class Controller {

	@Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EurekaClient eurekaClient;
	
    Logger daoLogger = null;
   	public Controller() {
   		super();
   		 daoLogger = Logger.getLogger(Controller.class);
   	     PropertyConfigurator.configure("log4j.properties");
   	}
   	
	@PostMapping("/dashboard/1")
    public String fundTransfer(@RequestBody FundTransfer ft){
         Application application = eurekaClient.getApplication("fund-transfer");
         InstanceInfo instanceInfo = application.getInstances().get(0);
         String url="http://"+instanceInfo.getIPAddr()+":"+instanceInfo.getPort()+"/"+"/fundtransfer";
         daoLogger.info(ft.getUserId()+" requested for url: "+url);
         String result = restTemplate.postForObject(url,ft,String.class);
         if(ft.getFromAc()==0||ft.getToAc()==0||ft.getAmt()==0||ft.getUserId()==0||ft.getTnxPassword().equals("null"))
         {
        	 daoLogger.warn("Insufficient Parameter Passed. Parameters: fromAc, toAc, amt, userId, tnxPassword");
        	 throw new BankingException("Insufficient Parameter Passed. Parameters: fromAc, toAc, amt, userId, tnxPassword");
         }
         else if(result.equals("1"))
         {
        	 daoLogger.warn("Wrong User Name "+ft.getUserId());
        	 throw new BankingException("Wrong User Name "+ft.getUserId());
         }
         else if(result.equals("2"))
         {
        	 daoLogger.warn("Account conflict! Unable to proceed due to same account number entered.");
        	 throw new BankingException("Account conflict! Unable to proceed due to same account number entered.");
         }
         else if(result.equals("3"))
         {
        	 daoLogger.warn("Invalid Account Number "+ft.getFromAc());
        	 throw new BankingException("Invalid Account Number "+ft.getFromAc());
         }
         else if(result.equals("4"))
         {
        	 daoLogger.warn("Cannot Proceed! The account number "+ft.getFromAc()+" doesnot belong to "+ft.getUserId());
        	 throw new BankingException("Cannot Proceed! The account number "+ft.getFromAc()+" doesnot belong to "+ft.getUserId());
         }
         else if(result.equals("5"))
         {
        	 daoLogger.warn("Account Number "+ft.getToAc()+" does not exists");
        	 throw new BankingException("Account Number "+ft.getToAc()+" does not exists");
         }
         else if(result.equals("6"))
         {
        	 daoLogger.warn("Wrong Transaction Password for A/c No. "+ft.getFromAc());
        	 throw new BankingException("Wrong Transaction Password for A/c No. "+ft.getFromAc());
         }
         else if(result.charAt(0)=='A')
         {
        	 daoLogger.warn("Insufficient balance.");
        	 throw new BankingException("Insufficient balance in Account No: "+ft.getFromAc()+". "+result);
         }
         else
         {
        	 daoLogger.info(result);
        	 return result;
         }
         
	}
	
	@PostMapping("/dashboard/2")
    public String changePassword(@RequestBody ChangeLoginCredential clp){
		
         Application application = eurekaClient.getApplication("change-password");
         InstanceInfo instanceInfo = application.getInstances().get(0);
         String url="http://"+instanceInfo.getIPAddr()+":"+instanceInfo.getPort()+"/"+"/changepassword";
         daoLogger.info(clp.getUserId()+" requested for url: "+url);
         String result = restTemplate.postForObject(url,clp,String.class);
         
         if(clp.getUserId()==0||clp.getOldPassword().equals("null")||clp.getNewPassword().equals("null")||clp.getConfirmNewPassword().equals("null"))
         {
        	 daoLogger.warn("Insufficient Parameter Passed. Parameters: userId, oldPassword, newPassword, confirmNewPassword");
        	 throw new BankingException("Insufficient Parameter Passed. Parameters: userId, oldPassword, newPassword, confirmNewPassword");
         }
         else if(result.equals("1"))
         {
        	 daoLogger.warn("Wrong User Name "+clp.getUserId());
        	 throw new BankingException("Wrong User Name "+clp.getUserId());
         }
         else if(result.equals("2"))
         {
        	 daoLogger.warn("Wrong Password");
        	 throw new BankingException("Wrong Password");
         }
         else if(result.equals("3"))
         {
        	 daoLogger.warn("New Password and Confirm New Password mismatch.");
        	 throw new BankingException("New Password and Confirm New Password mismatch.");
         }
         else
         {
        	 daoLogger.info(result);
        	 return result;
         }
	}
	
	
	@PostMapping("/dashboard/3")
	 public String addClient(@RequestBody AddNewCustomer anc)
	 {
		Application application = eurekaClient.getApplication("add-customer");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url="http://"+instanceInfo.getIPAddr()+":"+instanceInfo.getPort()+"/"+"/addCustomer";
        daoLogger.info("Admin requested for url: "+url);
        String result = restTemplate.postForObject(url,anc,String.class);
        if(result.equals("1"))
        {
        	daoLogger.warn("Pancard "+ anc.getPancard()+" exists");
       	 	throw new BankingException("Pancard "+ anc.getPancard()+" exists");
        }
        else if(result.equals("2"))
        {
        	daoLogger.warn("User ID "+ anc.getUserId()+" exists");
        	throw new BankingException("User ID "+ anc.getUserId()+" exists");
        }
        else if(result.equals("3"))
        {
        	daoLogger.warn("Account Number "+ anc.getAccountId()+" exists");
       	 	throw new BankingException("Account Number "+ anc.getAccountId()+" exists");
        }
        else if(result.equals("4"))
        {
        	daoLogger.warn("Balance should be greater than 3000");
       	 	throw new BankingException("Balance should be greater than 3000");
        }
        else
        {
        	daoLogger.info(result);
       	 	return result;
        }
	 }
	
	@PostMapping("/dashboard/4")
	public String viewTransactions(@RequestBody Admin admin)
	{
		Application application = eurekaClient.getApplication("view-transactions");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url="http://"+instanceInfo.getIPAddr()+":"+instanceInfo.getPort()+"/"+"/ViewTransactions";
        daoLogger.info(admin.getAdminId()+" requested for url: "+url);
        String result = restTemplate.postForObject(url,admin,String.class);
        if(admin.getAdminId()==0||admin.getPassword().equals("null"))
        {
       	 daoLogger.warn("Insufficient Parameter Passed. Parameters: adminId, password");
       	 throw new BankingException("Insufficient Parameter Passed. Parameters: adminId, password");
        }
        else if(result.equals("1"))
        {
        	daoLogger.warn("Invalid User-Id / Password");
       	 	throw new BankingException("Invalid User-Id / Password");
        }
        else
        {
        	daoLogger.info("Admin "+admin.getAdminId()+" requested for all transaction.");
       	 	return result;
        }
	}
	
	@RequestMapping("/actuator/info")
	public String apiInfo(){
		return "this is main client api";
	}
	
}
