package com.mgnrega.dao;

import com.mgnrega.beans.*;

public interface GramPanchayatMemberFunction {

	public GramPanchayatMember loginGpm(String username, String password);

	public void createEmployee(Employee employee);

	public void employeeDetails(int eid);

	public void assignProjecttoEmployee(int... args);

	public void dayAndWagesOfEmployee();

}
