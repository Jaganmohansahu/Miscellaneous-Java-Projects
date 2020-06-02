package JDBC;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GUI_DB extends JFrame implements ActionListener
{
    JTextField tf1, tf2, tf3;
    JButton b1, b2, b3;
    JLabel l1, l2, l3, l4, l5;
    Connection con = null;
    
    private void design()
    {
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        l1 = new JLabel("ROLL: ");
        l2 = new JLabel("NAME: ");
        l3 = new JLabel("CGPA: ");
        l4 = new JLabel("Student details: ");
        
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        
        b1 = new JButton("Insert");
        b2 = new JButton("Update");
        b3 = new JButton("Delete");
        
        l4.setBounds(100, 25, 200, 30);
        l1.setBounds(30, 60, 80, 30);
        l2.setBounds(30, 100, 80, 30);
        l3.setBounds(30, 140, 80, 30);
        
        tf1.setBounds(120, 60, 180, 30);
        tf2.setBounds(120, 100, 180, 30);
        tf3.setBounds(120, 140, 180, 30);
        
        b1.setBounds(30, 180, 84, 30);
        b2.setBounds(124, 180, 83, 30);
        b3.setBounds(217, 180, 84, 30);
        
        add(b1);
        add(b2);
        add(b3);
        
        add(tf1);
        add(tf2);
        add(tf3);
        
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        
        setSize(350, 300);
        setVisible(true);
        
        con = Provider.getOracleConnection();
        
        b1.addActionListener(this); //Event Register
        b2.addActionListener(this);
        b3.addActionListener(this);
        
    }
    public static void main(String[] args)
    {
        new GUI_DB().design();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Logic when Button clicked
        String text = ae.getActionCommand();
        try {
            if(text.equalsIgnoreCase("Insert"))
            {
                //Logic to isert Record
                int r = Integer.parseInt(tf1.getText());
                String n = tf2.getText();
                Double c = Double.parseDouble(tf3.getText());
                
                String sql = "insert into student (roll, name, cgpa) values(?, ?, ?)";
                PreparedStatement pst = con.prepareStatement(sql);
                
                pst.setInt(1, r);
                pst.setString(2, n);
                pst.setDouble(3, c);
                
                int ststus = pst.executeUpdate();
                if(ststus>0)
                    JOptionPane.showMessageDialog(null, "Record inserted successfully");
                else
                    JOptionPane.showMessageDialog(this, "Error in insertion");
                
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
            }
            if(text.equalsIgnoreCase("Delete"))
            {
                //Logic to Delete Record
                int r = Integer.parseInt(tf1.getText());
                String n = tf2.getText();
                Double c = Double.parseDouble(tf3.getText());
                
                String sql = "delete from student where roll=?";
                PreparedStatement pst = con.prepareStatement(sql);
                
                pst.setInt(1, r);
                
                int ststus = pst.executeUpdate();
                if(ststus>0)
                    JOptionPane.showMessageDialog(null, "Record Deleted successfully");
                else
                    JOptionPane.showMessageDialog(this, "Error in Deletion");
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");     
            }
            if(text.equalsIgnoreCase("Update"))
            {
                //Logic to isert Record
                int r = Integer.parseInt(tf1.getText());
                String n = tf2.getText();
                Double c = Double.parseDouble(tf3.getText());
                
                String sql = "update student set name=?, cgpa=? where roll=?";
                PreparedStatement pst = con.prepareStatement(sql);
                
                pst.setString(1, n);
                pst.setDouble(2, c);
                pst.setInt(3, r);
                
                int ststus = pst.executeUpdate();
                if(ststus>0)
                    JOptionPane.showMessageDialog(null, "Record Updated successfully");
                else
                    JOptionPane.showMessageDialog(this, "Error in Updation");
                
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
