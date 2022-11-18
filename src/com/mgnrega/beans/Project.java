package com.mgnrega.beans;

public class Project {

	private int proj_id;
	private String proj_name;

	public Project() {
		super();

	}

	public Project(int proj_id, String proj_name) {
		super();
		this.proj_id = proj_id;
		this.proj_name = proj_name;
	}

	public int getProj_id() {
		return proj_id;
	}

	public void setProj_id(int proj_id) {
		this.proj_id = proj_id;
	}

	public String getProj_name() {
		return proj_name;
	}

	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}

	@Override
	public String toString() {
		return "Project [proj_id=" + proj_id + ", proj_name=" + proj_name + "]";
	}

	public void printDetails() {
		Project project = this;

		System.out.println("================================================");
		System.out.println("Project Name : " + project.getProj_name());
		System.out.println("Project Id : " + project.getProj_id());
		System.out.println("================================================");

		System.out.println();

	}

}
