/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdtrayopen;
/**
 *
 * @author Jagan
 */
public class CDTrayOpen 
{
    public static void main(String[] args) throws Exception
    {      
        try
        {
            while(true)
            {
                Runtime.getRuntime().exec("C:\\Users\\Jagan\\Downloads\\Compressed\\NIRCMD\\nircmd.exe cdrom open F:");
                Thread.sleep(5000);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
