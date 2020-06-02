package Load;

import java.sql.DriverManager;
import java.util.Enumeration;

/**
 *
 * Set JDK version 1.6
 * 
 * While running this program set the System property
 * java Driver1_Load3 -D jdbc.drivers=sun.jdbc.odbc.JdbcOdbcDriver
 */
public class Driver1_Load3 
{
    public static void main(String[] args)  throws Exception
    {
        Enumeration e = DriverManager.getDrivers();
        if(e.hasMoreElements())
        {
            System.out.println(e.nextElement());
        }
    }
}
