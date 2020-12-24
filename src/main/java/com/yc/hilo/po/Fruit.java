package com.yc.hilo.po;

import java.util.Date;

public class Fruit implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer fid;
	private String fname;
	private Double fprice;
	private String fImage;
	private String fdesc;
	private Double fnprice;
	private Date fdate;
	private Integer guanggao;
	
	
	
	
	public Integer getGuanggao() {
		return guanggao;
	}
	public void setGuanggao(Integer guanggao) {
		this.guanggao = guanggao;
	}
	public Date getFdate() {
		return fdate;
	}
	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}
	public Double getFnprice() {
		return fnprice;
	}
	public void setFnprice(Double fnprice) {
		this.fnprice = fnprice;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public Double getFprice() {
		return fprice;
	}
	public void setFprice(Double fprice) {
		this.fprice = fprice;
	}
	public String getfImage() {
		return fImage;
	}
	public void setfImage(String fImage) {
		this.fImage = fImage;
	}
	public String getFdesc() {
		return fdesc;
	}
	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}
	@Override
	public String toString() {
		return "Fruit [fid=" + fid + ", fname=" + fname + ", fprice=" + fprice + ", fImage=" + fImage + ", fdesc="
				+ fdesc + "]";
	}
	
}
