package Driver5;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Driver5_Connection3 
{
    public static void main(String[] args) throws Exception
    {
        Properties p = new Properties();
        p.load(new FileInputStream("C:\\Users\\Jagan\\Documents\\NetBeansProjects\\ADV_JAVA\\src\\Driver5\\db.properties"));
        
        Class.forName(p.getProperty("driver"));
        Connection con = DriverManager.getConnection(p.getProperty("url"), p);
        
        if(con != null)
        {
            System.out.println("Connected with ORACLE Database using Properties class!!");
            System.out.println(con);
        }
    }
}
