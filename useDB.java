package JDBC_Process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class useDB {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1.load driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. Connection Build
		String url ="jdbc:mysql://localhost:3306/practise";
		String userName ="root";
		String password = "Example@2024";
		Connection con = DriverManager.getConnection(url,userName,password);
		
		// 3.Create Statement / Prepare Statement
		Statement stmt = con.createStatement();
//		String query1 = "create table truck (truckId int , truckModel varchar(20) , truckName varchar(20))";
		String query2 ="insert into truck values(1012,'78mil6','Eicer')";
		String query3 ="delete from truck where truckId=111";
		
		// 4.Executed Query
//		stmt.execute(query1);
		System.out.println("Table Created Successfully !!!");
		
		stmt.execute(query2);
		System.out.println("Added Data Successfully !!!");
		
		stmt.execute(query3);
		System.out.println("Table Deleted Successfully !!!");
		
		// 5.Relase The Resourcess
		stmt.close();
		con.close();
	}

}
