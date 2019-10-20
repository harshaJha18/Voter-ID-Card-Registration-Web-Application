package com.voter.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voter.id.database;

/**
 * Servlet implementation class CheckUserDetails
 */
@WebServlet("/CheckUserDetails")
public class CheckUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    database db = new database();
    public CheckUserDetails() {
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
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String formstatus= request.getParameter("status$dropbox");
		db.openConnection("voterdatabase");
		String sqlQuery = "Select * from registrationDetails where Status = '" + formstatus+"';";
		ResultSet rs= db.runSelectQuery(sqlQuery);
		try {
			String sf=null;
			String namee=null;
			String sexx =null;
			String dob=null;
			String ac=null;
			String re=null;
			
			out.println("<html>");
			out.println("<head><title>Welcome Page</title></head>");
			out.println("<BODY>");
			out.println("<FORM action=\"Details\" method=\"post\">");
			out.println("<center>");
			out.println("<img src=\"C:/Users/Devil/Documents/Eclipse/VoterId/Images/vote.jpg\" width=\"1260\" height=\"200\" >");
			out.println("<table cellspacing=\"0\" cellpadding=\"4\" border=\"0\"  style=\"color:#0000FF;border-collapse:collapse;\" width=\"1260\" align=\"right\">"); 
			out.println("<tr style=\"color:White;background-color:#003399;font-weight:bold;\">"); 
			out.println("<th scope=\"col\" align=\"left\"><a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\website.html" +"\"><font color=\"white\">"+"Home"+ "</font></a></th>"); 
			out.println("<th scope=\"col\" align=\"right\"><font color=\"white\">Welcome Admin!!!!</font> <a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\homepage.html" +"\"><font color=\"white\">"+"  Logout"+ "</font></a></th>");
			out.println(" </tr>");
			out.println(" </table>");
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			out.println("<table cellspacing=\"0\" cellpadding=\"4\" border=\"1\" id=\"ctl00_ContentPlaceHolder1_GridViewHistoryForm6\" >");
			out.println("<tr>");
			
			out.println("<th scope=\"col\">AC NO</th>");
			out.println("<th scope=\"col\">Name</th>");
			out.println("<th scope=\"col\">Sex</th>");
			out.println("<th scope=\"col\">Date Of Birth</th>");
			out.println("<th scope=\"col\">Entry Date</th>");
			out.println("<th scope=\"col\">Status</th>");
			out.println("<th scope=\"col\">Remarks</th>");
			out.println("<th scope=\"col\">Approved</th>");
			out.println("</tr>");
			
			int iPendingFlag=0;
			while(rs.next()){
				
				ac = rs.getString("AC_No");
				sf = rs.getString("Status");
				namee = rs.getString("Name");
				sexx = rs.getString("Sex");
				dob = rs.getString("Date_Of_Birthday");
				re = rs.getString("Remarks");
				
				//System.out.println("ac=" + ac + " sf=" + sf + " namee=" + namee + " sexx=" + sexx + " dob=" + dob + " re=" + re);
				
				if(sf.equals("Pending")){
				
					
					out.println("<tr>");
					out.println("<td>"+  ac+"</td>");
					out.println("<td>"+  namee +"</td>");
					out.println("<td>"+  sexx +"</td>");
					out.println("<td>"+  dob +"</td>");
					out.println("<td>"+  rs.getString("Entry_Date") +"</td>");
					out.println("<td>"+  sf +"</td>");
					out.println("<td>"+  re +"</td>");
					out.println("<td><INPUT type=\"checkbox\" name=\"pendingStatus\" value=\""+ac+"\"></td>");
					out.println("</td>");
					out.println("</tr>");
					
					iPendingFlag=1;
				}
				else 
				{
						out.println("<tr>");
						//out.println("<td><a href=\"javascript:__doPostBack('ctl00$ContentPlaceHolder1$GridViewHistoryForm6','Selecstyle=\"color:#333333;\"></a>");
						out.println("<td>"+  ac+"</td>");
						out.println("<td>"+  namee +"</td>");
						out.println("<td>"+  sexx +"</td>");
						out.println("<td>"+  dob +"</td>");
						out.println("<td>"+  rs.getString("Entry_Date") +"</td>");
						out.println("<td>"+  sf +"</td>");
						out.println("<td>"+  re +"</td>");
						out.println("<td>Approved</td>");
						out.println("</td>");
						out.println("</tr>");
			
				}
		}
				out.println("</table>");
				
			   if(iPendingFlag ==1){
					out.println("<INPUT type=\"submit\" name=\"Approved\" value=\"Approve Status\">" );
					
					
			   }
			   else{
				   out.println("\n<a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\pending.html" +"\">" + "Go to Previous Page" + "</a>");
			   }
			   	out.println("</center>");
				out.println("</FORM>");
				out.println("</BODY>");
				out.println("</html>");
			
			
							
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		db.closeConnection();
		}
	}
	
	

}
