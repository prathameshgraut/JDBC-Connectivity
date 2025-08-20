package JDBC_Process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class psDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1.Load Driver Class
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2.Build Connection
		String url = "jdbc:mysql://localhost:3306/practise";
		String userName = "root";
		String password = "Example@2024";
		Connection con = DriverManager.getConnection(url, userName, password);

		//create table
		// 3.Create Statment
		Statement stmt = con.createStatement();
		String query1 = "create table Bio (ID int , Name varchar(20),City varchar(20))";
//		stmt.execute(query1);
		System.out.println("Create Table SuccessFully !!!");

		
		// 4.create prepare statment
		//insert data
		String query2 = "insert into bio (ID,Name,City) values(? , ? , ?)";
		PreparedStatement pstmt1 = con.prepareStatement(query2);
		pstmt1.setInt(1, 114);
		pstmt1.setString(2, "omkar");
		pstmt1.setString(3, "Malegaon");
		int add = pstmt1.executeUpdate();
		if (add > 0) {
			System.out.println("Added Data Successfully !!!");
		} else {
			System.out.println("Added Failed Data");
		}
		
		
		//select table
		String query3 = "select * from bio";
		PreparedStatement pstmt2= con.prepareStatement(query3);
		ResultSet res= pstmt2.executeQuery();
		while(res.next()) {
			System.out.print("  "+res.getInt(1)+" "+res.getString(2)+" "+res.getString(3));
		}
		
		
		// delete data
		String query4 ="delete from bio where Id=?";
		PreparedStatement pstmt4= con.prepareStatement(query4);
		pstmt4.setInt(1, 114);
		int res4= pstmt4.executeUpdate();
		if(res4 > 0) {
			System.out.println("\nData Deletd Successsfully!!!");
		}else {
			System.out.println("\nDeleation failed..");
		}
		
		//retrive single data
		String query5 = "select * from bio where Id=?";
		PreparedStatement pstmt5 = con.prepareStatement(query5);
		pstmt5.setInt(1, 112);
		ResultSet res5= pstmt5.executeQuery();
		while(res5.next()) {
			System.out.println("Print A Single Data");
			System.out.println(" "+res5.getInt(1)+ " "+res5.getString(2)+" "+res5.getString(3));
			
		}
		// 5.Relase Rsourcess
		con.close();
		stmt.close();
		res.close();
		res5.close();
		pstmt1.close();
		pstmt2.close();
		pstmt4.close();
		pstmt5.close();
	}

}
