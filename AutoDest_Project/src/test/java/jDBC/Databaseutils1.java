package jDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class Databaseutils1 {
	@Test
	public void getExecuteUpdate() throws SQLException
	{
		Connection con=null;
	
		//Step 1:Register the database
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//Step 2:establish connection with database
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supriya","root","root");
		
		//Step 3:issue create statement 
		Statement stat = con.createStatement();
		//Step 4:Execute any query
		ResultSet result = stat.executeQuery("select * from student;");
		while(result.next())
		{
			System.out.println(result.getString(1));
		}
		con.close();
		}
}
