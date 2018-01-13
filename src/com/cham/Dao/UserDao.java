package com.cham.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.cham.DBConnect.DBConnect;
import com.cham.bean.Staff;
import com.cham.bean.Teacher;
import com.cham.bean.User;

public class UserDao {
	
	public boolean checklogin(String name,String password) {
		Connection conn = DBConnect.getConnecttion();
		String sql ="SELECT * FROM User WHERE Username ='"+name+"' and Password = '" +password+ "'";
		PreparedStatement ps;
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				conn.close();
				return true;
			}
			
		}catch (SQLException ex) {
			Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,ex);
		}
			return false;
		
	}
	public int checkID(String name) {
		Integer vaitro=0;
		Connection conn = DBConnect.getConnecttion();
		String sql ="SELECT * FROM User WHERE Username ='"+name+"'";
		try {
			Statement stm = conn.createStatement();
			stm.execute(sql);
			ResultSet rs = stm.getResultSet();
			if(rs.next()) {
				vaitro = rs.getInt("Role");
			}
		}catch (SQLException ex) {
			Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,ex);
		}
		return vaitro;
	}
	public ArrayList<User> getListUsers() {
		System.out.println("Hau");
		Connection conn = DBConnect.getConnecttion();
		String sql = "SELECT Teacher.UserId as UserId, Teacher.Name as Name, Teacher.BirthYear as Birthday,\n" + 
				"Teacher.Country as Country,2 as Type, Teacher.Faculty AS C1, Teacher.Degree as C2, \n" + 
				"Teacher.Allowance as C3, Teacher.Lessons as C4, Teacher.CoefficientSalary  as C5, \n" + 
				"Teacher.Salary AS C6 FROM Teacher "
				+ "UNION all"
				+ " Select Staff.UserId as UserId, \n" + 
				"Staff.Name as Name, Staff.BirthYear as Birthday, Staff.Country as Country,1 as Type, \n" + 
				"Staff.Department as C1, Staff.Position AS C2, Staff.Allowance AS C3, Staff.WorkDays AS C4, \n" + 
				"Staff.CoefficientSalary AS C5,Staff.Salary AS C6 from Staff";
		PreparedStatement ps;
		System.out.println(sql);
		ArrayList<User> listUser = new ArrayList<>();
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if (rs.getInt("Type")==1) {
					Staff staff = new Staff(rs.getInt("UserId"),rs.getString("Name"),rs.getInt("Birthday"),rs.getString("Country"),rs.getInt("Type"),
							rs.getString("C1"),rs.getString("C2"),rs.getInt("C3"),rs.getInt("C4"),rs.getFloat("C5"),rs.getInt("C6"));
					listUser.add(staff);
				}else if(rs.getInt("Type")==2) {
					Teacher teacher = new Teacher(rs.getInt("UserId"),rs.getString("Name"),rs.getInt("Birthday"),rs.getString("Country"),rs.getInt("Type"),
							rs.getString("C1"),rs.getString("C2"),rs.getInt("C3"),rs.getInt("C4"),rs.getFloat("C5"),rs.getInt("C6"));
					listUser.add(teacher);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("userdao"+listUser);
		return listUser;
	}
	public User getUserByUsername(String username) {
		Connection conn = DBConnect.getConnecttion();
		String sql ="SELECT * FROM User WHERE Username = '"+username+"'";
		PreparedStatement ps;
		User objUser = new User();
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				 objUser = new User(rs.getInt("UserId"),rs.getString("Username"), rs.getString("Password"),rs.getInt("Role"), rs.getInt("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objUser;
	}
	public static boolean update(User user) {
		Connection conn = DBConnect.getConnecttion();
		Statement statement = null;
		try {
			statement = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//System.out.println("teachername" + teacher.getName() + teacher.getUserId()+teacher.getFacutly());
		String sql = "Update User SET Username = '" + user.getUserName() + "', Password = '" + user.getPassword() +"' WHERE UserId =  '"+ user.getUserId() +"'"; 
		System.out.println(sql+"sql");
		PreparedStatement ps;
		try {
			System.out.println("toi day ne chammmm");
//			ps = conn.prepareCall(sql);
			statement.executeUpdate(sql);
			System.out.println("toi day ne cham");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}