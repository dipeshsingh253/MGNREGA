package com.mgnrega.dao;

import com.mgnrega.beans.*;

public interface BlockDevelopmentOfficerFunction {

	public BlockDevelopmentOfficer bdoOfficerlogin(String username, String password);

	public void createProject(Project project);

	public void viewAllProjects();

	public void createGPMmember(GramPanchayatMember gpm);

	public void viewAllGPMs();

	public void assignProjecttoGPM(int project_id, int gp_member_id);

	public void listOfEmployeesWorkingonProject(int proj_id);

}
