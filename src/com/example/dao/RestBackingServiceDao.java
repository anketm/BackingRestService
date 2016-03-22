package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.bean.Request;
import com.example.bean.Response;

public class RestBackingServiceDao {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/my_db";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   
	   //public static void main(String[] args) {
	   public Response insertData(Request request) {
	   Connection conn = null;
	   Statement stmt = null;
	   int i = 0;
	   //PreparedStatement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      System.out.println("Inserting records into the table...");
	  
	      String sql = "INSERT INTO employees " +
	                   "VALUES ("+Integer.parseInt(request.getId())+", '"+request.getLastName()+"', '"+request.getFirstName()+"', '"+request.getAddress()+"','"+request.getCity()+"', '"+request.getMobile()+"','"+request.getMail()+"','"+request.getGender()+"','"+request.getKyc()+"')";
	      
	      //String sql = "INSERT INTO employees (PersonID, LastName, FirstName, Address, City, Mobile, Email, Gender, Kyc) VALUES /(?,?,?,?,?,?,?,?,?/)";
	      
	      stmt = conn.createStatement();
	      i = stmt.executeUpdate(sql);
	      System.out.println("Inserted records into the table...");
	      System.out.println("i : " + i);
	   }catch(SQLException se){
	      //Handle errors for JDBC
		   System.out.println(se.getMessage());
		   System.out.println(se.getErrorCode());
		   if(se.getErrorCode()==1062){
			   i = 2;
		   }
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	   Response response = new Response();
	   if(i==1){
		   response.setResponseCode("100");
		   response.setResponse("Record successfully inserted!");
	   }else if(i==2)
	   {
		   response.setResponseCode("200");
		   response.setResponse("Record already exists!");
	   }else
	   {
		   response.setResponseCode("300");
		   response.setResponse("Something bad happened!");
	   }
	return response;
	}//end main
}
