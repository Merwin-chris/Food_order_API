package API;

import java.awt.Font;

import java.sql.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class bill {
	
	 List<String> food_name= new ArrayList<String>();
     List<Integer> price= new ArrayList<Integer>();
     List<String> quantity= new ArrayList<String>();
     List<Integer> amount= new ArrayList<Integer>();
     
	bill()
	{
		  
	        try
	        {
			Class.forName("com.mysql.jdbc.Driver");
		    Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/prj","root","");
		    Statement stmt=c.createStatement();
		    String sql="Select *  from food_order ";
		    ResultSet rs=stmt.executeQuery(sql);
		    while(rs.next())
		    {	
		    	
		    	int id = rs.getInt("Price");
		    	String str1 =  rs.getString("quantity");
		    	String str=rs.getString("food_name");
		    	int total=0;
		    	
		    	 switch(str1)
		    	 {
		    	 case "0": break;
		    	 case "1": {total= id* 1;
		    			 break;}
		    	 case "2": {total= id* 2;
		    			 break;}
		    	 case "3": {total= id* 3;
		    			 break;}
		    	 case "4": {total= id* 4;
		    	 			break;}
		    	 case "5": {total= id* 5;
		    	 			break;}
		    	 case "6":{ total= id* 6;
		    	 			break;}
		    	 }
		    	
		    System.out.println(str + id+" * " +str1+ "="+ total);
		    food_name.add(str);
		    price.add(id);
		    quantity.add(str1);
		    amount.add(total);
		    
           
		    }
		         
	        }
	        
	        
	        catch (Exception e1) {   
	        	System.err.println("Got an exception! ");
	   		      System.err.println(e1.getMessage());
	        		}
	        
           
	      
	
		 JFrame f=new JFrame(" Order details "); 
		 
	        JLabel l=new JLabel(" Bill Payment ");
	        l.setFont(new Font("Roboto", Font.BOLD, 40));
	        l.setBounds(300,200,400,50);
	        f.add(l);
	        
	        DefaultTableModel tm = new DefaultTableModel();
	        JTable jt = new JTable(tm);
	        jt.setBounds(100, 500, 300, 400);
	        tm.addColumn("Food Name");
	        tm.addColumn("Price");
	        tm.addColumn("Quantity");
	        tm.addColumn("Total");
	        for(int i=0;i<6;i++)
	        {
	        	tm.insertRow(0, new Object[] { food_name.get(i) ,price.get(i),quantity.get(i),amount.get(i)});
	        
	        }
	        
	     f.add(new JScrollPane(jt));
	     
	     f.getContentPane().setBackground(new java.awt.Color(160, 160, 160));
	     f.setSize(1000,1000);
         f.setVisible(true);
     }
	
	public static void main(String[] args) 
	{
		new bill();
		
	}

}
/*
 * 
 */
