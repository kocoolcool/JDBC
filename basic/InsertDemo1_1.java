package com.iii.eeit101.chris;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

// Insert one employee
public class InsertDemo1_1 {
	public static void main(String[] args) {
		Connection conn = null;
		try {     
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=jdbc";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
			//利用java.util.getDate()再進行格式化為String,利用SimpleDateFormat("yyyy-MM-dd")<--內容為格式可再加hh-mm-ss
			//==格式化
			SimpleDateFormat nowdate = new java.text.SimpleDateFormat("yyyy-MM-dd"); 

			//==GMT標準時間往後加八小時
			nowdate.setTimeZone(TimeZone.getTimeZone("GMT+8"));

			//==取得目前時間
			String sdate = nowdate.format(new java.util.Date());
			
			
			String insStmt = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insStmt);
			pstmt.setInt(1, 1009);
			pstmt.setString(2, "Jean Tsao");
			pstmt.setString(3, sdate);
			pstmt.setDouble(4, 55000);
			pstmt.setInt(5, 100);
			pstmt.setString(6, "senior engineer");
			
			int num = pstmt.executeUpdate();
			System.out.println("insert count = " + num);
			
			pstmt = conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print("name = " + rs.getString("ename") + ", ");
				System.out.println("salary = " + rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch(SQLException e) { 
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class InsertDemo
