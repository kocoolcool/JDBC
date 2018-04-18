package com.iii.eeit101.chris;

import java.sql.*;

//Query all employees using Statement
//採用Class Loader方式產生Driver實體，並註冊到Driver Manager的驅動程式註冊表單中
public class QueryDemo1 {
	public static void main(String[] args) {
		try {     
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//載入JDBC Driver
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=jdbc";//設定URL為connUrl
			Connection conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");//建立Connection	
			
			String qryStmt = "SELECT ename,title,salary FROM employee";//下SQL指令
			Statement stmt = conn.createStatement();//建立SQL指令
			ResultSet rs = stmt.executeQuery(qryStmt);//DB Query放置Memories
			
			while(rs.next()) {//撈出資料to Console
				System.out.print("name = " + rs.getString("ename") + ", ");
				System.out.println("salary = " + rs.getDouble("salary"));
				
			//	System.out.print("name = " + rs.getString(1) + ", ");
			//	System.out.println("salary = " + rs.getDouble(2));
			}
		
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end of main()
}// end of class QueryDemo1
