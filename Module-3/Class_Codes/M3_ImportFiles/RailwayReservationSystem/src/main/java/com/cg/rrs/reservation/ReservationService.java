package com.cg.rrs.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rrs.entity.ReservationDetails;
import com.cg.rrs.exception.ReservationException;


//controller class
@RestController
public class ReservationService 
{
	//auto-wiring Reservation Dao 
	@Autowired
	ReservationDao rDao;
	
	//insert records
	@PostMapping("/rrs/insert")
	public ReservationDetails insert(@RequestBody ReservationDetails rd)
	{
			if(!rDao.existsById(rd.getPnrNo()))
			{
					rDao.save(rd);
					return rd;
			}
			return null;
	}
	
	//Retrieve one records
	@GetMapping(value="/rrs/select/{pnrNo}")
	public ReservationDetails read(@PathVariable("pnrNo") String pnrNo) throws Exception
	{
		
		//try to fetch record
		try
		{
			ReservationDetails rd = rDao.findById(pnrNo).get();
			return rd;
		}
		//if not found throw exception 
		catch(Exception e)
		{
			throw new ReservationException("PNR not Found. Wrong PNR no : "+pnrNo);
		}
	}
}
