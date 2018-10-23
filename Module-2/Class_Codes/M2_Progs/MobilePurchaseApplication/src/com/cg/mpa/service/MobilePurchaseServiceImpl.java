package com.cg.mpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mpa.dao.*;
import com.cg.mpa.entities.Mobile;
import com.cg.mpa.entities.PurchaseDetails;

@Service
@Transactional
public class MobilePurchaseServiceImpl implements MobilePurchaseService
{
	@Autowired
	MobileDao mDao;
	
	@Autowired
	PurchaseDetailDao pDao;
	public List<Mobile> getAllMobiles()
	{
		return mDao.fetchAllMobiles();
	}
	public void insertPurchaseDetails(PurchaseDetails pd)
	{
		pDao.insertPurchaseDetails(pd);
	}
}
