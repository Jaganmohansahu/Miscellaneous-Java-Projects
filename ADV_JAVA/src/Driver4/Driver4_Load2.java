package Driver4;

import java.sql.DriverManager;
import java.util.Enumeration;

public class Driver4_Load2 
{
    public static void main(String[] args) throws Exception
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
