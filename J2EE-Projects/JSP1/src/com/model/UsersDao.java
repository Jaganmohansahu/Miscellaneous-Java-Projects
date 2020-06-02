
package com.model;
import com.db.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class UsersDao 
{
	public static int addNewUser(Users u)
	{
		int status = 0;
		try
		{
			Connection con = Provider.getConnection();
			String sql = "Insert into Users values(?, ?, ?, ?, ?)";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, u.getUserid());
			pst.setString(2, u.getUsername());
			pst.setString(3, u.getPassword());
			pst.setString(4, u.getEmailid());
			pst.setString(5, u.getAge());
			status = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public static List<Users> getAllRecords()
	{
		List<Users> list = new LinkedList<Users>();
				
		try {
			Connection con = Provider.getConnection();
			String sql = "Select * from users";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				Users u = new Users();
				u.setUserid(rs.getString(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmailid(rs.getString(4));
				u.setAge(rs.getString(5));
				list.add(u);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
}
