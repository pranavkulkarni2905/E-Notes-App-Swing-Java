package com.gui;
import java.awt.*;

import java.awt.event.*;

import java.sql.*;

import java.util.Vector;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import com.dao.UserDAO;



public class Delete extends JFrame implements ActionListener {



	JFrame frame1;

	JLabel l0, l1, l2;

	JComboBox c1;

	JButton b1,btn,b2;

	Connection con;

	ResultSet rs, rs1;

	Statement st, st1;

	PreparedStatement pst;

	int ids;

	static JTable table;


	int from;

	int regno;

	Delete(int regno) {


		this.regno=regno;

		l0 = new JLabel("Delete Note");

		l0.setForeground(Color.red);

		l0.setFont(new Font("Serif", Font.BOLD, 20));

		l1 = new JLabel("Select Note Id : ");

		b1 = new JButton("Delete");
		b2=new JButton("Back");



		l0.setBounds(100, 50, 350, 40);

		l1.setBounds(75, 110, 75, 20);

		b1.setBounds(150, 150, 150, 20);

		b1.addActionListener(this);
		b2.addActionListener(this);


		setTitle("Delete Note");

		setLayout(null);

		setVisible(true);

		setSize(500, 500);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



		add(l0);

		add(l1);;

		add(b1);
		add(b2);

		try {

			UserDAO ud=new UserDAO();
			ResultSet rs=ud.getAllData();

			Vector v = new Vector();

			while (rs.next()) {

				ids = rs.getInt(1);

				v.add(ids);

			}

			c1 = new JComboBox(v);

			c1.setBounds(150, 110, 150, 20);



			add(c1);

			btn=new JButton("Back");
			btn.setBackground(getBackground().cyan);
			add(btn);
			btn.addActionListener(this);

		} catch (Exception e) {

		}

	}



	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == b1) {

			showTableData();

		}

		else if(ae.getSource()==b2) {
			DashBoard d=new DashBoard(regno);
			this.dispose();
		}




	}



	public void showTableData() {


		from = (Integer) c1.getSelectedItem();
		UserDAO ud=new UserDAO();
		int i=ud.deleteNote(from);
		if(i>0) {
			JOptionPane.showMessageDialog(btn, "Note Deleted Successfully");
			DashBoard d=new DashBoard(regno);
		}else {
			JOptionPane.showMessageDialog(btn, "Error..."); 
			DashBoard d=new DashBoard(regno);

		}



	}





}