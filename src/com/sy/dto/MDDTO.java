package com.sy.dto;

public class MDDTO {
	private int mdcode;
	private String mdname;
	private int price;
	private String img;
	
	
	
	public int getMdcode() {
		return mdcode;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public void setMdcode(int mdcode) {
		this.mdcode = mdcode;
	}
	public String getMdname() {
		return mdname;
	}
	public void setMdname(String mdname) {
		this.mdname = mdname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
