package com.iii.eeit101.chris;

import java.sql.*;

//Query all employees using PrepareStatement
public class AutoCloseableDemo {
	public static void main(String[] args) {
		
		String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=jdbc";
		
		try (Connection conn = DriverManager.getConnection(connUrl, "sa", "password");//為什麼Co
				){     
			
			String qryStmt = "SELECT ename, salary FROM employee";
			PreparedStatement pstmt = conn.prepareStatement(qryStmt);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print("name = " + rs.getString("ename") + ", ");
				System.out.println("salary = " + rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}// end of main()
}// end of class QueryDemo4
