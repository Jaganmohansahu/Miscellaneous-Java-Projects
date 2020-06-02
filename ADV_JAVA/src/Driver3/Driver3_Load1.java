package Driver3;

import java.sql.DriverManager;
import java.util.Enumeration;

public class Driver3_Load1 
{
    public static void main(String[] args)  throws Exception
    {
        Class.forName("ids.sql.IDSDriver");  
        
        Enumeration e = DriverManager.getDrivers();
        while (e.hasMoreElements()) 
        {
            System.out.println(e.nextElement());           
        }
    } 
}
