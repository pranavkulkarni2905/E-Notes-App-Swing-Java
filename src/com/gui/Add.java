package com.gui;
import javax.swing.*;

import com.dao.UserDAO;

import java.awt.*;  
import java.awt.event.*;  
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;  

public class Add extends JFrame implements ActionListener {

	JLabel lTitle,lDesc,lTitle2; 
	JTextField tName;  
	JButton btn1, btn2,btn;  
	  
	JTextArea tField;
	int regno;
	JPanel pnl1;
	public Add(int regno)  
	{  
		this.regno=regno;
		JFrame jf=new JFrame();
		setVisible(true);  
		setSize(600,500);  
		setLayout(null); 

		getContentPane().setBackground(Color.YELLOW);
		BorderLayout bl=new BorderLayout();
		pnl1=new JPanel();
		pnl1.setBackground(Color.GRAY);
		
		add(pnl1,bl.SOUTH);
		
		Font f=new Font("Monospace", Font.BOLD, 18);
		Font f1=new Font("Monospace", Font.BOLD, 11);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		setTitle("Add Note "); 

		lTitle = new JLabel("Add Notes");
		lTitle.setForeground(Color.blue);  
		lTitle.setFont(new Font("Serif", Font.BOLD, 30));

		lTitle2 = new JLabel("Enter Title:");  
		lTitle2.setFont(f);

		lDesc = new JLabel("Enter Description:");
		lDesc.setFont(f);



		tName = new JTextField();  
		tName.setFont(f);

		tField=new JTextArea("Enter Descripton",10,10);
		tField.setFont(f1);

		


		btn1 = new JButton("Add Note");  
		btn1.setBackground(Color.cyan);
		btn2 = new JButton("Back"); 
		btn2.setFont(f);
		btn2.setBackground(Color.cyan);


		lTitle.setBounds(100, 30, 400, 30);

		lTitle2.setBounds(80, 70, 200, 30);  
		lDesc.setBounds(80, 110, 200, 30);  
		 


		tName.setBounds(300, 70, 200, 30);
		tField.setBounds(300, 110, 200, 30);  
		 

		btn1.setBounds(170, 200, 100, 30);  
		btn2.setBounds(290, 200, 100, 30);
		
		
		btn = new JButton("Back to Dashboard");
		btn.setFont(f);
		btn.setBackground(Color.cyan);

		

		
		
		
		add(lTitle);
		add(lTitle2);
		add(tName);
		add(lDesc);
		add(tField);
		
		add(btn1);
		add(btn2);
		
		pnl1.add(btn);

		btn1.addActionListener(this);  
		btn2.addActionListener(this); 
		btn.addActionListener(this); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == btn1)  
		{  
			int x = 0;  
			//int s10=Integer.parseInt(tf8.getText());
			String title = tName.getText();  
			String desc = tField.getText();  
			 
System.out.println(title+desc);

			UserDAO ud=new UserDAO();

			int i=ud.addNote(title,desc,regno);

				if (i > 0)   
				{  
					JOptionPane.showMessageDialog(btn1, "Note Added Successfully");  
					DashBoard d=new DashBoard(regno);
					this.dispose();
				}  
		

		}   
		else if(e.getSource()==btn2)  
		{  
			DashBoard d=new DashBoard(regno);
			this.dispose(); 
			  

		}  
	}   
}




