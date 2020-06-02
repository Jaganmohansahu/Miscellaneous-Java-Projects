/**
* Set path to JDK-1.6
* MySQLConnector.jar can be added for experiment purpose
*/
package Load;
import java.sql.DriverManager;
import java.util.Enumeration;

public class Driver1_Load1 
{
    public static void main(String[] args)  throws Exception
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
// This sentence is not necessary it automatically loads all the drivers that are available to it
        
        Enumeration e = DriverManager.getDrivers();
        while (e.hasMoreElements()) 
        {
            System.out.println(e.nextElement());           
        }
    }
}