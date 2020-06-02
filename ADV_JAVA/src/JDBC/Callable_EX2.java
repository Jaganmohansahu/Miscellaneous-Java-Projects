package JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/* CREATE FUNCTION FIRST
    create or replace function fun_count
    return number
    is
    m number(2);
    begin
        Select count(roll) into m from Student;
        return m;
    end fun_count;
    /
*/
public class Callable_EX2 
{
    public static void main(String[] args) throws Exception
    {
        Connection con = Provider.getOracleConnection();
        CallableStatement cst = con.prepareCall("{?= call fun_count}");
        cst.registerOutParameter(1, Types.INTEGER);
        cst.executeQuery();
        
        System.out.println("The number of students are: " + cst.getInt(1));
    }
}
