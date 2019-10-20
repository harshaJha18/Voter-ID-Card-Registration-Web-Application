package com.voter.id;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;



@WebServlet("/database")
public class database {
	Connection con;
	Statement stmt;
	ResultSet rs;
	public void openConnection(String dsnName){
		
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}catch(ClassNotFoundException ce){
			ce.printStackTrace();
		}
		try{
			String myDb="jdbc:odbc:" + dsnName;
			con = DriverManager.getConnection(myDb);
		}
		catch(SQLException sqe){
			sqe.printStackTrace();
		}
		
	}
	
	public void closeConnection(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet runSelectQuery(String sqlQuery){
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	
	}
	
	public int runInsertQuery(String sqlQuery){
		int iStatus=0;
		try {
			stmt = con.createStatement();
			iStatus = stmt.executeUpdate(sqlQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return iStatus;
	
	}
	
}





















