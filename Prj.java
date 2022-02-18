package API;

import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.*;
import java.awt.Graphics;

import javax.swing.*;

import java.awt.event.*;

public class Prj 
{  
private String[] args;

Prj()
{  
	
    JFrame f=new JFrame("Button Example");  
    
    JLabel l=new JLabel(" Welcome!!");
    l.setBounds(80,30,400,30);
    l.setFont(new Font("Roboto", Font.BOLD, 30));
    f.add(l);
     
    JLabel l1= new JLabel("UserName :");
    l1.setFont(new Font("Roboto", Font.BOLD, 15));
    l1.setBounds(50,80,100,30);
    
   final JTextField t1= new JTextField(20);
    t1.setBounds(150,80,200,30);
    l1.setLabelFor(t1);
    
    JButton b=new JButton(" Login "); 
    b.setBounds(150,180,95,30); 
    
    JLabel l2= new JLabel(" Password :");
    l2.setFont(new Font("Roboto", Font.BOLD, 15));
    l2.setBounds(50,130,100,30);
    
    final JPasswordField t2= new JPasswordField();
    t2.setBounds(150,130,200,30);
    l2.setLabelFor(t2);
    
    
    
    f.add(l1); 
    f.add(t1);
    f.add(l2);
    f.add(t2);
    f.add(b); 
    f.setSize(500,500);
    f.getContentPane().setBackground(new java.awt.Color(204, 166, 166));
    f.setLayout(null);  
    f.setVisible(true);   

    b.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	try {
	
		Class.forName("com.mysql.jdbc.Driver");
	    Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/prj","root","");
	    Statement stmt=c.createStatement();
	    String sql="Select *  from login where username='"+t1.getText()+"' and ph_number='" + t2.getText()+"'";
	    ResultSet rs=stmt.executeQuery(sql);
	   
	    if(rs.next())
	    {
	    	Menu.main(args);
	    	
	    }
	    else
	    {
	    	JOptionPane.showMessageDialog(null, "Username/Password Error", "ERROR", JOptionPane.ERROR_MESSAGE);
	    	t1.setText(null);
	    	t2.setText(null);
	    	t1.requestFocusInWindow();
	    }    
	}
	catch(Exception e1)
	{
		e1.printStackTrace();
	}
}
 
});
    
}

public static void main(String[] args)
{
	new Prj();
}
}  
	
