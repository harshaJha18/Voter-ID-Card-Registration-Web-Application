package com.voter.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voter.id.database;

public class CheckHintAnswer extends HttpServlet {

	/**
	 * 
	 */
	database db = new database();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String hintAnswer= req.getParameter("answer");
		String userId=req.getParameter("UserId");
		String userName=req.getParameter("userName");
		db.openConnection("voterdatabase");
		String sqlQuery = "Select * from UserDetails where UserId = '" + userId +"';";
		ResultSet rs= db.runSelectQuery(sqlQuery);
		String userAnswer=null;
		String password=null;
		try {
			
			out.println("<html>");
			out.println("<head>");
			out.println("<Title>Password Display</Title>");
			out.println("<body>");
			out.println("<center>");    
			out.println("<img src=\"C:/Users/Devil/Documents/Eclipse/VoterId/Images/vote.jpg\" width=\"1260\" height=\"200\" >");
			out.println("<table cellspacing=\"0\" cellpadding=\"4\" border=\"0\"  style=\"color:#0000FF;border-collapse:collapse;\" width=\"1260\" align=\"right\">"); 
			out.println("<tr style=\"color:White;background-color:#003399;font-weight:bold;\">"); 
			out.println("<th scope=\"col\" align=\"left\"><a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\website.html" +"\"><font color=\"white\">"+"Home"+ "</font></a></th>"); 
			out.println("<th scope=\"col\" align=\"right\"><font color=\"white\">Welcome , " + userName  +"</font></th>"); 
			out.println(" </tr>");
			out.println(" </table>");
				 if(rs.next()){
				userAnswer = rs.getString("Hint_Answer");
				password = rs.getString("Password");
				
				if(userAnswer.equals(hintAnswer)){
					 
					out.println(" <br>");
					out.println(" <br>");
					out.println(" <br>");
					out.println("\n<br>Your Password::>>   " + password);
					out.println("\n<br><a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\homepage.html" +"\">" + "Login Now!!!" + "</a>");
					
				}
				else{
					out.println("\nWrong Answer\n</br>");
					RequestDispatcher rd = req.getRequestDispatcher("ForgotPassword");
	                rd.include(req, resp);
				}
			}
			else{
				out.println("\nWrong Answer!!!");
			}
				 out.println("</center>");
					out.println("</body>");
					out.println("</head>");
					 out.println("</html>");
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{db.closeConnection();}
	}
}
