package Driver3;

import java.sql.DriverManager;
import java.util.Enumeration;

public class Driver3_Load2 
{
    public static void main(String[] args) throws Exception
    {
        ids.sql.IDSDriver d = new ids.sql.IDSDriver();
        DriverManager.registerDriver(d);

        Enumeration e = DriverManager.getDrivers();
        if(e.hasMoreElements())
        {
            System.out.println(e.nextElement());
        }
    }
}
