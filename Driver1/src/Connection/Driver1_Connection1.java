package Connection;
/**
 * Set JDK version 1.6 (32-bit) 
 * Connect with MS_ACCESS Database
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class Driver1_Connection1 
{
    public static void main(String[] args) throws Exception
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        
        Connection con = DriverManager.getConnection("jdbc:odbc:lit_dsn1");
        
        if(con != null)
        {
            System.out.println("Connected with MS-ACCESS Database !!");
            System.out.println(con);
        }
    }
}
