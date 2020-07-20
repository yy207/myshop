package com.example.demo.bean;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name = "userinfo")
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
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column( name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
