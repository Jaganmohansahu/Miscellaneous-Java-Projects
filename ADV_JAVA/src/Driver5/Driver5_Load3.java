package Driver5;

import java.sql.DriverManager;
import java.util.Enumeration;

public class Driver5_Load3 
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
