package br.com.infratech.financeiro.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {

	private static String url = "jdbc:postgresql://localhost:5432/infratech-db";

	private static String password = "postgres";

	private static String user = "postgres";

	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return connection;
	}
}
