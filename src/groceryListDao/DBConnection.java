package groceryListDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public final static String connectionString = "jdbc:mysql://localhost:3306/grocerylist";
	private static Connection conn;
	private static DBConnection instance;

	private DBConnection (Connection conn) {
		this.conn = conn;
	}

	public static Connection getConnection() {
		if ( instance == null) {
			try {
				conn = DriverManager.getConnection(connectionString,"root","root");
				instance = new DBConnection(conn);
				System.out.println("Connected to groceryList");
			}
			catch (SQLException e) {
				System.out.println("Error connecting to DB groceryList");
				e.printStackTrace();
			}

		}
		return DBConnection.conn;
	}
}