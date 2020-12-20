package com.yc.hilo.po;

public class Team implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer tId;
	private String tName;
	private String tDuties;
	private String tImage;
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettDuties() {
		return tDuties;
	}
	public void settDuties(String tDuties) {
		this.tDuties = tDuties;
	}
	public String gettImage() {
		return tImage;
	}
	public void settImage(String tImage) {
		this.tImage = tImage;
	}
	@Override
	public String toString() {
		return "Team [tId=" + tId + ", tName=" + tName + ", tDuties=" + tDuties + ", tImage=" + tImage + "]";
	}
	
}