package JDBC_Process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class STDB {

	public static void main(String[] args) throws SQLException {
		// 1. Class Loader
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 2.Connection Build
		String url="jdbc:mysql://localhost:3306/practise";
		String user="root";
		String password="Example@2024";
		Connection con = DriverManager.getConnection(url,user,password);
		
		// 3.create statement
		Statement stmt= con.createStatement();
		
		// 4.executed query
		String query1 ="create table Travel (TId int , TName varchar(20) , TNO varchar(20))";
//		stmt.execute(query1);
	    System.out.println("Create table SuccessFully !!!");
	    
	    String query2 = "insert into Travel (TId, TName ,TNO) values(?,?,?)";
	    PreparedStatement pstmt= con.prepareStatement(query2);
	    pstmt.setInt(1, 112);
	    pstmt.setString(2, "Shri Sai Ram");
	    pstmt.setString(3, "MH-19-EE-3760");
	    
	    pstmt.execute();
	    System.out.println("Added Data Successfully......");
	    
	    String query3 = "select * from Travel";
	    PreparedStatement pstmt3= con.prepareStatement(query3);
	    ResultSet res= pstmt3.executeQuery();
	    System.out.println("Retrive Data Successfully .....");
	    while(res.next()) {
	    	
	    	System.out.println(" "+res.getInt(1)+" "+res.getString(2)+" "+res.getString(3));
	    }
	    
	    
	    //deletion process using statement
	    String del = "delete from Travel where TId=111";
	    Statement sdel= con.createStatement();
	    int dell=sdel.executeUpdate(del);
	    if(dell > 0) {
	    	System.out.println("deleted Data successfully!!!!");
	    }else {
	    	System.out.println("Deletaion Failed.....");
	    }
	}

}
