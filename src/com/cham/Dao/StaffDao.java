package com.cham.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cham.DBConnect.DBConnect;
import com.cham.bean.Staff;

public class StaffDao {
	public static Staff getStaff(int userId) {
		
		Connection conn = DBConnect.getConnecttion();
//		System.out.print("cham");
		String sql ="SELECT * FROM Staff WHERE UserId = '"+userId+"'";
//		System.out.print("cham123");
		PreparedStatement ps;
		Staff staff = null;
		//Staff staff = new Staff();
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			staff = new Staff(rs.getInt("UserId"),rs.getString("Name"), 
						rs.getInt("BirthYear"),rs.getString("Department"),rs.getInt("WorkDays"),
						rs.getFloat("CoefficientSalary"),rs.getString("Position"),rs.getString("Country"),
						rs.getInt("Allowance"),rs.getInt("Salary"));
			System.out.println("toi day roi");
		}} catch (SQLException e) {
			e.printStackTrace();
		}
		return staff;
		
		
	}
	public ArrayList<Staff> getListStaffs() {
		Connection conn = DBConnect.getConnecttion();
		String sql ="SELECT * FROM Staff ";
		PreparedStatement ps;
		ArrayList<Staff> listStaff = new ArrayList<>();
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Staff objStaff = new Staff(rs.getInt("UserId"),rs.getString("Name"), 
						rs.getInt("BirthYear"),rs.getString("Department"),rs.getInt("WorkDays"),
						rs.getFloat("CoefficientSalary"),rs.getString("Position"),rs.getString("Country"),
						rs.getInt("Allowance"),rs.getInt("Salary"));
				listStaff.add(objStaff);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(listStaff + "a");
		return listStaff;
	}
	public static boolean update(Staff staff) {
		Connection conn = DBConnect.getConnecttion();
		Statement statement = null;
		try {
			statement = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("staffname" + staff.getName() + staff.getUserId());
		String sql = "Update Staff SET name = '" + staff.getName() + "', Birthyear = '" + staff.getBirthDay()+
				"', Country = '" + staff.getCountry()+"', Facutly = '" + staff.getDepartmemt()+"', Degree = '" + staff.getPosition()+
				"'Lessons = '" + staff.getWorkdays()+"'Allowance = '" + staff.getAllowance()+
				"', CoefficientSalary = '" + staff.getCoefficientSalary()+"', Salary = '" + staff.getSalary()+
				"' where UserId = '" + staff.getUserId() + "'"; 
		PreparedStatement ps;
		try {
//			ps = conn.prepareCall(sql);
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
