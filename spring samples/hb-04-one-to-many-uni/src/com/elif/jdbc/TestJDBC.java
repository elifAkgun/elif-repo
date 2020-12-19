package com.elif.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
	
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimeZone=UTC";
		String user ="root";
		String password = "root123*";
		
		
		try {
			
			System.out.println("connecting to db");
			
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,password);
			
			System.out.println("conection successfull!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
