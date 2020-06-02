package JDBC;

import java.sql.*;

public class ResultSet_Metadata 
{
    public static void main(String[] args) throws Exception
    {
        Connection con = Provider.getOracleConnection();
        Statement st = con.createStatement();
        String sql = "select * from student";
        ResultSet rs = st.executeQuery(sql);
        
        ResultSetMetaData rsmd = rs.getMetaData();
        
        System.out.println(rsmd.getColumnCount());
        for(int i=1; i<=rsmd.getColumnCount(); i++)
        {
            System.out.println(rsmd.getColumnLabel(i) +"\t"+ rsmd.getColumnTypeName(i) +"\t"+ rsmd.getColumnClassName(i));
        }
    }
}
