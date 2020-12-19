package com.elif.db.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoDbConnection
 */
@WebServlet("/DemoDbConnection")
public class DemoDbConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DemoDbConnection() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setup connection parameters.

		String userId = "springstudent";
		String userPass = "springstudent";

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";

		try {
			PrintWriter printWriter = response.getWriter();
			Class.forName(driver);
			Connection myConnection = DriverManager.getConnection(jdbcUrl, userId, userPass);
			printWriter.print("Connection Successfull..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
