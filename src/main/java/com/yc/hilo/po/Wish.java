package com.yc.hilo.po;

public class Wish implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer wid;
	private Integer uid;
	private Integer fid;
	private Integer count;
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
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
		return "Wish [wid=" + wid + ", uid=" + uid + ", fid=" + fid + ", count=" + count + "]";
	}
	
}
