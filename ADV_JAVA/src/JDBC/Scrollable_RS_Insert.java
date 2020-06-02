package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Scrollable_RS_Insert 
{
    public static void main(String[] args) throws Exception
    {
        Connection con = Provider.getOracleConnection();
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
        String sql = "select name, roll, course, cgpa from student";
        ResultSet rs = st.executeQuery(sql);
        System.out.println("FORWARD TRAVERSE...");
        while(rs.next())
        {
            System.out.println(rs.getString(1) +"\t" + rs.getInt(2) +"\t"+ rs.getString(3) +"\t"+ rs.getDouble(4));
        }
        
        rs.afterLast();
        System.out.println("BACKWARD TRAVERSE");
        while(rs.previous())
        {
            System.out.println(rs.getString(1) +"\t" + rs.getInt(2) +"\t"+ rs.getString(3) +"\t"+ rs.getDouble(4));
        }
        
        //rs.deleteRow();   //Not possible because read only
        
        System.out.println("2nd row is...");
        rs.absolute(2);
        System.out.println(rs.getString(1) +"\t" + rs.getInt(2) +"\t"+ rs.getString(3) +"\t"+ rs.getDouble(4));
        
        System.out.println(rs.getRow());
        System.out.println(rs.isFirst());
        System.out.println(rs.isLast());
        System.out.println(rs.isBeforeFirst());
        System.out.println(rs.isAfterLast());
        
        rs.first();
        System.out.println(rs.getRow());
        rs.last();
        System.out.println(rs.getRow());
        rs.afterLast();
        System.out.println(rs.getRow());
        rs.beforeFirst();
        System.out.println(rs.getRow());
    }
}
