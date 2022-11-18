package com.mgnrega.driver;

import java.util.Scanner;
import com.mgnrega.beans.BlockDevelopmentOfficer;
import com.mgnrega.beans.Employee;
import com.mgnrega.beans.GramPanchayatMember;
import com.mgnrega.beans.Project;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public void printOptions() {
		System.out.println("Enter Your Choice :");

		System.out.println();

		System.out.println("1. Login as Block Development Officer");
		System.out.println("2. Login as Gram Panchayat Member");
		System.out.println("3. Exit");

	}

	public void bdoActions(String username, String password) {

		BlockDevelopmentOfficer bdOfficer = new BlockDevelopmentOfficer();
		// shivay220

		bdOfficer = bdOfficer.bdoOfficerlogin(username, password);

		if (bdOfficer == null) {

			System.out.println("Try Again with Right username and password");

			Main.main(null);

			return;
		}

		bdOfficer.printDetails();
		int choice = 0;

		while (choice < 7) {

			bdOfficer.printOptions();

			choice = scanner.nextInt();

			switch (choice) {

			case 1: {

				final int proj_id;
				final String proj_name;

				System.out.println("Enter Project Id :");
				proj_id = scanner.nextInt();

				scanner.nextLine();

				System.out.println("Enter Project Name :");
				proj_name = scanner.nextLine();

				bdOfficer.createProject(new Project(proj_id, proj_name));

				break;

			}
			case 2: {

				final int id;
				final String name;
				final String email;
				final String userName;
				final String passWord;
				// final int proj_id;

				System.out.println("Enter New GP Member Details :");

				System.out.println("Enter Member Id :");
				id = scanner.nextInt();

				scanner.nextLine();

				System.out.println("Enter Member Name :");
				name = scanner.nextLine();

				System.out.println("Enter Email :");
				email = scanner.nextLine();

				System.out.println("Enter Username :");
				userName = scanner.nextLine();

				System.out.println("Enter Password :");
				passWord = scanner.nextLine();

//				System.out.println("Enter Proj_id"); 
//				proj_id = scanner.nextInt();

				bdOfficer.createGPMmember(new GramPanchayatMember(id, name, email, userName, passWord, 0));

				break;
			}

			case 3: {

				final int proj_id;
				final int member_id;

				System.out.println("Enter Project Id :");
				proj_id = scanner.nextInt();

				System.out.println("Enter Member Id :");
				member_id = scanner.nextInt();

				bdOfficer.assignProjecttoGPM(proj_id, member_id);

				break;
			}

			case 4: {

				bdOfficer.viewAllProjects();

				break;

			}

			case 5: {

				bdOfficer.viewAllGPMs();

				break;

			}

			case 6: {

				final int proj_id;

				System.out.println("Enter Project Id :");
				proj_id = scanner.nextInt();

				bdOfficer.listOfEmployeesWorkingonProject(proj_id);

				break;

			}

			case 7: {

				System.out.println("Logged Out Successfuly");

				Main.main(null);

				break;

			}

			}

		}

	}

	public void gpmActions(String username, String password) {

		GramPanchayatMember member = new GramPanchayatMember();

		member = member.loginGpm(username, password);

		if (member == null) {

			System.out.println("Try Again with Right username and Password");

			Main.main(null);

			return;
		}

		member.printDetails();

		int choice = 0;

		while (choice < 5) {

			member.printOptions();
			choice = scanner.nextInt();

			switch (choice) {
			case 1: {

				final Employee employee = new Employee();

				System.out.println("Enter Employee Id :");
				employee.setId(scanner.nextInt());

				scanner.nextLine();

				System.out.println("Enter Employee Name :");
				employee.setName(scanner.nextLine());

				System.out.println("Enter Employee Email :");
				employee.setEmail(scanner.nextLine());

				member.createEmployee(employee);

				break;

			}

			case 2: {
				final int eid;

				System.out.println("Enter Employee Id :");
				eid = scanner.nextInt();

				member.employeeDetails(eid);

				break;
			}

			case 3: {
				final int eid;
				final int proj_id;
				final int wage;
				final int workDays;

				System.out.println("Enter Employee Id :");
				eid = scanner.nextInt();

				System.out.println("Enter Project Id :");
				proj_id = scanner.nextInt();

				System.out.println("Enter Wage Per Day for Employee :");
				wage = scanner.nextInt();

				System.out.println("Enter Workdays for Employee :");
				workDays = scanner.nextInt();

				member.assignProjecttoEmployee(proj_id, eid, wage, workDays);

				break;
			}

			case 4: {

				member.dayAndWagesOfEmployee();

				break;

			}

			case 5: {

				System.out.println("Logged Out Successfuly");

				Main.main(null);
				break;

			}
			}
		}

	}

	public void askForLoginDetails(int choice) {

		scanner.nextLine();

		System.out.println("Enter Username :");
		String username = scanner.nextLine();

		System.out.println("Enter Password :");
		String password = scanner.nextLine();

		if (choice == 1) {

			bdoActions(username, password);

		} else {

			gpmActions(username, password);

		}

	}

	public static void main(String[] args) {

		Main main = new Main();

		System.out.println("Welcome to MGNREGA Portal");

		int choice = 0;

		main.printOptions();

		choice = scanner.nextInt();

		switch (choice) {
		case 1: {

			main.askForLoginDetails(choice);
			break;
		}
		case 2: {

			main.askForLoginDetails(choice);
			break;

		}
		case 3: {
			System.out.println("Thanks For Using Our Service");
		}

		}

		scanner.close();

	}

}
