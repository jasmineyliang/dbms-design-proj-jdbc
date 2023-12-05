package coms561project1B;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author Yu-Pin Liang
 * 
 *         Please login to database system by entering userName and password
 * 
 */

public class DropTables {
	public static void main(String[] args) {
		String dbServer = "jdbc:mysql://127.0.0.1:3306/university?useSSL=false&allowPublicKeyRetrieval=true";
		Scanner scan = new Scanner(System.in); // Create a Scanner object
		System.out.println("Enter username: ");
		String userName = scan.nextLine(); // Read user input
		System.out.println("Enter password: ");
		String password = scan.nextLine(); // Read user input
		scan.close();
		Connection conn;
		String sql = "";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbServer, userName, password);
			Statement stmt = conn.createStatement();
			sql = "drop table minor;\r\n";
			stmt.executeUpdate(sql);
			System.out.println("Drop table minor");
			sql = "drop table major;\r\n";
			stmt.executeUpdate(sql);
			System.out.println("Drop table major");
			sql = "drop table register;\r\n";
			stmt.executeUpdate(sql);
			System.out.println("Drop table register");
			sql = "drop table courses;\r\n";
			stmt.executeUpdate(sql);
			System.out.println("Drop table courses");
			sql = "drop table degrees;\r\n";
			stmt.executeUpdate(sql);
			System.out.println("Drop table degrees");
			sql = "drop table departments;\r\n";
			stmt.executeUpdate(sql);
			System.out.println("Drop table departments");
			sql = "drop table students;";
			stmt.executeUpdate(sql);
			System.out.println("Drop table students");

		} catch (Exception e) {
			System.out.println("Program terminates due to errors");
			e.printStackTrace();
		}

	}

}
