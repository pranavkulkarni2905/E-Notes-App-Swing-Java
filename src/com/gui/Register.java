package com.gui;
import javax.swing.*;

import com.dao.UserDAO;

import java.awt.*;  
import java.awt.event.*;  
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;  

public class Register extends JFrame implements ActionListener {

	JLabel lTitle,lName,lEmail,lPhone,lPass;  
	JTextField tName,tEmail,tPhone;  
	JButton btn1, btn2;  
	JPasswordField tPass;  
	public Register()  
	{  
		JFrame jf=new JFrame();
		setVisible(true);  
		setSize(700, 700);  
		setLayout(null); 

		getContentPane().setBackground(Color.GRAY);
		
		Font f=new Font("Monospace", Font.BOLD, 18);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		setTitle("Registration Form "); 

		lTitle = new JLabel("Registration Here");
		lTitle.setForeground(Color.blue);  
		lTitle.setFont(new Font("Serif", Font.BOLD, 30));

		lName = new JLabel("Name:");  
		lName.setFont(f);

		lEmail = new JLabel("Email-ID:");
		lEmail.setFont(f);

		lPass = new JLabel("Create Passowrd:");  
		lPass.setFont(f);


		lPhone = new JLabel("Phone No:"); 
		lPhone.setFont(f);


		tName = new JTextField();  
		tName.setFont(f);

		tEmail=new JTextField();
		tEmail.setFont(f);

		tPhone=new JTextField();
		tPhone.setFont(f);

		tPass = new JPasswordField();  
		tPass.setFont(f);


		btn1 = new JButton("Submit");  
		btn1.setBackground(Color.cyan);
		btn2 = new JButton("Reset"); 
		btn2.setFont(f);
		btn2.setBackground(Color.cyan);

		btn1.addActionListener(this);  
		btn2.addActionListener(this); 

		lTitle.setBounds(100, 30, 400, 30);

		lName.setBounds(80, 70, 200, 30);  
		lEmail.setBounds(80, 110, 200, 30);  
		lPhone.setBounds(80, 150, 200, 30);  
		lPass.setBounds(80, 190, 200, 30);  


		tName.setBounds(300, 70, 200, 30);
		tEmail.setBounds(300, 110, 200, 30);  
		tPhone.setBounds(300, 150, 200, 30);  
		tPass.setBounds(300, 190, 200, 30);  

		btn1.setBounds(170, 450, 100, 30);  
		btn2.setBounds(290, 450, 100, 30);

		add(lTitle);
		add(lName);
		add(tName);
		add(lEmail);
		add(tEmail);
		add(lPhone);
		add(tPhone);
		add(lPass);
		add(tPass);

		add(btn1);
		add(btn2);

	}
	public  boolean isValid(String mobNo)
	{

		// The given argument to compile() method
		// is regular expression. With the help of
		// regular expression we can validate mobile
		// number.
		// 1) Begins with 0 or 91
		// 2) Then contains 7 or 8 or 9.
		// 3) Then contains 9 digits
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");

		// Pattern class contains matcher() method
		// to find matching between given number
		// and regular expression
		Matcher m = p.matcher(mobNo);
		return (m.find() && m.group().equals(mobNo));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn1)  
		{  
			int x = 0;  
			//int s10=Integer.parseInt(tf8.getText());
			String name = tName.getText();  
			String email = tEmail.getText();  
			char[] pass = tPass.getPassword();  

			String password = new String(pass);  

			String phone = tPhone.getText();  


			UserDAO ud=new UserDAO();


			if (isValid(phone))  
			{  
				int i=ud.createUser(name,email,phone,password);

				if (i > 0)   
				{  
					JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");  
					Login log=new Login();
					this.dispose();
				}  
			}  
			else  
			{  
				JOptionPane.showMessageDialog(btn1, "Enter valid Mobile number");  
			}  

		}   
		else  
		{  
			tName.setText("");  
			tEmail.setText("");  
			tPhone.setText("");  
			tPass.setText("");  

		}  
	}   
}




