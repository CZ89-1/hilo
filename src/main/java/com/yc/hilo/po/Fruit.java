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
	private Integer hot;
	private Date fdate;
	private Integer guanggao;
	private Integer cid;
	
	public Integer getHot() {
		return hot;
	}
	public void setHot(Integer hot) {
		this.hot = hot;
	}
	public Date getFdate() {
		return fdate;
	}
	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}
	public Integer getGuanggao() {
		return guanggao;
	}
	public void setGuanggao(Integer guanggao) {
		this.guanggao = guanggao;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
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
				+ fdesc + ", fnprice=" + fnprice + ", hot=" + hot + ", fdate=" + fdate + ", guanggao=" + guanggao
				+ ", cid=" + cid + "]";
	}
	
	
}
