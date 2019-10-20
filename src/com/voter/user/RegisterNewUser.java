package com.voter.user;

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
 * Servlet implementation class RegisterNewUser
 */
@WebServlet("/RegisterNewUser")
public class RegisterNewUser extends HttpServlet {
database db = new database();	

	private static final long serialVersionUID = 1L;
	int inumber;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterNewUser() {
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
		String name= request.getParameter("$newusername");
		String address= request.getParameter("Address$Textbox");
		String city= request.getParameter("City$Textbox");
		String state= request.getParameter("State$Textbox");
		String pincode= request.getParameter("Pincode$Textbox");
		String mobileno= request.getParameter("MobileNo$Textbox");
		String landlineno= request.getParameter("LandlineNo$Textbox");
		String occupation= request.getParameter("Occupation$Textbox");
		String userId= request.getParameter("Username$Textbox");
		String password= request.getParameter("Password$Textbox");
		String confirmPassword= request.getParameter("PasswordConfirm$Textbox");
		String email= request.getParameter("Email$Textbox");
		String secretQuestion = request.getParameter("DropDownList$SecretQuestion");
		String hint = request.getParameter("PasswordAnswer$Textbox");
		db.openConnection("voterdatabase");
		String sqlQuery = "Select ID from UserDetails order by ID DESC;";
		ResultSet rs= db.runSelectQuery(sqlQuery);
		
		try{ 
			String idnumber=null;
			
			while(rs.next()){
				idnumber = rs.getString("ID");
				int ii= Integer.parseInt(idnumber);
				inumber = ii + 1;
					break;
				}
			out.println("<html>");
			out.println("<head>");
			out.println("<Title>Registration Form</Title>");
			out.println("<body>");
			out.println("<center>");    
			out.println("<img src=\"C:/Users/Devil/Documents/Eclipse/VoterId/Images/vote.jpg\" width=\"1100\" height=\"200\" >");
			out.println("<table cellspacing=\"0\" cellpadding=\"4\" border=\"0\"  style=\"color:#0000FF;border-collapse:collapse;\" width=\"1260\" align=\"right\">"); 
			out.println("<tr style=\"color:White;background-color:#003399;font-weight:bold;\">"); 
			out.println("<th scope=\"col\" align=\"left\"><a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\website.html" +"\"><font color=\"white\">"+"Home"+ "</font></a></th>"); 
			out.println(" </tr>");
			out.println(" </table>");
		if(password.equals(confirmPassword)){
			
				
				
			String sqlQueryone= "insert into UserDetails values("+inumber+",'" + name +"','" +address+ "','" + city + "','" + state +"'," + pincode + "," + mobileno + "," + landlineno+ ",'" + occupation + "','" + userId + "','" + password +"','" + email + "','" + secretQuestion + "','" + hint + "');";
			int iStatus=db.runInsertQuery(sqlQueryone);
			
			if(iStatus!=0){
				
				out.println("<br><br><br><br>");
				out.println("\n Recored added successfully!!!!");
				out.println("<br><br>");
				out.println("<table border=\"1\">");
				out.println("<thead>");
				out.println("<tr><td align=\"center\" colspan=\"2\">User Registeration Detail</td></tr>");
				out.println("</thead>");
				out.println("<tr>");
				out.println("<td>ID:</td>");
				out.println("<td>" + inumber + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Name:</td>");
				out.println("<td>" + name + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Address:</td>");
				out.println("<td>" + address + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>State:</td>");
				out.println("<td>" + state + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Pincode:</td>");
				out.println("<td>" + pincode + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Mobile Number:</td>");
				out.println("<td>" + mobileno + "</td>");
				out.println("</tr>");
				out.println("<td>Landline Number:</td>");
				out.println("<td>" + landlineno + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Occupation:</td>");
				out.println("<td>" + occupation + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>User Name:</td>");
				out.println("<td>" + userId + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Password:</td>");
				out.println("<td>" + password + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Email:</td>");
				out.println("<td>" + email + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Secret Question:</td>");
				out.println("<td>" + secretQuestion + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Hint Answer:</td>");
				out.println("<td>" + hint + "</td>");
				out.println("</tr>");				
				out.println("</table>");
				out.println("\n<a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\homepage.html" +"\">" + "Login Now!!!!" + "</a>");
				

			}
			
			else{
				out.println("\nError Registering User. Contact Admin!!!!!");
				
			}
			
		}
		
		else{
			out.println("\nPassword Mismatch!!!!!");
			RequestDispatcher rd = request.getRequestDispatcher("registration.html");
            rd.include(request, response);
		}
		 
		out.println("</center>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{db.closeConnection();}	
	
	}

}
