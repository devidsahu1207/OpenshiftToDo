package com.eg.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeletTodo
 */
@WebServlet("/DeletTodo")
public class DeletTodo extends HttpServlet {
	

	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521/orclpdb";
	String usr="system";
	String pwd="root";
	PreparedStatement stmt=null;
	ResultSet rs=null;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int  id=Integer.parseInt(request.getParameter("id"));
	//	System.out.println("ID for deletion : "+ id);
		try{
			Class.forName(driver);
		
		Connection con =DriverManager.getConnection(url,usr,pwd);

		
			
			stmt=con.prepareStatement("Delete from TEST_TO_DO where Sr_no=?");
			stmt.setInt(1, id);
			//int i=stmt.executeUpdate();
	int result  = stmt.executeUpdate();
			
			
			
			String message1="Deleted";
		//	response.sendRedirect("adminHome.jsp");
			
			if(result > 0){
				//request.setAttribute("message", "Success....");
				request.getSession().setAttribute("message",message1);
			}
			
			else {
				request.setAttribute("messgae", "Error");
			  }
		
			
		
	
			response.sendRedirect("Result");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}

}
