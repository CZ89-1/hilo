package com.yc.hilo.po;

public class Result implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	private int code;
	private String msg;
	private Object data;
	
	public static Result success(String msg) {
		return new Result(1,msg);
	}
	
	public static Result failure(String msg) {
		return new Result(0,msg);
	}
	
	public Result() {
		
	}
	
	public Result(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public Result(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
