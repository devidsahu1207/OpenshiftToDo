package com.eg.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Result
 */
@WebServlet("/Result")
public class Result extends HttpServlet implements EnvironmentVariable {

	//String host=System.getenv("DATABASE_HOST");
	//String port=System.getenv("DATABASE_PORT");
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@"+"103.117.155.56:"+port+"/orcl1";
	
	
	String usr="system";
	String pwd="root";
	PreparedStatement stmt=null;
	ResultSet rs=null;
	@SuppressWarnings("rawtypes")
	List<Todo> list=new ArrayList<>();
	
	
	
//Getting all records from database
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println(url);
		response.setContentType("text/html");
		//String show=request.getParameter("show");
		PrintWriter out=response.getWriter();
		
		try {
			Class.forName(driver);
			Connection con =DriverManager.getConnection(url,usr,pwd);
			stmt=con.prepareStatement("select * from TEST_TO_DO");
	
			rs  = stmt.executeQuery();
			while(rs.next()) {
				
				Todo todo = new Todo();
				
				todo.setSrNo(rs.getInt("Sr_no"));
				todo.setTodo(rs.getString("to_do"));
				todo.setStatus(rs.getString("Status"));
				
				list.add(todo);
				
			}
			
			
			//out.print(list);
			rs.close();
			request.setAttribute("todos", list);
			RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response) ;
		}
			
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			list.clear();
			out.close();
		}
	}


//Inserting ToDo into database
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String TODO=request.getParameter("TODO").toString();
		PrintWriter out=response.getWriter();
		
		try {
			
			
			Class.forName(driver);
			Connection con =DriverManager.getConnection(url,usr,pwd);
			if(TODO!=null) {
			stmt=con.prepareStatement("insert into TEST_TO_DO (Sr_no,TO_DO, STATUS) values (Sr_no_sequence.nextval,?, ?)");
			//stmt.setString(1,"Sr_no_sequence.nextval");
		//	stmt.setInt(1, 1);
			stmt.setString(1, TODO);
			stmt.setString(2, "In Complete");
			
			int result  = stmt.executeUpdate();
			
			
			
			String message="Inserted Successfully";
		//	response.sendRedirect("adminHome.jsp");
			
			if(result > 0){
				//request.setAttribute("message", "Success....");
				request.getSession().setAttribute("message",message);
			}
			
			else {
				request.setAttribute("messgae", "Error");
			  }
		
			}
			
	
			
		//request.getRequestDispatcher("Result").forward(request, response);
			response.sendRedirect("Result");
		}
		catch(Exception e) {
			e.printStackTrace();
			
		
			
		}
		
		
		
	}


 

	
			
			
	

}
