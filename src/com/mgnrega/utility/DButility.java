package com.mgnrega.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButility {

	public static Connection provideConnection() {
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/MGNREGA";

		try {
			connection = DriverManager.getConnection(url, "root", "root");
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return connection;
	}

}
