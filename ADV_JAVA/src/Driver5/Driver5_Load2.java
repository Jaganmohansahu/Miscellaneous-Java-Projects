package Driver5;

import java.sql.DriverManager;
import java.util.Enumeration;

public class Driver5_Load2 
{
     public static void main(String[] args) throws Exception
    {
        com.ddtek.jdbc.oracle.OracleDriver d = new com.ddtek.jdbc.oracle.OracleDriver();
        DriverManager.registerDriver(d);

        Enumeration e = DriverManager.getDrivers();
        if(e.hasMoreElements())
        {
            System.out.println(e.nextElement());
        }
    }
}
