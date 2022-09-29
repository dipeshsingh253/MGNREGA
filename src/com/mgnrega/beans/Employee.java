package com.mgnrega.beans;

public class Employee {
	
	private int id;
	private int proj_id;
	private String name;
	private int workingDays;
	private int wage;
	private String email;
	
	
	
	
	public Employee() {
		super();
		
	}
	
	
	public Employee(int id, int proj_id, String name, int workingDays, int wage, String email) {
		super();
		this.id = id;
		this.proj_id = proj_id;
		this.name = name;
		this.workingDays = workingDays;
		this.wage = wage;
		this.email = email;
	}
	
	
	public Employee(int id2, int workdays, int wages) {
		this.id= id2;
		this.wage = wages;
		this.workingDays = workdays;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProj_id() {
		return proj_id;
	}
	public void setProj_id(int proj_id) {
		this.proj_id = proj_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWorkingDays() {
		return workingDays;
	}
	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", proj_id=" + proj_id + ", name=" + name + ", workingDays=" + workingDays
				+ ", wage=" + wage + "]";
	}
	
	
	public void printDetails() {
		Employee employee = this;
		
		System.out.println("================================================");
		System.out.println("Employee Id : "+employee.getId());
		System.out.println("Employee Name : "+employee.getName());
		System.out.println("Employee Email : "+employee.getEmail());
		System.out.println("Total Working Days : "+employee.getWorkingDays());
		System.out.println("Wage Per Days : "+employee.getWage());
		System.out.println("Project Id : "+employee.getProj_id());
		System.out.println("================================================");
		
		System.out.println();
	}
	
	public void printDetails(int eid) {
		Employee employee = this;
		
		System.out.println("================================================");
		System.out.println("Employee Id : "+employee.getId());
		System.out.println("Total Working Days : "+employee.getWorkingDays());
		System.out.println("Wage Per Days : "+employee.getWage());
		System.out.println("================================================");
		
		System.out.println();
	}
	
}
