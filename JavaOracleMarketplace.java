package net.codejava;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.List;


public class JavaOracleMarketplace {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String dbURL = "jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS_LIST =(ADDRESS =(PROTOCOL=TCP)(HOST=acadoradbprd01.dpu.depaul.edu)(PORT=1521)))"
			 		+ "(CONNECT_DATA=(SID=ACADPRD0)(GLOBAL_NAME=ACADPRD0.WORLD)(SERVER=DEDICATED)))";
			//String dbURL = "jdbc:oracle:thin:@acadoradbprd01.dpu.depaul.edu:1521:Avila-Salazar355";
			String username = "cavilasa";
			String password = "cdm2005680";
			
			
		   
		   
			
		   JPanel panel = new JPanel();
	       JFrame frame = new JFrame("BOO! Just kiddin, welcome to the Trick or Treat marketplace!");
	       frame.setSize(600, 600);
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       frame.setVisible(true);
	       
	       
	       
	       frame.add(panel);
	       
	       panel.setLayout(null);
	       
	       JLabel fname = new JLabel("Name");
	       fname.setBounds(10,20,80,25);
	       panel.add(fname);
	       
	       JTextField nameText = new JTextField ("(e.g. Matt)");
	       nameText.setBounds(70, 20, 165, 25);
	       panel.add(nameText);
	      
	       
	       JLabel candy = new JLabel("Offer");
	       candy.setBounds(10,50,80,25);
	       panel.add(candy);
	       
	       JTextField candyText = new JTextField ("(e.g. 100 $)");
	       candyText.setBounds(70, 50, 165, 25);
	       panel.add(candyText);
	       
	       
	       JLabel quantoff = new JLabel("Time/Location");
	       quantoff.setBounds(10,80,80,25);
	       panel.add(quantoff);
	       
	       JTextField quantoffText = new JTextField ("3PM, 2242 South Cuyler Drive");
	       quantoffText.setBounds(70, 80, 165, 25);
	       panel.add(quantoffText);
	      
	       String box = quantoffText.getText();
	    	   
	       JLabel text = new JLabel("For:");
	       text.setBounds(10,110,80,25);
	       panel.add(text);
	       
	       JLabel candyreq = new JLabel("Item");
	       candyreq.setBounds(10,140,80,25);
	       panel.add(candyreq);
	       
	       
	       JTextField candyreqText = new JTextField ("(e.g. Air Jordan 5 Blue: Size 9");
	       candyreqText.setBounds(70, 140, 165, 25);
	       panel.add(candyreqText);
	      
	       
	       JLabel quantreq = new JLabel("Quantity");
	       quantreq.setBounds(10,170,80,25);
	       panel.add(quantreq);
	       
	       JTextField quantreqText = new JTextField ("1");
	       quantreqText.setBounds(70, 170, 165, 25);
	       panel.add(quantreqText);  
	       
	       JButton button = new JButton("Offer Trade");
	       button.setBounds(70, 200, 165, 25);
	       panel.add(button); 
	       
	       button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String textBox1 = nameText.getText();
	    		String  textBox2 = candyText.getText();
	    		int  textBox3 = Integer.parseInt(quantoffText.getText());
	    		String  textBox4 = candyreqText.getText();
	    		int  textBox5 = Integer.parseInt(quantreqText.getText());
	    	    String insertSql = String.format("INSERT INTO BUYING VALUES ('%s', '%s', %d,'%s',%d)"
	    	    		,textBox1,textBox2,textBox3,textBox4,textBox5);
	    	    
//	    	    DefaultTableModel model = new DefaultTableModel(new String[]{"video name", "video description", "video_city"}, 0);
//                model=(DefaultTableModel) table.getModel();
//                
//                
	    	    try {
	    	    	Connection connection = DriverManager.getConnection(dbURL, username, password);
	    			Statement stmt = connection.createStatement();
	    			ResultSet values = stmt.executeQuery(insertSql);
	    			ResultSet rs = stmt.executeQuery("SELECT * FROM BUYING");
	    			while (rs.next()) {
	    		           
	    		           String name = rs.getString("NAME");
	    		           String candyname = rs.getString("CANDYNAME");	
	    		           int qOffer = rs.getInt("QUANTITYOFFER");
	    		           String rCandy = rs.getString("REQUESTCANDY");
	    		           int qRequest = rs.getInt("QUANTITYREQUEST");
	    		           
	    		           Object[][] data = {
	    						    {name,candyname,qOffer,rCandy,qRequest}
	    						};
	    					String[] columnNames = {"Name",
	    		                    "Offer",
	    		                    "Time/Location",
	    		                    "Item",
	    		                    "Quantity"};
	    					 
	    					JPanel panel2 = new JPanel();
		    				   JFrame f = new JFrame("Trade entries");
		    				   
		    				   JTable j = new JTable(new DefaultTableModel(new Object[]{"Name","Offer","Time/Location","Item","Quantity"}, qRequest));
		    				   DefaultTableModel model = (DefaultTableModel) j.getModel();
		    				   
		    				  j.setBounds(10, 20, 80, 25);
		    				  
		    			        JScrollPane sp = new JScrollPane(j);
		    			        f.add(sp);
		    			        
		    			        f.setSize(500, 200);
		    			        // Frame Visible = true
		    			        f.setVisible(true);
		    			        model.addRow(new Object[]{name,candyname,qOffer,rCandy,qRequest});
	    				  
	    		          
	    		           
	    			}
	    			
	    			
	    			
	    	    } catch (SQLException x) {
	    			System.out.println("Oops, error");
	    			x.printStackTrace();
	    		  }
	    			
	    		
			}
	       });
	      
	
	
	try {
		//GUI enter: Offer, Time/Location, UserName, Requested Item, Requested Quantity
		//
		
		//String tableName = "";
        //String column1 = "";
        //String column1Type = "int";
        //String column2 = "";
        //String column2Type = "varchar(30)";
		Connection connection = DriverManager.getConnection(dbURL, username, password);
		Statement stmt = connection.createStatement();
		
        ResultSet rs = stmt.executeQuery("SELECT * FROM BUYING");
        System.out.println("name     offer    Time/Location   qRequest");
        
        //insert values from GUI
        
        List<String> nameList = new ArrayList<String>();
        List<String> candyList = new ArrayList<String>();
        List<String> candyReqList = new ArrayList<String>();
        while (rs.next()) {
        	
           String name = rs.getString("name");
           nameList.add(name);
           String candyname = rs.getString("CANDYNAME");
           candyList.add(candyname);
           int qOffer = rs.getInt("QUANTITYOFFER");
           String rCandy = rs.getString("REQUESTCANDY");
           candyReqList.add(rCandy);
           int qRequest = rs.getInt("QUANTITYREQUEST");
             
           //System.out.println(name + "  "+ candyname + "  " + qOffer + "   " + qRequest);
          // System.out.println(Arrays.toString(myList.toArray()));      
        }
        System.out.println(Arrays.toString(nameList.toArray()));
        System.out.println(Arrays.toString(candyList.toArray()));
        System.out.println(Arrays.toString(candyReqList.toArray()));
//        for( int i=0; i<candyList.size(); i++) {
//        	if(candyList.get(i).contentEquals(candyReqList.get(i))) {
//        		System.out.println(nameList.get(i));
//        	}
//        }
        
		System.out.println("\n"+"Connected to Oracle database server");
	} catch (SQLException e) {
		System.out.println("Oops, error");
		e.printStackTrace();
	  }
	}

}
