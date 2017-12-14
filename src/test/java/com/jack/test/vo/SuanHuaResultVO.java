package com.jack.test.vo;

public class SuanHuaResultVO<D> {
	private boolean success;
	private String errors;
	private D data;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}
	public D getData() {
		return data;
	}
	public void setData(D data) {
		this.data = data;
	}
	
}
