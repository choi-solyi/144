package com.eb.dto;

public class CalBoardDTO {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bcaldate; 
	private int bhit;
	private int bup;
	private String bimg;
	private String id;
	
	@Override
	public String toString() {
		return "CalBoardDTO [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bcaldate=" + bcaldate
				+ ", bhit=" + bhit + ", bup=" + bup + ", bimg=" + bimg + ", id=" + id + "]";
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBcaldate() {
		return bcaldate;
	}
	public void setBcaldate(String bcaldate) {
		this.bcaldate = bcaldate;
	}
	public int getBhit() {
		return bhit;
	}
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	public int getBup() {
		return bup;
	}
	public void setBup(int bup) {
		this.bup = bup;
	}
	public String getBimg() {
		return bimg;
	}
	public void setBimg(String bimg) {
		this.bimg = bimg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
