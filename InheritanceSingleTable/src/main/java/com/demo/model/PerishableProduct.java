package com.demo.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("perishable")
public class PerishableProduct extends Product{

	private Date expdate;

	public PerishableProduct() {
		super();
	}

	public PerishableProduct(int pid, String pname, Date mfgdate,Date expdate) {
		super(pid,pname,mfgdate);
		this.expdate = expdate;
	}

	public Date getExpdate() {
		return expdate;
	}

	public void setExpdate(Date expdate) {
		this.expdate = expdate;
	}

	@Override
	public String toString() {
		return "PerishableProduct [expdate=" + expdate + "]";
	}
	
}
