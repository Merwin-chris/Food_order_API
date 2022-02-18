package API;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

public class Menu extends Canvas {
	 private String[] args;
	 public void paint(Graphics g) {  
		  
	        Toolkit t=Toolkit.getDefaultToolkit();  
	        Image i=t.getImage("C:\\Users\\merwi\\Documents\\HTML\\images\\biriyani.jpg");  
	        g.drawImage(i,100,100,this);  
	        
	        Image j=t.getImage("C:\\Users\\merwi\\Documents\\HTML\\images\\tandoori.jpg");  
	        g.drawImage(j,1150,100,this);
	          
	        Image k=t.getImage("C:\\Users\\merwi\\Documents\\HTML\\images\\naan.jpg");  
	        g.drawImage(k,100,550,this);
	        
	        Image l=t.getImage("C:\\Users\\merwi\\Documents\\HTML\\images\\butter_chicken.jpg");  
	        g.drawImage(l,1150,550,this);
	        
	        Image m=t.getImage("C:\\Users\\merwi\\Documents\\HTML\\images\\icecream.jpg");  
	        g.drawImage(m,650,550,this);
	        
	        Image n=t.getImage("C:\\Users\\merwi\\Documents\\HTML\\images\\milkshake.jpg");  
	        g.drawImage(n,650,100,this);
	        
	        Image o=t.getImage("C:\\Users\\merwi\\Documents\\HTML\\images\\logo.jpg");  
	        g.drawImage(o,1600,300,this);
	    }
	 
	 
	        Menu() 
	        {   
	        JFrame f=new JFrame(" Food Menu "); 
	            
	        JLabel l=new JLabel(" PLACE ORDER ");
	        l.setFont(new Font("Roboto", Font.BOLD, 40));
	        l.setBounds(700,20,400,50);
	        
	        
			final JLabel l1= new JLabel("biriyani");
			l1.setFont(new Font("Roboto", Font.BOLD, 20));
	        l1.setBounds(150,300,100,50);
	        
	        final JLabel l2= new JLabel("Tandoori");
			l2.setFont(new Font("Roboto", Font.BOLD, 20));
	        l2.setBounds(1250,300,100,50);
	        
	        final JLabel l3= new JLabel("Naan");
			l3.setFont(new Font("Roboto", Font.BOLD, 20));
	        l3.setBounds(150,750,100,50);
	        
	        final JLabel l4= new JLabel("Butter Chicken Masala");
			l4.setFont(new Font("Roboto", Font.BOLD, 20));
	        l4.setBounds(1200,750,300,50);
	        
	        final JLabel l5= new JLabel("Ice cream");
			l5.setFont(new Font("Roboto", Font.BOLD, 20));
	        l5.setBounds(750,760,200,50);
	        
	        final JLabel l6= new JLabel("Milkshake");
			l6.setFont(new Font("Roboto", Font.BOLD, 20));
	        l6.setBounds(750,300,200,50);
	        
	        String quantity[]= {"0","1","2","3","4","5","6"};
	        final JComboBox cb=new JComboBox(quantity);
	        JLabel c1=new JLabel("Quantity:  ");
	        c1.setFont(new Font("Roboto", Font.ITALIC, 15));
	        c1.setBounds(150,375,90,20);
	        cb.setBounds(220,375,90,20);
	        f.add(c1);
	        f.add(cb);
	        
	        final JComboBox cb1=new JComboBox(quantity);
	        JLabel c2=new JLabel("Quantity:  ");
	        c2.setFont(new Font("Roboto", Font.ITALIC, 15));
	        c2.setBounds(1250,375,90,20);
	        cb1.setBounds(1320,375,90,20);
	        f.add(c2);
	        f.add(cb1);
	        
	        final JComboBox cb2=new JComboBox(quantity);
	        JLabel c3=new JLabel("Quantity:  ");
	        c3.setFont(new Font("Roboto", Font.ITALIC, 15));
	        c3.setBounds(740,375,90,20);
	        cb2.setBounds(810,375,90,20);
	        f.add(c3);
	        f.add(cb2);
	        
	        final JComboBox cb3=new JComboBox(quantity);
	        JLabel c4=new JLabel("Quantity:  ");
	        c4.setFont(new Font("Roboto", Font.ITALIC, 15));
	        c4.setBounds(150,825,90,20);
	        cb3.setBounds(220,825,90,20);
	        f.add(c4);
	        f.add(cb3);
	        
	        final JComboBox cb4=new JComboBox(quantity);
	        JLabel c5=new JLabel("Quantity:  ");
	        c5.setFont(new Font("Roboto", Font.ITALIC, 15));
	        c5.setBounds(740,825,90,20);
	        cb4.setBounds(810,825,90,20);
	        f.add(c5);
	        f.add(cb4);
	        
	        final JComboBox cb5=new JComboBox(quantity);
	        JLabel c6=new JLabel("Quantity:  ");
	        c6.setFont(new Font("Roboto", Font.ITALIC, 15));
	        c6.setBounds(1250,825,90,20);
	        cb5.setBounds(1320,825,90,20);
	        f.add(c6);
	        f.add(cb5);
	        
	       JButton b=new JButton(" Order ");
	       b.setBounds(1650,600,100,30);
	       
	       b.addActionListener(new ActionListener() {
	    	 

			public void actionPerformed(ActionEvent e){
	    		   
	    		   try
	   		    {
	   		      
	   		      Class.forName("com.mysql.jdbc.Driver");
	   			  Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/prj","root","");
	   		    
	   			Statement stmt=c.createStatement();
	   		    String sql="update food_order set quantity='"+cb.getSelectedItem()+"' where food_name ='" + l1.getText()+"'";
	   		    PreparedStatement preparedStmt = c.prepareStatement(sql);
	   		    preparedStmt.executeUpdate();
	   		    
	   		    String sql1="update food_order set quantity='"+cb2.getSelectedItem()+"' where food_name ='" + l6.getText()+"'";
	   		    PreparedStatement preparedStmt1 = c.prepareStatement(sql1);
	   		    preparedStmt1.executeUpdate();
	   		    
	   		    String sql2="update food_order set quantity='"+cb1.getSelectedItem()+"' where food_name ='" + l2.getText()+"'";
	   		    PreparedStatement preparedStmt2 = c.prepareStatement(sql2);
	   		    preparedStmt2.executeUpdate();
	   		    
	   		    String sql3="update food_order set quantity='"+cb5.getSelectedItem()+"' where food_name ='" + l4.getText()+"'";
	   		    PreparedStatement preparedStmt3 = c.prepareStatement(sql3);
	   		    preparedStmt3.executeUpdate();
	   		    
	   		    String sql4="update food_order set quantity='"+cb3.getSelectedItem()+"' where food_name ='" + l3.getText()+"'";
	   		    PreparedStatement preparedStmt4 = c.prepareStatement(sql4);
	   		    preparedStmt4.executeUpdate();
	   		    
	   		    String sql5="update food_order set quantity='"+cb4.getSelectedItem()+"' where food_name ='" + l5.getText()+"'";
	   		    PreparedStatement preparedStmt5 = c.prepareStatement(sql5);
	   		    preparedStmt5.executeUpdate();
	   		    
	   		    bill.main(args);
	   		    }
	   		    catch (Exception e1)
	   		    {
	   		      System.err.println("Got an exception! ");
	   		      System.err.println(e1.getMessage());
	   		    }
	    	   }
	       });
	        
	        f.add(l);
	        f.add(l1);
	        f.add(l2);
	        f.add(l3);
	        f.add(l4);
	        f.add(l5);
	        f.add(l6);
	        f.add(b);
	        f.add(this);
	        
	        f.getContentPane().setBackground(new java.awt.Color(102,178, 255));
	        f.setSize(2000,1000);  
	        f.setVisible(true);  
	        }
	        public static void main(String[] args)
	        {
	        	new Menu();
	        	
	        
	    }  

}
