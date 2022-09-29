package com.mgnrega.beans;

import com.mgnrega.dao.GPMimpl;

public class GPM extends GPMimpl{

	private int id;
	private String name;
	private String email;
	private String username;
	private String password;
	private int proj_id;
	
	
	
	public GPM() {
		super();
		
	}
	
	
	public GPM(int id, String name, String email, String username, String password, int proj_id) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.proj_id = proj_id;
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
	public int getProj_id() {
		return proj_id;
	}


	public void setProj_id(int proj_id) {
		this.proj_id = proj_id;
	}


	@Override
	public String toString() {
		return "GPM [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + ", password="
				+ password + ", proj_id=" + proj_id + "]";
	}

	
	
	public void printDetails(){
		GPM gpm = this;
		
		System.out.println("================================================");
		System.out.println("Member Name : "+gpm.getName());
		System.out.println("Member Id : "+gpm.getId());
		System.out.println("Member Email : "+gpm.getEmail());
		System.out.println("Member Username : "+gpm.getUsername());
		System.out.println("Project id :" + gpm.getProj_id());
		System.out.println("================================================");
		
		System.out.println();
	}

	
	
	
	
}
