package com.mgnrega.dao;
import com.mgnrega.beans.*;

public interface GPMfunctions {

	public GPM loginGpm(String username,String password);
	
	
	public void createEmployee(Employee employee);

	
	public void employeeDetails(int eid);
	
	
	public void assignProjecttoEmployee(int poj_id, int emp_id);
	
	
	public void dayAndWagesOfEmployee();
	
}
