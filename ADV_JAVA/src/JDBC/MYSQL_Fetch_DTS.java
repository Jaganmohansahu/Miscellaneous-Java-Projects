/*JDBC Program to fetch date from MYSQL Database*/
package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MYSQL_Fetch_DTS 
{
    public static void main(String[] args) throws Exception
    {
        Connection con = Provider.getMysqlConnection();
        
        String sql = "select * from dts";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next())
        {
            System.out.println(rs.getDate(1) +"\t"+ rs.getTime(2) + "\t" + rs.getTimestamp(3));
        }
        System.out.println("Record Fetched!!");
    }
}
