package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class NonScrollable_RS 
{
    public static void main(String[] args) throws Exception
    {
        Connection con = Provider.getOracleConnection();
        Statement st = con.createStatement();
        
        String sql = "select name, roll, cgpa, course from student";
        ResultSet rs = st.executeQuery(sql);
        
        System.out.println("cgpa" +"\t"+ "roll" +"\t"+ "name" +"\t"+ "course");
        
        while(rs.next())
        {
            System.out.println(rs.getString(1) +"\t"+ rs.getInt(2) +"\t"+ rs.getDouble(3) +"\t"+ rs.getString("course"));
        }             
        System.out.println("Record displayed successfully!!");
    }
}
