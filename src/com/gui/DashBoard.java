package com.gui;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import com.dao.UserDAO;
public class DashBoard extends JFrame implements ActionListener{

	JPanel pnl1,pnl2,pnl3,pnl4,pnl5;
	JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8 ,btn9,btn10,btn11,btn12;
	JLabel lb1,lb2,lb3;
	int regno;
	public DashBoard(int regno) {
		super("Dashboard..");
		setSize(970,800);
		setVisible(true);
		this.regno=regno;

		BorderLayout bl=new BorderLayout();
		setLayout(bl);

		GridLayout gl = new GridLayout(7,0,25,25);
		Font f=new Font("Monospace", Font.BOLD, 24);


		pnl1=new JPanel();
		pnl2=new JPanel();
		pnl3=new JPanel();
		pnl4=new JPanel();
		pnl5=new JPanel();

		pnl1.setBackground(Color.blue);
		pnl2.setBackground(Color.gray);
		pnl3.setBackground(Color.red);
		pnl4.setBackground(Color.ORANGE);
		pnl5.setBackground(Color.yellow);

		//pnl2.setLayout(gl);
		lb1=new JLabel("E-Notes GUI Application");
		lb1.setFont(new Font("Monospace", Font.BOLD, 40));
		add(pnl5,bl.CENTER);
		
		UserDAO ud=new UserDAO();
		ResultSet rs=ud.profile(regno);
		try {
			if(rs.next())
			{
				lb3=new JLabel("Welcome , "+rs.getString(3));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		pnl5.add(lb3);
		lb3.setFont(f);
		
		

		add(pnl2,bl.NORTH);
		BufferedImage image1=null;
		/*try {
			image = ImageIO.read(new File("./bank3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		ImageIcon icon = new ImageIcon("./notes1.png");
		JLabel label1 = new JLabel(icon,JLabel.LEFT);
		label1.setBounds(10, 10, 10, 10);
		pnl2.add(label1);
		pnl2.add(lb1);


		//pnl1.setFont(f);
		btn2=new JButton("Profile");
		btn2.setPreferredSize(new Dimension(250, 250));
		btn2.setFont(f);

		btn3=new JButton("Add");
		btn3.setPreferredSize(new Dimension(250, 250));
		btn3.setFont(f);

		btn4=new JButton("Delete");
		btn4.setPreferredSize(new Dimension(250, 250));
		btn4.setFont(f);

		btn5=new JButton("Update");
		btn5.setPreferredSize(new Dimension(250, 250));
		btn5.setFont(f);

		btn6= new JButton("Search");
		btn6.setPreferredSize(new Dimension(250, 250));
		btn6.setFont(f);
		
		btn9= new JButton("View All");
		btn9.setPreferredSize(new Dimension(250, 250));
		btn9.setFont(f);

		btn1=new JButton("Logout");
		btn1.setPreferredSize(new Dimension(250, 250));
		btn1.setFont(f);

		GridLayout gl1=new GridLayout(2,0,20,20);
		add(pnl1,bl.WEST);
		pnl1.setLayout(gl);
		pnl1.add(btn2);//profile
		pnl1.add(btn3);//add
		pnl1.add(btn4);//delete
		pnl1.add(btn5);//update
		pnl1.add(btn6);//search
		pnl1.add(btn9);//view all
		pnl1.add(btn1);//log out

		add(pnl3,bl.EAST);
		pnl3.setLayout(gl1);
		BufferedImage image2=null;
		BufferedImage image3=null;
		try {
			image1 = ImageIO.read(new File("./notes2.png"));
			image2=ImageIO.read(new File("./notes3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn9.addActionListener(this);
		btn1.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn2)
		{
			Profile p=new Profile(regno);
			this.dispose();

		}
		if(e.getSource()==btn3)
		{
			Add a=new Add(regno);
			this.dispose();
		}
		if(e.getSource()==btn4)
		{
			Delete d=new Delete(regno);
			this.dispose();
		}
		if(e.getSource()==btn5)
		{
			//deposit dp=new deposit(regno);
			this.dispose();
		}
		if(e.getSource()==btn6)
		{
			Search s=new Search(regno);
			this.dispose();
		}
		if(e.getSource()==btn9)
		{
			ViewAll v=new ViewAll(regno);
			this.dispose();
			new DashBoard(regno);
		}
		if(e.getSource()==btn1)
		{
		      final JLabel label = new JLabel();
		      int result = JOptionPane.showConfirmDialog(pnl5,"Sure? You want to Log out?", "Log Out", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		            if(result == JOptionPane.YES_OPTION)
		            {
		               Home h=new Home();
		               this.dispose();
		            }
		            else if (result == JOptionPane.NO_OPTION)
		            {
		               DashBoard d=new DashBoard(regno);
		               this.dispose();
		            }
		}

	}


}
