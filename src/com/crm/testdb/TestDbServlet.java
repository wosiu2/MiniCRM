package com.crm.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setup connection
		String user="student";
		String pass="student";
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker"
				+ "?useSSL=false&serverTimezone=UTC";
		String driver="com.mysql.jdbc.Driver";
		
		//get connection
		
		try {
			PrintWriter out=response.getWriter();
			out.println("Connecting to:"+jdbcUrl);
			Class.forName(driver);
			Connection myConn=DriverManager.getConnection(jdbcUrl,user,pass);
			out.println("Succes!");
			myConn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
