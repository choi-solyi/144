package com.sy.dto;

public class JGBoardDTO {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwritedate;
	private String bcategory;
	private int bhit;
	private String id;
	private String nick;
	
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
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
	public String getBwritedate() {
		return bwritedate;
	}
	public void setBwritedate(String bwritedate) {
		this.bwritedate = bwritedate;
	}
	public String getBcategory() {
		return bcategory;
	}
	public void setBcategory(String bcategory) {
		this.bcategory = bcategory;
	}
	public int getBhit() {
		return bhit;
	}
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return id ;
	}


}
