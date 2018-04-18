package com.iii.eeit101.chris;

import java.sql.*;

// Query selected employees
public class HomeWorkString {
	public static void main(String[] args) {
		Connection conn = null;
		try {     
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=db01";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");			
			
		 	String qryStmt = "  select name , salary  FROM employee ";		 //HomeWork1
//		    String qryStmt = "  select a , b,  c  From T ";
			String	qryStmt1=qryStmt.trim();
			String	qryStmtArray[]= 	qryStmt1.split(",\\s+|\\s+,\\s+|\\s+|\\s+,|,");	//用split()內容用正規表示法分割|可用多種判斷
			
			System.out.println(qryStmtArray[0]);
			for(int i=0;i<qryStmtArray.length;i++) {
				if(qryStmtArray[i].equalsIgnoreCase("from")){
				
					System.out.println(qryStmtArray[i+1]);					
				}
			}	
			for(int i=1;i<qryStmtArray.length;i++) {
				if(qryStmtArray[i].equals("from")||qryStmtArray[i].equals("FROM")||qryStmtArray[i].equals("From")) {
					break;
				}
				System.out.println(qryStmtArray[i]);
			}	
//			int selectfrom=qryStmt3.indexOf( "from" );
//			System.out.println(selectfrom);
//			System.out.println(qryStmt3.substring(qryStmt3.length()-4));
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
}// end of class QueryDemo5
