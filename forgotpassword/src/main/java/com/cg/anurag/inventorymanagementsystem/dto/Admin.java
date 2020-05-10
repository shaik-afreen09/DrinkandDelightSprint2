package com.cg.anurag.inventorymanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
	@Id
	@Column(name="id")
	int id;
	@Column(name="username")
	String username;
	@Column(name="password")
	public
	String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Admin(String username, String password,int id) {
		super();
		this.username = username;
		this.password = password;
		this.id=id;
	}
	
public Admin() {}
}
