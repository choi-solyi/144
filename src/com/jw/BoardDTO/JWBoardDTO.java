package com.jw.BoardDTO;

public class JWBoardDTO {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwritedate;
	private String bcategory;
	private int bhit;
	private int bup;
	private String bimg;
	private String id;
	private String nick;
	private int repcount;
	
	public int getRepcount() {
		return repcount;
	}
	public void setRepcount(int repcount) {
		this.repcount = repcount;
	}
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
	@Override
	public String toString() {
		return "JWBoardDTO [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwritedate=" + bwritedate
				+ ", bcategory=" + bcategory + ", bhit=" + bhit + ", bup=" + bup + ", bimg=" + bimg + ", id=" + id
				+ ", nick=" + nick + ", repcount=" + repcount + "]";
	}

}
