package com.eb.dto;

public class CalSubBoardDTO {
	private int repno;
	private String rcontent;
	private String rwritedate;
	private int bno;
	private String id;
	public int getRepno() {
		return repno;
	}
	public void setRepno(int repno) {
		this.repno = repno;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRwritedate() {
		return rwritedate;
	}
	public void setRwritedate(String rwritedate) {
		this.rwritedate = rwritedate;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CalSubBoardDTO [repno=" + repno + ", rcontent=" + rcontent + ", rwritedate=" + rwritedate + ", bno=" + bno + ", id=" + id + "]";
	}
	
}
