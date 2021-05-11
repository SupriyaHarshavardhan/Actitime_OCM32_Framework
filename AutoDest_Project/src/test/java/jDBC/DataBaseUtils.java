package jDBC;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import org.testng.annotations.Test;

	import com.mysql.cj.jdbc.Driver;

	public class DataBaseUtils
	{
		@Test
		public void getExecuteUpdate() throws SQLException
		{
			Connection con=null;
			try
			{
			//Step 1:Register the database
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			//Step 2:establish connection with database
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supriya","root","root");
			
			//Step 3:issue create statement 
			Statement stat = con.createStatement();
			//Step 4:Execute any query
			int result = stat.executeUpdate("insert student values('Carl','26');");
			if(result==1)
			{
				System.out.println("customer table is successfully created");
			}
			else
			{
				System.out.println("Query failed");
			}
			}
			catch(Exception e)
			{
			}
			finally {
				
			//Step 5:close database connection
			con.close();
			}
		}
	
		 }

	

