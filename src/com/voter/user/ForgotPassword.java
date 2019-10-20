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
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	database db = new database();

	
    public ForgotPassword() {
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
				
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId= request.getParameter("UserId$Textbox");
		db.openConnection("voterdatabase");
		String sqlQuery = "Select * from UserDetails where UserId = '" + userId +"';";
		ResultSet rs= db.runSelectQuery(sqlQuery);
		
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<Title>Secret Question</Title>");
			out.println("<body>");
			out.println("<center>");    
			out.println("<img src=\"C:/Users/Devil/Documents/Eclipse/VoterId/Images/vote.jpg\" width=\"1260\" height=\"200\" >");
			out.println("<table cellspacing=\"0\" cellpadding=\"4\" border=\"0\"  style=\"color:#0000FF;border-collapse:collapse;\" width=\"1260\" align=\"right\">"); 
			out.println("<tr style=\"color:White;background-color:#003399;font-weight:bold;\">"); 
			out.println("<th scope=\"col\" align=\"left\"><a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\website.html" +"\"><font color=\"white\">"+"Home"+ "</font></a></th>"); 
			
			String userName=null;
			String secretQues=null;
			if(rs.next()){
				secretQues=rs.getString("Secret_Question");
				userName = rs.getString("Name");
				Cookie mycookie = new Cookie("Name", userName);
				mycookie.setMaxAge(-1);
				response.addCookie(mycookie);
				out.println("<th scope=\"col\" align=\"right\"><font color=\"white\">Welcome , " + userName  +"</font></th>"); 
				out.println(" </tr>");
				out.println(" </table>");
				out.println(" <br>");
				out.println(" <br>");
				out.println(" <br>");
				out.println("\n<br>Answer The Question");
				out.println("\nSecret Question -->>" + secretQues  );
				out.println("\n<FORM action=\"CheckHintAnswer?UserId=" + userId + "&userName=" + userName +"\" method=\"POST\">"   );
				out.println("\nAnswer:<INPUT type=\"text\" name=\"answer\" size=\"35\"><BR>"   );
				out.println("\n<INPUT type=\"submit\" name=\"Submit\" value=\"okey\">"  );
				out.println("</FORM>"   );
							}
			else{
				out.println("\nWrong Name \n</br>");
				
			}
			
			out.println("</center>");
			out.println("</body>");
			out.println("</head>");
			 out.println("</html>");
		
		} 
		
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		 
		finally{
		db.closeConnection();
		}	
	
	}

}
