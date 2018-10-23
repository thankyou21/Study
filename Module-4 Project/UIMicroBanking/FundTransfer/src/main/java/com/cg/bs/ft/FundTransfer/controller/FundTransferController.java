package com.cg.bs.ft.FundTransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bs.ft.FundTransfer.dao.AccountMasterDao;
import com.cg.bs.ft.FundTransfer.dao.TransactionDao;
import com.cg.bs.ft.FundTransfer.dao.UserTableDao;
import com.cg.bs.ft.FundTransfer.entities.AccountMaster;
import com.cg.bs.ft.FundTransfer.entities.FundTransfer;
import com.cg.bs.ft.FundTransfer.entities.Transactions;
import com.cg.bs.ft.FundTransfer.entities.UserTable;

@RestController
public class FundTransferController 
{
	@Autowired
	AccountMasterDao amd = null;
	
	@Autowired
	TransactionDao td = null;
	
	@Autowired
	UserTableDao utd = null;
	
	Transactions tnxCredit, tnxDebit;
	
	@PostMapping(value="/fundtransfer")
	//public ResponseClient fundTransfer(@RequestBody FundTransfer ft)
	public String fundTransfer(@RequestBody FundTransfer ft)
	{
		//ResponseClient res=new ResponseClient();
		if(!utd.existsById(ft.getUserId()))
			return "Wrong User Name";
		
		if(ft.getFromAc()==ft.getToAc())
			return "Account conflict! Unable to proceed due to same account number entered.";
			
		
		if(!amd.existsById(ft.getFromAc()))
			return "Invalid Account Number "+ft.getFromAc();
		
		AccountMaster fromAcDetails = amd.findById(ft.getFromAc()).get();
		if(fromAcDetails.getUserId()!=ft.getUserId())
			return "Cannot Proceed! The account number "+ft.getFromAc()+" doesnot belong to you.";
		
		if(fromAcDetails.getAcBalance()<ft.getAmt())
			return "Insufficient balance in Account No: "+fromAcDetails.getAcNumber()+"\nAvailable Balance: RS. "+fromAcDetails.getAcBalance();
				
		if(!amd.existsById(ft.getToAc()))
			return "Account Number "+ft.getToAc()+" does not exists";

		
		if(!utd.findById(ft.getUserId()).get().getTnxPassword().equals(ft.getTnxPassword()))
			return "Wrong Transaction Password";
		
		//storing to a/c details
		AccountMaster toAcDetails = amd.findById(ft.getToAc()).get();
		//getting sequence of tnx
		int tnxId = 0;//td.getMaxByTnxId();
		//debit tnx
		tnxId++;  tnxDebit= new Transactions(tnxId, "Fund Transfered to A/C No. "+ft.getToAc(), "d", ft.getFromAc(), ft.getAmt());
		td.save(tnxDebit);
		//credit tnx
		tnxId++;  tnxCredit= new Transactions(tnxId, "Fund Transfered from A/C No. "+ft.getFromAc(), "c", ft.getToAc(), ft.getAmt());
		td.save(tnxCredit);
		//update balance for to a/c
		fromAcDetails.setAcBalance(fromAcDetails.getAcBalance()-ft.getAmt());
		amd.save(fromAcDetails);
		//update balance for to a/c
		toAcDetails.setAcBalance(toAcDetails.getAcBalance()+ft.getAmt());
		amd.save(toAcDetails);
		return "Fund Transfered from A/c No. "+ft.getFromAc()+" to A/c No. "+ft.getToAc()+"\nCurrent balance of A/c No. "+ft.getFromAc()+" is Rs. "+fromAcDetails.getAcBalance();
	}
	
	@PostMapping(value="/insert")
	public String insert()
	{
		UserTable ut = new UserTable();
		ut.setLoginPassword("log1234");
		ut.setPancard("P1002");
		ut.setSecretQuestion("Kolkata");
		ut.setTnxPassword("tnx1234");
		ut.setUserId(1002);
		utd.save(ut);
		return "Done";
	}
}
