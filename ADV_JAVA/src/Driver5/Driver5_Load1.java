package Driver5;

import java.sql.DriverManager;
import java.util.Enumeration;

public class Driver5_Load1 
{
    public static void main(String[] args)  throws Exception
    {
        Class.forName("com.ddtek.jdbc.oracle.OracleDriver");  
        
        Enumeration e = DriverManager.getDrivers();
        while (e.hasMoreElements()) 
        {
            System.out.println(e.nextElement());           
        }
    } 
}
