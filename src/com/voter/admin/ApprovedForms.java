
package com.voter.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voter.id.database;

/**
 * Servlet implementation class ApprovedForms
 */
@WebServlet("/ApprovedForms")
public class ApprovedForms extends HttpServlet {
	private static final long serialVersionUID = 1L;
    database db = new database();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovedForms() {
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
		String []pendingStatusValue= request.getParameterValues("pendingStatus");
		try{
			out.println("<html>");
			out.println("<head>");
			out.println("<Title>Status Update</Title>");
			out.println("<body>");
			out.println("<center>");    
			out.println("<img src=\"C:/Users/Devil/Documents/Eclipse/VoterId/Images/vote.jpg\" width=\"1100\" height=\"200\" >");
			out.println("<table cellspacing=\"0\" cellpadding=\"4\" border=\"0\"  style=\"color:#0000FF;border-collapse:collapse;\" width=\"1260\" align=\"right\">"); 
			out.println("<tr style=\"color:White;background-color:#003399;font-weight:bold;\">"); 
			out.println("<th scope=\"col\" align=\"left\"><a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\website.html" +"\"><font color=\"white\">"+"Home"+ "</font></a></th>"); 
			out.println("<th scope=\"col\" align=\"right\"><font color=\"white\">Welcome Admin!!!!,</font> <a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\homepage.html" +"\"><font color=\"white\">"+"  Logout"+ "</font></a></th>");
			//out.println("<th scope=\"col\" align=\"left\"><font color=\"white\"><a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\website.html" +"\">"+"Home"+ "</a></font></th>"); 
			//out.println("<th scope=\"col\" align=\"right\"><font color=\"white\">Welcome Admin!!!! <a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\homepage.html" +"\">"+"  Logout"+ "</a></font></th>");
			out.println(" </tr>");
			out.println(" </table>");
		db.openConnection("voterdatabase");
		int iCount=0;
		for(int i=0;i<pendingStatusValue.length;i++){
			String updateQuery="UPDATE registrationDetails SET Status ='" + "Approved" + "' , Remarks = '" + "Application Accepted " + "'  where AC_No =" + Integer.parseInt(pendingStatusValue[i]) + ";";
			int iStatus = db.runInsertQuery(updateQuery);
			iCount = iCount + iStatus;
		}
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		out.println("Total record updated:" + iCount );
		out.println("</center>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
	}finally{
	db.closeConnection();
	}

}
}
