package JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.sql.Timestamp;

public class Date_Ex 
{
    public static void main(String[] args) throws Exception
    {
        Connection con = Provider.getMysqlConnection();
        String sql = "Insert into DTS values(?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        
        //Follow the convention while using Date and Time in MYSQL
        String d = "2018-05-18";
        String t = "05:56:12";
        String s = "2018-05-18 05:56:12";
        
        Date dd = Date.valueOf(d);  //String to Date
        Time tt = Time.valueOf(t);  //String to Time
        Timestamp ss = Timestamp.valueOf(s);    //String to TimeStamp
        
        pst.setDate(1, dd);
        pst.setTime(2, tt);
        pst.setTimestamp(3, ss);
        
        int ststus = pst.executeUpdate();
        System.out.println(ststus);
        System.out.println("Date, Time, Timestamp Inserted !!");
    }
}
