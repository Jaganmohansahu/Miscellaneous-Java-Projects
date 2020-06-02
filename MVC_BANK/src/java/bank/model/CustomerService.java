package bank.model;
import bank.db.Customer;
import bank.model.CustomerDao;
public class CustomerService 
{
    public static int updateDeposit(Customer c)
    {
        int status = 0;
        double balance = CustomerDao.getBalance(c);
        
        if(balance == -1)
        {
            return -1;
        }
        else
        {
            double total = balance + c.getAmount();
            c.setAmount(total);
            
            status = CustomerDao.doUpdate(c);
            
        }
        
        return 0;
    }
}
