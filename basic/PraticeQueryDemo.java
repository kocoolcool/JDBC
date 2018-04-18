package com.iii.eeit101.chris;

public class PraticeQueryDemo {

	public static void main(String[] args) {
	try {	
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connUrl="jdbc:sqlserver://localhost:1433;datavaseName=jdbc";
		
		
		
		
		}
	catch (ClassNotFoundException e){
		e.printStackTrace();
		
	}
	}

}
