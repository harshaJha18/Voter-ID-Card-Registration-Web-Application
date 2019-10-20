package com.voter.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voter.id.database;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	database db =  new database();
	int inumber;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int iuseremaill=0;
			int ivoteremaill =0;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name= request.getParameter("txt_votername");
		String sur_name= request.getParameter("txt_votersurname");
		String years_age_on= request.getParameter("dd_ageyear");
		String months_age_on= request.getParameter("dd_agemonth");
		String sex = request.getParameter("dd_Sex");
		String date_of_birthday= request.getParameter("TxtDOB");
		String village= request.getParameter("txt_townbirth");
		String district= request.getParameter("dist_text");
		String state= request.getParameter("dd_birthstate");
		String relative_name= request.getParameter("txt_relationsfirstname");
		String relative_surname= request.getParameter("txt_relationssurname");
		String relative_relationship= request.getParameter("dd_relationship");
		String housenew = request.getParameter("txt_Newdoorno");
		String houseold = request.getParameter("txt_olddoorno");
		String flatname= request.getParameter("txt_bldgname");
		String area= request.getParameter("txt_street");
		String town= request.getParameter("txt_town");
		String postofficepincode= request.getParameter("txt_pincode");
		String thana= request.getParameter("txt_taluk");
		String stdcode= request.getParameter("txt_stdcode");
		String landlinenumber= request.getParameter("txt_telephone");
		String mobilenumber= request.getParameter("txt_mobileno");
		String email= request.getParameter("txt_email");
		String dateofsub =  new Date().toString();
		db.openConnection("voterdatabase");
		String sqlQuerynumber = "Select AC_No from  registrationDetails order by AC_No DESC;";
		ResultSet mn= db.runSelectQuery(sqlQuerynumber);
		try{ 
				String idnumber=null;
				
				while(mn.next()){
					idnumber = mn.getString("AC_No");
					int ii= Integer.parseInt(idnumber);
					inumber = ii + 1;
						break;
					}
			out.println("<html>");
			out.println("<head>");
			out.println("<Title>Your Form Details</Title>");
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
		
		
		    String sql = "Select * from UserDetails where Email = '" + email +"';";
		    ResultSet rsone= db.runSelectQuery(sql);
		    String useremail=null;
			while(rsone.next()){
				 useremail  = rsone.getString("Email");
				if(useremail.equals(email)){
					iuseremaill=1;
					break;
				}
			}
		   
		    if(iuseremaill==1){
		    String sqlone = "Select * from registrationDetails where Email = '" + email +"';";
		    ResultSet rstwo= db.runSelectQuery(sqlone);
		    String voteremail=null;
			while(rstwo.next()){
				 voteremail  = rstwo.getString("Email");
				if(voteremail.equals(email)){
					ivoteremaill=1;
					break;
				}
			}
			if(ivoteremaill == 0){
				String sqlQuery= "insert into registrationDetails values("+inumber+",'" + name +"','" +sur_name+ "'," + years_age_on + "," +months_age_on +",'" + sex+ "'," + date_of_birthday + ",'" + village+ "','" + district+ "','" + state + "','" + relative_name +"','" + relative_surname + "','" + relative_relationship + "','" + housenew + "','" + houseold + "','" + flatname +"','" +area+ "','" + town + "'," +postofficepincode +",'" + thana+ "'," + stdcode + "," + landlinenumber+ "," + mobilenumber+ ",'" +email+ "','" + dateofsub +"','" + "Pending" + "','" + "Pending for AERO Approval"+"');";
				int iStatus=db.runInsertQuery(sqlQuery);
				if(iStatus!=0){
				
				
				out.println("<br>");
				out.println("<br>");
				out.println("<br>");
				out.println("<br>");
				out.println("<br>");
				
				out.println("Record added successfully!!!!");
				out.println("<br>");
				out.println("<br>");
				out.println("<a href=" + "\"http:\\" + "\\localhost:8080\\VoterId\\form_list.html" +"\">" + "Go to Form List" + "</a>");
				

				
			}
			else{out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
				out.println("\nError Registering User. Contact Admin!!!!!");
				
			}
			
			}
		  
		    }
		    else{out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
				out.println("\nYou Cann't Register  different  email Id in Form !!!!!");
				
		    }
		    out.println("</center>");
			out.println("</body>");
			out.println("</head>");
			out.println("</html>");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			finally{db.closeConnection();}	
	}


		}
