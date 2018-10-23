package com.cg.mpa.service;

import java.util.List;
import com.cg.mpa.entities.*;

public interface MobilePurchaseService 
{
	List<Mobile> getAllMobiles();
	void insertPurchaseDetails(PurchaseDetails pd);
}
