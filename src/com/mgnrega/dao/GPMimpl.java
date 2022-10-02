package com.mgnrega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mgnrega.beans.Employee;
import com.mgnrega.beans.GPM;
import com.mgnrega.exceptions.GPMException;
import com.mgnrega.utility.DButility;

public class GPMimpl implements GPMfunctions {

	@Override
	public GPM loginGpm(String username, String password) {

		GPM gpm = null;

		try (Connection connection = DButility.provideConnection()) {

			PreparedStatement ps = connection.prepareStatement("select * from GPM where username=? and password=?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				int proj_id = rs.getInt("proj_id");

				gpm = new GPM(id, name, email, username, password, proj_id);

				System.out.println("login successfull...");
			} else {
				System.out.println("login declined...");
			}

		} catch (SQLException e) {
			System.out.println();
			System.out.println("Error Occured");
			System.out.println();

			System.out.println(e.getMessage());
		}

		return gpm;
	}

	@Override
	public void createEmployee(Employee employee) {

		try (Connection connection = DButility.provideConnection()) {

			connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0").execute();

			PreparedStatement ps = connection
					.prepareStatement("insert into Employees(emp_id,emp_name,email)" + " values(?,?,?)");

			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getEmail());

			int x = ps.executeUpdate();

			if (x > 0) {
				System.out.println("Employee Created Successfuly");
			}

		} catch (Exception e) {

			System.out.println();
			System.out.println("Error Occured");
			System.out.println();

			System.out.println(e.getMessage());
		}

	}

	@Override
	public void employeeDetails(int eid) {

		try (Connection connection = DButility.provideConnection()) {

			PreparedStatement ps = connection.prepareStatement("select * from Employees where emp_id = ?");
			ps.setInt(1, eid);

			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				throw new GPMException("No Employee Related to this Employee Id is Availible");
			}

			// while (rs.next()) {

			int id = rs.getInt("emp_id");
			int proj_id = rs.getInt("proj_id");
			String name = rs.getString("emp_name");
			String email = rs.getString("email");
			int wages = rs.getInt("wage_perday");
			int workdays = rs.getInt("work_days");

			Employee employee = new Employee(id, proj_id, name, workdays, wages, email);

			employee.printDetails();

			// }

		} catch (Exception e) {

			System.out.println();
			System.out.println("Error Occured");
			System.out.println();

			System.out.println(e.getMessage());
		}

	}

	@Override
	public void assignProjecttoEmployee(int... args) {
		
		int project_id = args[0];
		int eid = args[1];
		int wage = args[2];
		int workDays = args[3];
		
		try (Connection connection = DButility.provideConnection()) {

			PreparedStatement ps = connection.prepareStatement("update Employees set proj_id = ?, wage_perday = ?, work_days = ? where emp_id = ?");

			ps.setInt(1, project_id);
			ps.setInt(2, wage);
			ps.setInt(3, workDays);
			ps.setInt(4, eid);
			
			int x = ps.executeUpdate();

			if (x > 0) {
				System.out.println("Project assignned to Desired Employee");
			}

		} catch (Exception e) {

			System.out.println();
			System.out.println("Error Occured");
			System.out.println();

			System.out.println(e.getMessage());

		}

	}

	@Override
	public void dayAndWagesOfEmployee() {
		try (Connection connection = DButility.provideConnection()) {

			PreparedStatement ps = connection.prepareStatement("select emp_id, wage_perday, work_days from Employees");

			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				throw new GPMException("No Employees Availible");
			} else {

				do {

					int id = rs.getInt("emp_id");
					int wages = rs.getInt("wage_perday");
					int workdays = rs.getInt("work_days");
//					int proj_id = rs.getInt("proj_id");
//					String name = rs.getString("emp_name");
//					String email = rs.getString("email");

					Employee employee = new Employee(id, workdays, wages);

					employee.printDetails(id);

				} while (rs.next());

			}

		} catch (Exception e) {

			System.out.println();
			System.out.println("Error Occured");
			System.out.println();

			System.out.println(e.getMessage());
		}

	}

	public void printOptions() {
		System.out.println("Enter Your Choice :");

		System.out.println();

		System.out.println("1. Create Employee");
		System.out.println("2. Employee Details");
		System.out.println("3. Assign Project to Employee");
		System.out.println("4. List of Employees Days and Wages");
		System.out.println("5. Log Out");

	}

}
