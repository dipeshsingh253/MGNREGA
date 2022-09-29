package com.mgnrega.beans;

import com.mgnrega.dao.BDOimpl;

public class BDO extends BDOimpl{
	
	private int id;
	private String name;
	private String email;
	private String username;
	private String password;

	
	public BDO() {
		super();
	
	}
	
	
	public BDO(int id, String name, String email, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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


	@Override
	public String toString() {
		return "BDO [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + ", password="
				+ password + "]";
	}
	
	
	public void printDetails() {
		BDO bdo = this;
		
		System.out.println("================================================");
		System.out.println("Officer Id : "+bdo.getId());
		System.out.println("Officer Name : "+bdo.getName());
		System.out.println("Officer Email : "+bdo.getEmail());
		System.out.println("Officer Username : "+bdo.getUsername());
		System.out.println("================================================");
		
		System.out.println();
		
	}

}
