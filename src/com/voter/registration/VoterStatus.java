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
 * Servlet implementation class VoterStatus
 */
@WebServlet("/VoterStatus")
public class VoterStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	database db =  new database();
    public VoterStatus() {
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
		String votername= request.getParameter("Username$Textboxtwo");
		db.openConnection("voterdatabase");
		String sqlQuery = "Select Name from registrationDetails where Name = '" + votername +"';";
		//System.out.println("UserID:" + userId);
		ResultSet rs= db.runSelectQuery(sqlQuery);
		
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<Title>Your Status</Title>");
			out.println("<body>");
			out.println("<center>");    
			out.println("<img src=\"C:/Users/Devil/Documents/Eclipse/VoterId/Images/vote.jpg\" width=\"1100\" height=\"200\" >");
			out.println("<table cellspacing=\"0\" cellpadding=\"4\" border=\"0\"  style=\"color:#0000FF;border-collapse:collapse;\" width=\"1260\" align=\"right\">"); 
			out.println("<tr style=\"color:White;background-color:#003399;font-weight:bold;\">"); 
			out.println("<th scope=\"col\" align=\"left\"><a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\website.html" +"\"><font color=\"white\">"+"Home"+ "</font></a></th>"); 
			out.println("<th scope=\"col\"><a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\form_list.html" +"\"><font color=\"white\">"+"List of Forms"+ "</font></a></th>");
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
					out.println("<caption><span id=\"ctl00_ContentPlaceHolder1_LabelPageHeading\" class=\"normaltxt\" style=\"font-size:Medium;font-weight:bold;\">Form6 Status</span></caption>");
                    out.println("<tr>");
                    out.println("<td>");
                    out.println("<table border=\"1\" visible=\"false\" align=\"center\" width=\"30%\">");
					out.println("<tr>");
					out.println("<td style=\"font-size:medium; color: Blue\">FORM TYPE</td>");
					out.println("<td style=\"font-size:medium; font-weight: bold; color: Blue\"> Form 6</td>");
					out.println("</tr>");
					out.println("</table>");
					out.println("</td>");
					out.println("</tr>");
					out.println("<tr>");
                    out.println("<td>");
                    out.println("<div>");
					out.println("<table cellspacing=\"0\" cellpadding=\"4\" border=\"0\" id=\"ctl00_ContentPlaceHolder1_GridViewHistoryForm6\" style=\"color:#333333;border-collapse:collapse;\">");
					out.println("<tr style=\"color:White;background-color:#990000;font-weight:bold;\">");
					out.println("<th scope=\"col\">&nbsp;</th>");
					out.println("<th scope=\"col\">AC NO</th>");
					out.println("<th scope=\"col\">Name</th>");
					out.println("<th scope=\"col\">Relation Type</th>");
					out.println("<th scope=\"col\">Relation Name</th>");
					out.println("<th scope=\"col\">House No</th>");
					out.println("<th scope=\"col\">Sex</th>");
					out.println("<th scope=\"col\">Date Of Birth</th>");
					out.println("<th scope=\"col\">Entry Date</th>");
					out.println("<th scope=\"col\">Status</th>");
					out.println("<th scope=\"col\">Remarks</th>");
					 out.println("</tr>");
					out.println("<tr style=\"color:#333333;background-color:#FFFBD6;\">");
					out.println("<td><a href=\"javascript:__doPostBack('ctl00$ContentPlaceHolder1$GridViewHistoryForm6','Selecstyle=\"color:#333333;\"></a>");
					out.println("<td>"+  sq.getString("AC_No") +"</td>");
					out.println("<td>"+  sq.getString("Name") +  " "+ sq.getString("Sur_Name") +"</td>");
					out.println("<td>"+  sq.getString("Relative_Relationship") +"</td>");
					out.println("<td>"+  sq.getString("Relative_Name") + " "+sq.getString("Relative_Sur_Name") +"</td>");
					out.println("<td>"+  sq.getString("House_New") +"</td>");
					out.println("<td>"+  sq.getString("Sex") +"</td>");
					out.println("<td>"+  sq.getString("Date_Of_Birthday") +"</td>");
					out.println("<td>"+  sq.getString("Entry_Date") +"</td>");
					out.println("<td>"+  sq.getString("Status") +"</td>");
					out.println("<td>"+  sq.getString("Remarks") +"</td>");
					out.println("</td>");
					out.println("</tr>");
					out.println("</table>");
					out.println("</div>");
					out.println("</td>");
					 out.println("</tr>");
					 out.println("</table>");
					
					
				}
			}
			else{
				out.println("<br>");
				out.println("<br>");
				out.println("<br>");
				out.println("<br>");
				out.println("\n<a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\usernametwo.html" +"\">" + "Go Back To Fill Again!!!" + "</a>");
				
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
		}
	}

	

}
