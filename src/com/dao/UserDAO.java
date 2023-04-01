package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class UserDAO {

	Connection con=null; 
	int i=0;
	public int createUser(String name, String email, String phone, String password) {
		try {
			con=DbConnection.getConnection();
			Timestamp date = new Timestamp(new Date().getTime());
			PreparedStatement ps = con.prepareStatement("insert into crud_user(name,email,phone,password,user_date) values(?,?,?,?,?)");  
			
			ps.setString(1, name);  
			ps.setString(2, email);  
			ps.setString(3,phone);  
			ps.setString(4, password);
			ps.setTimestamp(5, date);
			
			i =ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;

	}
	public ResultSet validateUser(String str1,String str2) {
		ResultSet rs=null;
		con=DbConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from crud_user where email=? and password=?");
			ps.setString(1, str1);
			ps.setString(2, str2);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet validateID()
	{
		ResultSet rs=null;
		java.sql.Statement st=null;
		con=DbConnection.getConnection();
		String str="select *from crud_user";
		try {
			st= con.createStatement();
			rs=st.executeQuery(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet profile(int regno)
	{
		ResultSet rs=null;
		con=DbConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select *from crud_user where id=?");
			ps.setInt(1, regno);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public int addNote(String title, String desc,int id) {
		// TODO Auto-generated method stub
		int i=0;
		Timestamp date = new Timestamp(new Date().getTime());
		con=DbConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("insert into crud_note(title,desc1,add_date,user_id) values(?,?,?,?)");
			ps.setString(1, title);
			ps.setString(2, desc);
			ps.setTimestamp(3, date);
			ps.setInt(4, id);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public ResultSet getAllData() {
		// TODO Auto-generated method stub
		con=DbConnection.getConnection();
		ResultSet rs=null;
		try {
			PreparedStatement ps=con.prepareStatement("select id from crud_note");
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	public ResultSet getSearchData(int from) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		con=DbConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from crud_note where id=?");
			ps.setInt(1, from);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	public ResultSet getData(int id) {
		// TODO Auto-generated method stub
				ResultSet rs=null;
				con=DbConnection.getConnection();
				try {
					PreparedStatement ps=con.prepareStatement("select * from crud_note where user_id=?");
					ps.setInt(1, id);
					rs=ps.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
	}
	public int deleteNote(int regno) {
		con=DbConnection.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("delete from crud_note where id=?");
			ps.setInt(1, regno);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}

}
