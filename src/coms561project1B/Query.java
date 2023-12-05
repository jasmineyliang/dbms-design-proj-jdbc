package coms561project1B;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Yu-Pin Liang
 * 
 *         Please login to database system by entering userName and password
 * 
 */
public class Query {
	public static void main(String[] args) {
		String dbServer = "jdbc:mysql://127.0.0.1:3306/university?useSSL=false&allowPublicKeyRetrieval=true";
		Scanner scan = new Scanner(System.in); // Create a Scanner object
		System.out.println("Enter username: ");
		String userName = scan.nextLine(); // Read user input
		System.out.println("Enter password: ");
		String password = scan.nextLine(); // Read user input
		scan.close();
		Connection conn;
		ResultSet rs;
		ResultSetMetaData rsMetaData;
		String sql = "";
		String result = "";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbServer, userName, password);
			Statement stmt = conn.createStatement();

			// (1)
			sql = "select snum,ssn from students\r\n" + "where name =  'Becky';";
			stmt.executeQuery(sql);
			rs = stmt.getResultSet();
			rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
					result += rs.getString(i + 1) + ", ";
				}
				result += "\n";

			}
			System.out.println("(1) " + result);

			// (2)
			result = "";
			sql = "select m.name, m.level \r\n" + "from students s \r\n" + "left join major m\r\n"
					+ "ON s.snum = m.snum\r\n" + "where s.ssn =  123097834;";
			stmt.executeQuery(sql);
			rs = stmt.getResultSet();
			rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
					result += rs.getString(i + 1) + ", ";
				}
				result += "\n";

			}
			System.out.println("(2) " + result);

			// (3)
			result = "";
			sql = "select c.name\r\n" + "from departments d\r\n" + "left join courses c\r\n"
					+ "on d.code=c.department_code\r\n" + "where d.name = 'Computer Science';";
			stmt.executeQuery(sql);
			rs = stmt.getResultSet();
			rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
					result += rs.getString(i + 1) + ", ";
				}
				result += "\n";

			}
			System.out.println("(3) " + result);

			// (4)
			result = "";
			sql = "select d.name, d.level\r\n" + "from departments\r\n" + "left join degrees d\r\n"
					+ "on departments.code=d.department_code\r\n" + "where d.name = 'Computer Science';";
			stmt.executeQuery(sql);
			rs = stmt.getResultSet();
			rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
					result += rs.getString(i + 1) + ", ";
				}
				result += "\n";

			}
			System.out.println("(4) " + result);

			// (5)
			result = "";
			sql = "select s.name\r\n" + "from students s\r\n" + "left join minor m\r\n" + "on s.snum  = m.snum \r\n"
					+ "where m.name is not null;";
			stmt.executeQuery(sql);
			rs = stmt.getResultSet();
			rsMetaData = rs.getMetaData();
			while (rs.next()) {
				for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
					result += rs.getString(i + 1) + ", ";
				}
				result += "\n";

			}
			System.out.println("(5) " + result);

		} catch (Exception e) {
			System.out.println("Program terminates due to errors");
			e.printStackTrace();
		}

	}
}
