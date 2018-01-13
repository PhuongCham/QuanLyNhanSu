package com.cham.bean;

public class Teacher extends User {
	String name;
	int birthday;
	String facutly;


	int lessons;
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", birthday=" + birthday + ", facutly=" + facutly + ", lessons=" + lessons
				+ ", coefficientSalary=" + coefficientSalary + ", degree=" + degree + ", country=" + country
				+ ", allowance=" + allowance + ", salary=" + salary + ", userId=" + userId + "]";
	}
	float coefficientSalary;
	String degree ;
	String country;
	int allowance;
	int salary;
	int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirthday() {
		return birthday;
	}
	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	public String getFacutly() {
		return facutly;
	}
	public void setFacutly(String facutly) {
		this.facutly = facutly;
	}
	public int getLessons() {
		return lessons;
	}
	public void setLessons(int lessons) {
		this.lessons = lessons;
	}
	public float getCoefficientSalary() {
		return coefficientSalary;
	}
	public void setCoefficientSalary(float coefficientSalary) {
		this.coefficientSalary = coefficientSalary;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
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
		this.allowance = allowance;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Teacher(int userId, String name, int birthday, String facutly, int lessons, float coefficientSalary,
			String degree, String country, int allowance, int salary) {
		super();
		this.userId = userId;
		this.name = name;
		this.birthday = birthday;
		this.facutly = facutly;
		this.lessons = lessons;
		this.coefficientSalary = coefficientSalary;
		this.degree = degree;
		this.country = country;
		this.allowance = allowance;
		this.salary = salary;
	}
	
	public Teacher(int userId, String username, String password, int role, int type, String name, int birthDay, String facutly, int lessons, float coefficientSalary,
			String degree, String country, int allowance, int salary) {
		this.userId = userId;
		this.userName = username;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.facutly = facutly;
		this.lessons = lessons;
		this.coefficientSalary = coefficientSalary;
		this.degree = degree;
		this.country = country;
		this.allowance = allowance;
		this.salary = salary;
	}
	public Teacher(int userId,String name, int birthday, String country, int type,String facutly, String degree,
			int allowance,int lessons,float coefficientSalary, int salary) {
		
		this.type = type;
		this.userId = userId;
		this.name = name;
		this.birthday = birthday;
		this.facutly = facutly;
		this.lessons = lessons;
		this.coefficientSalary = coefficientSalary;
		this.degree = degree;
		this.country = country;
		this.allowance = allowance;
		this.salary = salary;
	}
	// edit teacher
	public Teacher(int userId, String username, String password, int role, int type, String name, int birthday,
					String facutly,int lessons, Float coefficientSalary, String degree, String country, int allowance,int salary) {
		this.type = type;
		this.userId = userId;
		this.userName = username;
		System.out.print("constructoronstructoonstructoonstructoonstructoonstructoonstructoonstructoonstructo" + password);
		this.password = password;
		this.role = role;
		this.name = name;
		this.birthday = birthday;
		this.facutly = facutly;
		this.lessons = lessons;
		this.coefficientSalary = coefficientSalary;
		this.degree = degree;
		this.country = country;
		this.allowance = allowance;
		this.salary = salary;
		
	}

	public Teacher( int userId, String name) {
		super();
		this.userId = userId; 
		this.name = name;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}