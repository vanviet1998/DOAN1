package connect;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnect {

	
 public static Connection getConnection() {
  
		Connection conn = null;
    	try
    	{
    		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	      conn = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;"
    	               + "databaseName=RAUSACH", "vanviet1998", "123");
    	}catch(Exception e)
    	{
    		e.printStackTrace();  		
    	}
    	return conn; 		

}
 }
