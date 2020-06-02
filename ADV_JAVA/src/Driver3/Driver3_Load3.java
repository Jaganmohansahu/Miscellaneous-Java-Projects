package Driver3;

import java.sql.DriverManager;
import java.util.Enumeration;
/* To run java Driver3_Load3 -D jdbc.drivers=ids.sql.IDSDriver*/
public class Driver3_Load3 
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
