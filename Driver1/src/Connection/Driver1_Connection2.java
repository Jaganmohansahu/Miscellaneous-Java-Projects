package Connection;
/**
 * Set JDK version 1.6 (64-bit) 
 * Connect with ORACLE Database
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class Driver1_Connection2 
{
    public static void main(String[] args) throws Exception
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        
        Connection con = DriverManager.getConnection("jdbc:odbc:lit_dsn2", "system", "system");
        
        if(con != null)
        {
            System.out.println("Connected with ORACLE Database !!");
            System.out.println(con);
        }
    }
}