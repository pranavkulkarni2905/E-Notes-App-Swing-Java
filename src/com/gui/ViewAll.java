package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.dao.UserDAO;


public class ViewAll extends Frame implements ActionListener{


	JFrame frame1;

	JLabel l0, l1, l2;


	JButton b1,btn,b2;

	Connection con;

	ResultSet rs, rs1;

	Statement st, st1;

	PreparedStatement pst;

	int ids;

	static JTable table;

	String[] columnNames = {"Note Id", "Note Title", "Note Description", "Added Date"};

	int from;

	int regno;

	ViewAll(int regno) {


		this.regno=regno;

		frame1 = new JFrame("Database Search Result");

		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame1.setLayout(new BorderLayout());

		//TableModel tm = new TableModel();

		DefaultTableModel model = new DefaultTableModel();

		model.setColumnIdentifiers(columnNames);

		//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());

		//table = new JTable(model);

		table = new JTable();

		table.setModel(model);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		table.setFillsViewportHeight(true);

		JScrollPane scroll = new JScrollPane(table);

		scroll.setHorizontalScrollBarPolicy(

				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scroll.setVerticalScrollBarPolicy(

				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		

		//String textvalue = textbox.getText();

		int uname = 0;

		String email = "";

		String pass = "";

		String cou = "";



		try {

			UserDAO ud=new UserDAO();
			ResultSet rs= ud.getData(regno);

			int i = 0;

			while (rs.next()) {

				uname = rs.getInt("id");

				email = rs.getString("title");

				pass = rs.getString("desc1");

				cou = rs.getString("add_date");

				model.addRow(new Object[]{uname, email, pass, cou});

				i++;

			}

			if (i < 1) {

				JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

			}

			if (i == 1) {

				// System.out.println(i + " Record Found");

			} else {

				// System.out.println(i + " Records Found");

			}

		} catch (Exception ex) {

			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}

		b2=new JButton("Back");
		//model.addRow(new Object[]{b2,b2,b2,b2});
		frame1.add(scroll);

		frame1.setVisible(true);

		frame1.setSize(400, 300);
		
		//frame1.add(b2);
		
		//b2.addActionListener(this);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}



}