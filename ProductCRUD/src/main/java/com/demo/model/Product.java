package com.demo.model;

public class Product {
	private int pid;
	private String title;
	private String desc;
	private int unit;
	private int catid;
	private int unitstock;
	public Product(int pid, String title, String desc, int unit, int catid, int unitstock) {
		super();
		this.pid = pid;
		this.title = title;
		this.desc = desc;
		this.unit = unit;
		this.catid = catid;
		this.unitstock = unitstock;
	}
	public Product(String title, String desc, int unit, int catid, int unitstock) {
		super();
		this.title = title;
		this.desc = desc;
		this.unit = unit;
		this.catid = catid;
		this.unitstock = unitstock;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public int getUnitstock() {
		return unitstock;
	}
	public void setUnitstock(int unitstock) {
		this.unitstock = unitstock;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", title=" + title + ", desc=" + desc + ", unit=" + unit + ", catid=" + catid
				+ ", unitstock=" + unitstock + "]";
	}
	
}
