package com.cg.bs.ca.banking.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.cg.bs.ca.banking.entities.*;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Controller 
public class BankController {

	@Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EurekaClient eurekaClient;
	
	@PostMapping("/dashboard/1")
    public String fundTransfer(@RequestBody FundTransfer ft){
         Application application = eurekaClient.getApplication("fund-transfer");
         InstanceInfo instanceInfo = application.getInstances().get(0);
         String url="http://"+instanceInfo.getIPAddr()+":"+instanceInfo.getPort()+"/"+"/fundtransfer";
         return restTemplate.postForObject(url,ft,String.class);
    }
	
	@PostMapping("/dashboard/2")
    public String changePassword(@RequestBody ChangeLoginCredential clp){
         Application application = eurekaClient.getApplication("change-password");
         InstanceInfo instanceInfo = application.getInstances().get(0);
         String url="http://"+instanceInfo.getIPAddr()+":"+instanceInfo.getPort()+"/"+"/changepassword";
         return restTemplate.postForObject(url,clp,String.class);
    }
	
	
	@PostMapping("/dashboard/3")
	 public String addClient(@RequestBody AddNewCustomer anc)
	 {
		Application application = eurekaClient.getApplication("add-customer");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url="http://"+instanceInfo.getIPAddr()+":"+instanceInfo.getPort()+"/"+"/addCustomer";
        return restTemplate.postForObject(url,anc,String.class);
	 }
	
	@PostMapping("/dashboard/4")
	public String viewTransactions(@RequestBody Admin admin)
	{
		Application application = eurekaClient.getApplication("view-transactions");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url="http://"+instanceInfo.getIPAddr()+":"+instanceInfo.getPort()+"/"+"/ViewTransactions";
        return restTemplate.postForObject(url,admin,String.class);
	}
	
	@RequestMapping("/actuator/info")
	public String apiInfo(){
		return "this is main client api";
	}
	
	
	//Initialization
	@GetMapping("/banking")
	public String bank(HttpServletRequest request, Model model) {
	    return "/home.jsp";
	}
	
	
	//Fund Transfer
	@GetMapping("/fund")
	public String fund(HttpServletRequest request, Model model) {
		FundTransfer ft = new FundTransfer();
		model.addAttribute("ft", ft);
	    return "/transfer.jsp";
	}
	
	
	
	@PostMapping(value="/fundtransfer")
	public String transfer(@ModelAttribute("ft") FundTransfer ft, Model model)
	{
		System.out.println(ft);
	    List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
	    acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(acceptableMediaTypes);
	    
	    HttpEntity<FundTransfer> entity = new HttpEntity<>(ft, headers);
	    System.out.println("After HttpEntity");
	    
	   
        String url=getTransferUrl()+"/fundtransfer";
	    
        System.out.println(url);
        
	    ResponseEntity<String> funds = restTemplate.postForEntity(url, entity, String.class);
	    
	   
	    System.out.println("2nd: "+funds.getBody());
	
	    return "/msg.jsp";
	}

	
	
	
	
	//Change Password
	@GetMapping("/change")
	public String change(HttpServletRequest request, Model model) {
		ChangeLoginCredential ut = new ChangeLoginCredential();
		
		model.addAttribute("ut", ut);
		
	    return "/password.jsp";
	}
	
	
	@PostMapping(value="/changepwd")
	public String insertAirportAction(@ModelAttribute("anc") ChangeLoginCredential ut, Model model)
	{
		System.out.println(ut);
	    List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
	    acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(acceptableMediaTypes);
	    
	    HttpEntity<ChangeLoginCredential> entity = new HttpEntity<>(ut, headers);
	    System.out.println("After HttpEntity");
	    
	   
        String url=getPasswordUrl()+"/changepassword";
	    
        System.out.println(url);
        
	    ResponseEntity<String> newpwd = restTemplate.postForEntity(url, entity, String.class);
	    
	   
	    System.out.println("2nd: "+newpwd.getBody());
	    if(newpwd.getBody().equals("Wrong User Name"))
	    {
	    	model.addAttribute("msg","Wrong User Name");
	    }
	    else if(newpwd.getBody().equals("Wrong Password"))
	    {
	    	model.addAttribute("msg","Wrong Password");
	    }
	    else if(newpwd.getBody().equals("New Password and Confirm New Password mismatch."))
	    {
	    	model.addAttribute("msg","New Password and Confirm New Password mismatch.");
	    }
	    else if(newpwd.getBody().equals("Password Updated"))
	    {
	    	model.addAttribute("msg","Password Successfully Updated for UserId: "+ut.getUserId());
	    }
	    return "/msg.jsp";
	}

	
	
	
	
	//TransferUrl
	public String getTransferUrl()
    {
        Application application = eurekaClient.getApplication("fund-transfer");
        
        InstanceInfo instanceInfo = application.getInstances().get(0);
        
        String hostname = instanceInfo.getHostName();
        int port = instanceInfo.getPort();
        
        return "http://" + hostname + ":" + port;
    }
	
	
	//PasswordUrl
	public String getPasswordUrl()
    {
        Application application = eurekaClient.getApplication("change-password");
        
        InstanceInfo instanceInfo = application.getInstances().get(0);
        
        String hostname = instanceInfo.getHostName();
        int port = instanceInfo.getPort();
        
        return "http://" + hostname + ":" + port;
    }
	
}
