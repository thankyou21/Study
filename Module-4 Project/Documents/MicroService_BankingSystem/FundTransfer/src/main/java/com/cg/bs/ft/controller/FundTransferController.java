package com.cg.bs.ft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bs.ft.entities.AccountMaster;
import com.cg.bs.ft.entities.FundTransfer;
import com.cg.bs.ft.entities.Transactions;
import com.cg.bs.ft.service.AccountMasterDao;
import com.cg.bs.ft.service.TransactionDao;
import com.cg.bs.ft.service.UserTableDao;

@RestController
public class FundTransferController 
{
	@Autowired
	private AccountMasterDao amd = null;
	
	@Autowired
	private TransactionDao td = null;
	
	@Autowired
	private UserTableDao utd = null;
	
	private AccountMaster fromAcDetails=null;
	private Transactions tnxCredit=null;
	private Transactions tnxDebit=null;
	private String msg="";
	
	@PostMapping(value="/fundtransfer")
	public String fundTransfer(@RequestBody FundTransfer ft)
	{
		if(!utd.existsById(ft.getUserId()))
		{
			msg= "1";
		}
		
		if(ft.getFromAc()==ft.getToAc())
		{
			msg= "2";
		}
		
		if(!amd.existsById(ft.getFromAc()))
		{
			msg= "3";
		}
		
		fromAcDetails = amd.findById(ft.getFromAc()).get();
		if(fromAcDetails.getUserId()!=ft.getUserId())
		{
			msg= "4";
		}
		if(fromAcDetails.getAcBalance()<ft.getAmt())
		{
			msg= "Avail Balance of A/c No. "+ft.getFromAc()+" is "+fromAcDetails.getAcBalance();
		}
		if(!amd.existsById(ft.getToAc()))
		{
			msg= "5";
		}
		
		if(!utd.findById(ft.getUserId()).get().getTnxPassword().equals(ft.getTnxPassword()))
		{
			msg= "6";
		}
		else
		{
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
			msg= "Fund Transfered from A/c No. "+ft.getFromAc()+" to A/c No. "+ft.getToAc()+"\nCurrent balance of A/c No. "+ft.getFromAc()+" is Rs. "+fromAcDetails.getAcBalance();
		}
		return msg;
	}
}
