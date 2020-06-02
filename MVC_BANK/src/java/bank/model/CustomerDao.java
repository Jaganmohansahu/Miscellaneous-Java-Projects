package bank.model;
import bank.db.Customer;
import bank.db.Provider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class CustomerDao {
    
    public static double getBalance(Customer c)
    {
        double balance = 0;
        try
        {
            Connection con = Provider.getConnection();
            String sql = "select amount from customer where actno=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, c.getActno());
            ResultSet rs = pst.executeQuery();
            
            if(rs.next())
            {
                balance = rs.getDouble(1);
            }
            else
                return -1;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return balance;
    }
    
    public static int doUpdate(Customer c)
    {
        int status = 0;
        try
        {
            Connection con = Provider.getConnection();
            String sql = "update customer set amount=? where actno=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(2, c.getActno());
            pst.setDouble(1, c.getAmount());
            status = pst.executeUpdate();
        }
        catch(Exception e) {e.printStackTrace();}
        return status;
    }
}
