package com.iii.eeit101.jdbc.chris;

import java.sql.*;
import java.io.*;

public class BLOBDemo {
	public static void main(String[] args) {
		Connection conn = null;
		String inFile = args[0];//run Configurations Arguments 選擇 string_prompt, rcs/Tomcat.gif /rcs/aa.gif
		String outFile = args[1];
		try {     
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=jdbc";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
			
			String qryStmt = "SELECT photo FROM blobtest WHERE name = ?";
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, inFile);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				String deleteStmt = "DELETE FROM blobtest WHERE name = ?"; 
				stmt = conn.prepareStatement(deleteStmt);
				stmt.setString(1, inFile);
				stmt.executeUpdate();
				System.out.println("Delete blob is successful!");
			}
			
			File f = new File(inFile);
			FileInputStream fis = new FileInputStream(f);
			String insertStmt = "INSERT INTO blobtest VALUES(?,?)";		
			stmt = conn.prepareStatement(insertStmt);
			stmt.setString(1, inFile);
			stmt.setBinaryStream(2, fis, f.length());
			stmt.executeUpdate();
			System.out.println("Insert blob is successful!");
	
			stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, inFile);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				FileOutputStream fos = new FileOutputStream(outFile);
				Blob b = rs.getBlob("photo");
				byte[] data = b.getBytes(1, (int)b.length());
				fos.write(data, 0, (int)b.length());
				fos.close();
				System.out.println("File output is successful!");
			} // end of if (rs.next()) 
		} catch (Exception e) {
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
}// end of class BLOBDemo 
