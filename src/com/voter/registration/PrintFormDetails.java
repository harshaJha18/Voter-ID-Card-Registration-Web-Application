package com.voter.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voter.id.database;

/**
 * Servlet implementation class PrintFormDetails
 */
@WebServlet("/PrintFormDetails")
public class PrintFormDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	database db = new database();
	
    public PrintFormDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int iHintMatch =0;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String votername= request.getParameter("Username$Textboxone");
		db.openConnection("voterdatabase");
		String sqlQuery = "Select * from registrationDetails where Name = '" + votername +"';";
		//System.out.println("UserID:" + userId);
		ResultSet rs= db.runSelectQuery(sqlQuery);
		
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<Title>Your Form Details</Title>");
			out.println("<body>");
			out.println("<center>");    
			out.println("<img src=\"C:/Users/Devil/Documents/Eclipse/VoterId/Images/vote.jpg\" width=\"1100\" height=\"200\" >");
			out.println("<table cellspacing=\"0\" cellpadding=\"4\" border=\"0\"  style=\"color:#0000FF;border-collapse:collapse;\" width=\"1260\" align=\"right\">"); 
			out.println("<tr style=\"color:White;background-color:#003399;font-weight:bold;\">"); 
			out.println("<th scope=\"col\" align=\"left\"><a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\website.html" +"\"><font color=\"white\">"+"Home"+ "</font></a></th>"); 
		//	out.println("<th scope=\"col\"><a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\form_list.html" +"\"><font color=\"white\">"+"List of Forms"+ "</font></a></th>");
			out.println("<th scope=\"col\" align=\"right\"><a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\homepage.html" +"\"><font color=\"white\">"+"Logout"+ "</font></a></th>");
			out.println(" </tr>");
			out.println(" </table>");
			String username = null;
			while(rs.next()){
				username = rs.getString("Name");
				if(username.equals(votername)){
					iHintMatch =1;
					break;
				}
			}
			
			
			if(iHintMatch==1){
				String sqlQueryone = "Select * from registrationDetails where  Name = '" + votername +"';";
				ResultSet sq= db.runSelectQuery(sqlQueryone);
				if(sq.next()){
					out.println("<br>");
					out.println("<br>");
					out.println("<br>");
					out.println("<br>");
					out.println("<table border=\"1\">");
					out.println("<thead>");
					out.println("<tr><td align=\"center\" colspan=\"2\">User Registration Detail</td></tr>");
					out.println("</thead>");
					out.println("<tr>");
					out.println("<td>AC No:</td>");
					out.println("<td>" + sq.getString("AC_No") + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>Name:</td>");
					out.println("<td>" + sq.getString("Name")  + sq.getString("Sur_Name")+  "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>Sex:</td>");
					out.println("<td>" +  sq.getString("Sex")+   "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>Date of Birth:</td>");
					out.println("<td>" + sq.getString("Date_Of_Birthday")+ "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>Village:</td>");
					out.println("<td>" +  sq.getString("Village") + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>District:</td>");
					out.println("<td>" +  sq.getString("District") + "</td>");
					out.println("</tr>");
					out.println("<td>State:</td>");
					out.println("<td>" + sq.getString("State") + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>Relative Name:</td>");
					out.println("<td>" +  sq.getString("Relative_Name") + sq.getString("Relative_Sur_Name")+ "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>Relative Relationship:</td>");
					out.println("<td>" +  sq.getString("Relative_Relationship") + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>New House:</td>");
					out.println("<td>" +  sq.getString("House_New") + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>Flat Name:</td>");
					out.println("<td>" +  sq.getString("Flat_Name") + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>Area:</td>");
					out.println("<td>" +  sq.getString("Area") + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>Town:</td>");
					out.println("<td>" +  sq.getString("Town") + "</td>");
					out.println("</tr>");		
					out.println("<tr>");
					out.println("<td>Post Office Pincode:</td>");
					out.println("<td>" + sq.getString("Post_Office_Pincode") + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>Thana:</td>");
					out.println("<td>" + sq.getString("Thana") +  "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>Landline Number:</td>");
					out.println("<td>" +  sq.getString("Landline_Number")+   "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>Mobile Number:</td>");
					out.println("<td>" + sq.getString("Mobile_Number")+ "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>Email:</td>");
					out.println("<td>" +  sq.getString("Email") + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>Date Of Submission:</td>");
					out.println("<td>" + sq.getString("Entry_Date")+ "</td>");
					out.println("</tr>");
					out.println("</table>");
					out.println("\n<a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\form_list.html" +"\">" + "Go Back To Forms List!!!" + "</a>");
				
					
				}
			}
			else{
				out.println("<br>");
				out.println("<br>");
				out.println("\nWrong Name \n</br>");
				out.println("\n<a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\usernameone.html" +"\">" + "Go Back To Fill Again!!!" + "</a>");
			
			}
			out.println("</center>");
			out.println("</body>");
			out.println("</head>");
			out.println("</html>");
			
		} 
		
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			

			db.closeConnection();
		}	}

}
