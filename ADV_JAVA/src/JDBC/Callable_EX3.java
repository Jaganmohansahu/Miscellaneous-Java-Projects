package JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.Scanner;

/* FIRST CREATE FUNCTION
    create or replace function fun_compare(c number)
    return number
    is
    m number(2);
    begin
        Select count(roll) into m from Student where cgpa >= c;
        return m;
        end fun_compare;
        /
*/
public class Callable_EX3 
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        Connection con = Provider.getOracleConnection();
        CallableStatement cst = con.prepareCall("{?= call fun_compare(?)}");
        
        cst.registerOutParameter(1, Types.INTEGER);
        System.out.println("Enter the cut-off cgpa: ");
        cst.setDouble(2, sc.nextDouble());
        cst.executeQuery();
        
        System.out.println("Number of Students getting higher marks are: " + cst.getInt(1));
    }
}