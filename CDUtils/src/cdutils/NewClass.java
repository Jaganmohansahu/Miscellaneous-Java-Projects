package cdutils;

import java.io.File;
import java.io.FileWriter;
import javax.swing.*;

public class NewClass
{
  public static void open(String drive) {
 
try {
        File file = new File("C:\\users\\jagan\\desktop\\abc.vbs");
        file.deleteOnExit();
    try (FileWriter fw = new java.io.FileWriter(file)) {
        String vbs = "Set wmp = CreateObject(\"WMPlayer.OCX\") \n"
                + "Set cd = wmp.cdromCollection.getByDriveSpecifier(\""
                + drive + "\") \n"
                + "do\n"
                + "cd.Eject\n"
                + "wscript.sleep 5000\n"
                + "loop\n";
        fw.write(vbs);
    }
        Runtime.getRuntime().exec("wscript C:\\users\\jagan\\desktop\\abc.vbs").waitFor();
    }
    catch(Exception e){
        e.printStackTrace();
    }
  }
 
  public static void close() {
      try {
          Runtime r = Runtime.getRuntime();
      r.exec("Taskkill /IM wscript.exe /F");
          
      } catch (Exception e) {
          e.printStackTrace();
      }    
  }
 
  public static void main(String[] args) throws Exception
  {
     
    int dialogResult = JOptionPane.showConfirmDialog (null, "Would you like to open the CD drive !!","Click a Button", JOptionPane.YES_NO_CANCEL_OPTION);

if(dialogResult == JOptionPane.YES_OPTION)
{
    NewClass.open("F:\\");
}
else if(dialogResult == JOptionPane.NO_OPTION)
    {
        NewClass.close();
    }
else
    System.exit(0);
  }
}