package com.cg.rrs.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//name of collection in MongoDB
@Document(collection="Reservation")
public class ReservationDetails 
{
	@Id
	String pnrNo;	//unique id of collection: Reservation
	String passenger_name, source_loc,desc_loc;
	int price;
	
	//getters and setters 
	public String getPnrNo() {
		return pnrNo;
	}
	public void setPnrNo(String pnrNo) {
		this.pnrNo = pnrNo;
	}
	public String getPassenger_name() {
		return passenger_name;
	}
	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}
	public String getSource_loc() {
		return source_loc;
	}
	public void setSource_loc(String source_loc) {
		this.source_loc = source_loc;
	}
	public String getDesc_loc() {
		return desc_loc;
	}
	public void setDesc_loc(String desc_loc) {
		this.desc_loc = desc_loc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
