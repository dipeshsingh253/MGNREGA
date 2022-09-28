package question1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	
//	public void addStudent() {
//		Scanner scanner = new Scanner(System.in);
//		
//		
//
//	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/sb101c4_eva";
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url, "root", "root");
			
			if(connection!=null) {
				System.out.println("connected...");
			}
			
			
			
			System.out.println();
			
			Statement statement = connection.createStatement();
			
			for(int i=0;i<5;i++) {
				System.out.println("Enter roll:");
				int roll = scanner.nextInt();
				
				scanner.nextLine();
				
				
				System.out.println("Enter name:");
				String name = scanner.nextLine();
				
				System.out.println("Enter address:");
				String address = scanner.nextLine();
				
				System.out.println("Enter mobile:");
				String mobile = scanner.nextLine();
				
				int o = statement.executeUpdate(
						"insert into Student values("+roll+",'"+name+"','"+address+"','"+mobile+"')"
						);
				
				if(o>0) {
					System.out.println("added");
				}
				
			}
			
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
	}

}
