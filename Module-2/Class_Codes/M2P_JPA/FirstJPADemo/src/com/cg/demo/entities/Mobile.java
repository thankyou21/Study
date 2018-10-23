package com.cg.demo.entities;

import javax.persistence.*;

@Entity
@Table(name="Mobiles")
@NamedQueries
(
		@NamedQuery(name="getMobiles", query="select m from Mobile m where m.quantity>:qty")
)

public class Mobile 
{
	@Id
	@SequenceGenerator(name="myseq", sequenceName="seq_mobile", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="myseq")
	@Column(name="mobileid")
	private int mobileId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private int price;
	
	@Column(name="quantity")
	private int quantity;

	public int getMobileId() {
		return mobileId;
	}

	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Mobile [mobileId=" + mobileId + ", name=" + name + ", price="
				+ price + ", quantity=" + quantity + "]";
	}
	
	
}
