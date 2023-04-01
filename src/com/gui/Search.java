package com.gui;
import java.awt.*;

import java.awt.event.*;

import java.sql.*;

import java.util.Vector;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import com.dao.UserDAO;

 

public class Search extends JFrame implements ActionListener {

 

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

    String[] columnNames = {"Note Id", "Note Title", "Note Description", "Added Date"};

    int from;

 int regno;

    Search(int regno) {

 
    	this.regno=regno;

        l0 = new JLabel("Search Note");

        l0.setForeground(Color.red);

        l0.setFont(new Font("Serif", Font.BOLD, 20));

        l1 = new JLabel("Select Note Id : ");

        b1 = new JButton("submit");
        b2=new JButton("Back");
 

        l0.setBounds(100, 50, 350, 40);

        l1.setBounds(75, 110, 75, 20);

        b1.setBounds(150, 150, 150, 20);

        b1.addActionListener(this);
        b2.addActionListener(this);

 

        setTitle("Search Note");

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

        from = (Integer) c1.getSelectedItem();

//String textvalue = textbox.getText();

        int uname = 0;

        String email = "";

        String pass = "";

        String cou = "";

 

        try {

        	UserDAO ud=new UserDAO();
            ResultSet rs= ud.getSearchData(from);

            int i = 0;

            if (rs.next()) {

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

        frame1.add(scroll);

        frame1.setVisible(true);

        frame1.setSize(400, 300);
       

    }

 

    

}