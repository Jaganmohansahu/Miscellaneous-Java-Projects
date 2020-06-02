package Driver2;

/* set classpath=;D:\ORACLE-11g\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6.jar;     
** Remove MySQL from classpath
*/
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Enumeration;
public class Driver2_Load2 
{
    public static void main(String[] args) throws SQLException
    {
        oracle.jdbc.OracleDriver d = new oracle.jdbc.OracleDriver();
        DriverManager.registerDriver(d);

        Enumeration e = DriverManager.getDrivers();
        if(e.hasMoreElements())
        {
            System.out.println(e.nextElement());
        }
    }
}
