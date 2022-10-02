package com.mgnrega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mgnrega.beans.BDO;
import com.mgnrega.beans.Employee;
import com.mgnrega.beans.GPM;
import com.mgnrega.beans.Project;
import com.mgnrega.exceptions.EmployeeException;
import com.mgnrega.exceptions.GPMException;
import com.mgnrega.exceptions.ProjectException;
import com.mgnrega.utility.DButility;

public class BDOimpl implements BDOfunctions {

	@Override
	public BDO bdoOfficerlogin(String username, String password) {

		BDO bdo = null;

		try (Connection connection = DButility.provideConnection()) {

			PreparedStatement ps = connection.prepareStatement("select * from BDO where username=? and password=?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");

				bdo = new BDO(id, name, email, username, password);

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

		return bdo;
	}

	@Override
	public void createProject(Project project) {

		try (Connection connection = DButility.provideConnection()) {
			PreparedStatement ps = connection.prepareStatement("insert into Projects values(?,?)");

			ps.setInt(1, project.getProj_id());
			ps.setString(2, project.getProj_name());

			int x = ps.executeUpdate();

			if (x > 0) {
				System.out.println("Project Added Successfuly");
			}

		} catch (Exception e) {

			System.out.println();
			System.out.println("Error Occured");
			System.out.println();

			System.out.println(e.getMessage());

		}

	}

	@Override
	public void viewAllProjects() {

		try (Connection connection = DButility.provideConnection()) {

			PreparedStatement ps = connection.prepareStatement("select * from Projects");

			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				throw new ProjectException("No Projects Availible");
			} else {

				do {

					int proj_id = rs.getInt("projId");
					String proj_name = rs.getString("projName");

					Project project = new Project(proj_id, proj_name);

					project.printDetails();

				} while (rs.next());

			}

		} catch (Exception e) {

			System.out.println();
			System.out.println("Error Occured");
			System.out.println();

			System.out.println(e.getMessage());
		}

	}

	@Override
	public void createGPMmember(GPM gpm) {

		try (Connection connection = DButility.provideConnection()) {
			PreparedStatement ps = connection
					.prepareStatement("insert into GPM(id,name,email,username,password)" + " values(?,?,?,?,?)");

			ps.setInt(1, gpm.getId());
			ps.setString(2, gpm.getName());
			ps.setString(3, gpm.getEmail());
			ps.setString(4, gpm.getUsername());
			ps.setString(5, gpm.getPassword());
			// ps.setInt(6, gpm.getProj_id());

			int x = ps.executeUpdate();

			if (x > 0) {
				System.out.println("GP Member added Successfuly");
			}

		} catch (Exception e) {

			System.out.println();
			System.out.println("Error Occured");
			System.out.println();

			System.out.println(e.getMessage());
		}

	}

	@Override
	public void viewAllGPMs() {

		try (Connection connection = DButility.provideConnection()) {

			PreparedStatement ps = connection.prepareStatement("select * from GPM");

			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				throw new GPMException("No Gram Panchayat Members Availible");
			} else {

				do {

					int id = rs.getInt("id");
					int proj_id = rs.getInt("proj_id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String username = rs.getString("username");
					String password = rs.getString("password");

					GPM gpm = new GPM(id, name, email, username, password, proj_id);

					gpm.printDetails();

				} while (rs.next());

			}

		} catch (Exception e) {

			System.out.println();
			System.out.println("Error Occured");
			System.out.println();

			System.out.println(e.getMessage());
		}

	}

	@Override
	public void assignProjecttoGPM(int project_id, int gp_member_id) {

		try (Connection connection = DButility.provideConnection()) {
			PreparedStatement ps = connection.prepareStatement("update GPM set proj_id = ? where id = ?");

			ps.setInt(1, project_id);
			ps.setInt(2, gp_member_id);

			int x = ps.executeUpdate();

			if (x > 0) {
				System.out.println("Project assignned to Desired Member");
			}

		} catch (Exception e) {

			System.out.println();
			System.out.println("Error Occured");
			System.out.println();

			System.out.println(e.getMessage());

		}

	}

	@Override
	public void listOfEmployeesWorkingonProject(int proj_id) {

		try (Connection connection = DButility.provideConnection()) {
			PreparedStatement ps = connection.prepareStatement("select * from Employees where proj_id = ?");

			ps.setInt(1, proj_id);

			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				throw new EmployeeException(
						"There is no working Employee working the Project related to this Project Id");
			} else {

				do {

					int emp_id = rs.getInt("emp_id");
					String emp_name = rs.getString("emp_name");
					String email = rs.getString("email");
					int work_days = rs.getInt("emp_id");
					int wage_perday = rs.getInt("emp_id");

					Employee employee = new Employee(emp_id, proj_id, emp_name, work_days, wage_perday, email);

					employee.printDetails();

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

		System.out.println("1. Create Project");
		System.out.println("2. Create GP Member");
		System.out.println("3. Assign Project to GP Member");
		System.out.println("4. View All Projects");
		System.out.println("5. View All GP Members");
		System.out.println("6. List of Employees Working on Project");
		System.out.println("7. Log Out");

	}
}
