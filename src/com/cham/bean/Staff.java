package com.cham.bean;

public class Staff extends User {
	String name;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	int birthDay;
	String departmemt;
	int workdays;
	float coefficientSalary;
	String position ;
	String country;
	int allowance;
	int salary;
	int userId;
	
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	list user
	public Staff(int userId,String name, int birthday, String country,int type, String department, String position,
			int allowance,int workdays,float coefficientSalary, int salary) {
		super();
		this.type = type;
		this.userId = userId;
		this.name = name;
		this.birthDay = birthDay;
		this.departmemt = departmemt;
		this.workdays = workdays;
		this.coefficientSalary = coefficientSalary;
		this.position = position;
		this.country = country;
		this.allowance = allowance;
		this.salary = salary;
	}
	public Staff(int id, String name, int birthDay, String departmemt, int workdays, float coefficientSalary,
			String position, String country, int allowance, int salary) {
		super();
		this.userId = id;
		this.name = name;
		this.birthDay = birthDay;
		this.departmemt = departmemt;
		this.workdays = workdays;
		this.coefficientSalary = coefficientSalary;
		this.position = position;
		this.country = country;
		this.allowance = allowance;
		this.salary = salary;
	}
	public Staff(int userId, String name) {
		
		// TODO Auto-generated constructor stub
		super();
		this.userId = userId; 
		this.name = name;
	}
	public int getSalary() {
		return (int)(this.coefficientSalary*730+this.allowance+this.workdays*30);
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getAllowance() {
		return allowance;
	}
	public void setAllowance(int allowance) {
		if(position.equals("Trưởng Phòng")) {
		      this.allowance = 1000;
		    }else if(position.equals("Phó Phòng")) {
		      this.allowance = 600;
		    }else if(position.equals("Nhân Viên")) {
		      this.allowance = 400;
		    }else if(position.equals("Admin")) {
			      this.allowance = 1000;
			    }
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}
	public String getDepartmemt() {
		return departmemt;
	}
	public void setDepartmemt(String departmemt) {
		this.departmemt = departmemt;
	}
	public int getWorkdays() {
		return workdays;
	}
	public void setWorkdays(int workdays) {
		this.workdays = workdays;
	}
	public float getCoefficientSalary() {
		return coefficientSalary;
	}
	public void setCoefficientSalary(float coefficientSalary) {
		this.coefficientSalary = coefficientSalary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}
