package Load;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 *
 * set JDK version-1.6
 * Mysql connector.jar can be added for experiment purpose
 */
public class Driver1_Load2 
{
    public static void main(String[] args) throws SQLException
    {
        sun.jdbc.odbc.JdbcOdbcDriver d = new sun.jdbc.odbc.JdbcOdbcDriver();
        DriverManager.registerDriver(d);
//Above sentences are not necessary as it automatically loads the drivers that are available to it        

        Enumeration e = DriverManager.getDrivers();
        if(e.hasMoreElements())
        {
            System.out.println(e.nextElement());
        }
    }
}
