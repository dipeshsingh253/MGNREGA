package com.mgnrega.dao;
import com.mgnrega.beans.*;

public interface BDOfunctions {

	
	public BDO bdoOfficerlogin(String username, String password);
	
	
	public void createProject(Project project);
	
	
	public void viewAllProjects();
	
	
	public void createGPMmember(GPM gpm);
	
	
	public void viewAllGPMs();
	
	
	public void assignProjecttoGPM(int project_id,int gp_member_id);
	
	
	public void listOfEmployeesWorkingonProject(int proj_id);
	

	
	
	
}
