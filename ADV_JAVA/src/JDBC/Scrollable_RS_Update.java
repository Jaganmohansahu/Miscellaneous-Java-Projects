package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Scrollable_RS_Update 
{
     public static void main(String[] args) throws Exception
    {
        Connection con = Provider.getOracleConnection();
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        String sql = "select name, roll, course, cgpa from student";
        ResultSet rs = st.executeQuery(sql);
        
        System.out.println("3rd row is...");
        rs.absolute(3);
        System.out.println(rs.getString(1) +"\t" + rs.getInt(2) +"\t"+ rs.getString(3) +"\t"+ rs.getDouble(4));
        
        rs.moveToInsertRow();

        rs.updateString(1, "Raja");
        rs.updateInt(2, 123);
        rs.updateString(3, "Java");
        rs.updateDouble(4, 9.5);
        rs.insertRow();
        System.out.println("Yes Inserted...");
       
        rs.absolute(2);
        rs.updateString(1, "Rani");
        rs.updateDouble(4, 8.8);
        rs.updateRow();
        System.out.println("Yes Updated...");
        
        rs.absolute(3);
        rs.deleteRow();
        System.out.println("Yes Deleted...");
        rs.deleteRow();
    }
}
