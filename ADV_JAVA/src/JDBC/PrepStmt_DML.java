package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PrepStmt_DML 
{
    public static void main(String[] args) throws Exception
    {
        Connection con = Provider.getOracleConnection();
        String sql = null;
        PreparedStatement pst = con.prepareStatement(sql);
        
        sql = "insert into student(roll, name, cgpa) values(?, ?, ?)";
        pst.setInt(1, 123);
        pst.setString(2, "Debasish");
        pst.setDouble(3, 7.5);
        
        int status = pst.executeUpdate();
        System.out.println(status);
    }
}
