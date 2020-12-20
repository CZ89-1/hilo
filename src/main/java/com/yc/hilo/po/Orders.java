package com.yc.hilo.po;

import java.util.Date;

public class Orders implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer oid;
	private Double total;
	private String addr;
	private Date ordertime;
	private String phone;
	private Integer uid;
	private String name;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", total=" + total + ", addr=" + addr + ", ordertime=" + ordertime + ", phone="
				+ phone + ", uid=" + uid + ", name=" + name + "]";
	}
	
}