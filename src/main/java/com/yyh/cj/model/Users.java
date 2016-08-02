package com.yyh.cj.model;

import java.io.Serializable;

public class Users implements Serializable{

	/**
	 * 用户类
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	private String name;
	private String password;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
