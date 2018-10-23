package com.cg.mpa.dao;

import java.util.List;
import com.cg.mpa.entities.Mobile;

public interface MobileDao 
{
	List<Mobile> fetchAllMobiles();
}
