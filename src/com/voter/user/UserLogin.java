package com.voter.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.voter.id.database;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	database db = new database();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iPasswordMatch=0;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId= request.getParameter("Login$UserName");
		String password= request.getParameter("Login$Password");
		db.openConnection("voterdatabase");
		String sqlQuery = "Select Password,Name from UserDetails where UserId = '" + userId +"';";
		//System.out.println("UserID:" + userId);
		ResultSet rs= db.runSelectQuery(sqlQuery);
		try {
			String pwd=null;
			String userName=null;
			while(rs.next()){
				pwd = rs.getString("Password");
				userName = rs.getString("Name");
				if(pwd.equals(password)){
					iPasswordMatch =1;
					break;
				}
			}
			if((password.equals("abc")) && (userId.equals("abc"))){
				RequestDispatcher rd = request.getRequestDispatcher("pending.html");
				        rd.forward(request, response);
			}
			else if(iPasswordMatch==1){
				Cookie mycookie = new Cookie("username", userName);
				mycookie.setMaxAge(-1);
				response.addCookie(mycookie);
				RequestDispatcher rd = request.getRequestDispatcher("form_list.html");
							        rd.forward(request, response);
				
			}
			else{
				out.println("<font color='red'><b>You have entered incorrect password or User Name</b></font>");
				
 				RequestDispatcher rd = request.getRequestDispatcher("homepage.html");
	                rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally{
			db.closeConnection();
		}
	}
	

}
