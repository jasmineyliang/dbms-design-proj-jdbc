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
public class ModifyRecords {
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
			// (1)
			sql = "Update students\r\n" + "SET name = 'Scott'\r\n" + "where students.ssn = 746897816;";
			stmt.executeUpdate(sql);
			System.out.println("(1) Alternation successful");
			// (2)
			sql = "Update major m\r\n" + "left join students s \r\n" + "on m.snum = s.snum\r\n"
					+ "SET m.name = 'Computer Science', m.level = 'MS'\r\n" + "where s.ssn = 746897816;";
			stmt.executeUpdate(sql);
			System.out.println("(2) Alternation successful");
			// (3)
			sql = "Delete\r\n" + "from register r\r\n" + "where r.regtime = 'Spring2021';";
			stmt.executeUpdate(sql);
			System.out.println("(3) Alternation successful");

		} catch (Exception e) {
			System.out.println("Program terminates due to errors");
			e.printStackTrace();
		}
	}

}
