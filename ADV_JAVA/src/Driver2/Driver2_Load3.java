package Driver2;

import java.sql.DriverManager;
import java.util.Enumeration;
/* To run java Driver2_Load3 -D jdbc.drivers=oracle.jdbc.pool.OracleDataSource */
public class Driver2_Load3 
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
