package com.yc.hilo.po;

public class Cart implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer ccid;
	private Integer uid;
	private Integer fid;
	private Integer count;
	public Integer getCcid() {
		return ccid;
	}
	public void setCcid(Integer ccid) {
		this.ccid = ccid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Cart [ccid=" + ccid + ", uid=" + uid + ", fid=" + fid + ", count=" + count + "]";
	}
	
}
