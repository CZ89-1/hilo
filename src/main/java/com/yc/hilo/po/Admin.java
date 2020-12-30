package com.yc.hilo.po;

public class Admin implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer aid;
	private String aname;
	private String password;
	private String email;
	
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", aname=" + aname + ", password=" + password + ", email=" + email + "]";
	}
	
	
}
