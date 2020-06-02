package Driver4;

import java.sql.DriverManager;
import java.util.Enumeration;
/* To run java Driver3_Load3 -D jdbc.drivers=oracle.jdbc.OracleDriver*/
public class Driver4_Load3 
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
