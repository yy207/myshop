package com.example.demo.bean;

import java.io.Serializable;

public class UserInfo implements Serializable {
	public UserInfo(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public UserInfo( ) {
		 
	}
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
