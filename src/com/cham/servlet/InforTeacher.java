package com.cham.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cham.Dao.StaffDao;
import com.cham.Dao.TeacherDao;
import com.cham.Dao.UserDao;
import com.cham.bean.Teacher;
import com.cham.bean.User;

/**
 * Servlet implementation class InforTeacher
 */
//@WebServlet("/InforTeacher")
public class InforTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InforTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User userinfor = (User)session.getAttribute("userinfor");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action;
		action = request.getParameter("action");
		System.out.println(action);
		if(action == null) {
			TeacherDao teacherDao = new TeacherDao();
			request.setAttribute("listTeacher", teacherDao.getListTeachers());
			System.out.println("size: "+teacherDao.getListTeachers().size());
			RequestDispatcher rd = request.getRequestDispatcher("/currentTeacher.jsp");
			rd.forward(request, response);
		}
		else {
				switch (action) {
					case "edit":
						Teacher teacher = TeacherDao.getTeacherAndUserInforByUserId(userinfor.getUserId());
						System.out.println("teacher" + teacher);
						request.setAttribute("teacher", teacher);
						RequestDispatcher rd1 = request.getRequestDispatcher("/editTeacher.jsp");
						rd1.forward(request, response);
						break;
					case "update":
						
						Teacher teacher_update = getTeacher(request);
						
						System.out.println(teacher_update.toString()+"abc");
						boolean update_return = TeacherDao.update(teacher_update);
						System.out.println("update111" + teacher_update.getPassword());
						boolean update_return2 = UserDao.update(teacher_update);
						System.out.println(update_return);
//						if (update_return) {
							Teacher teacher1 = TeacherDao.getTeacherAndUserInforByUserId(userinfor.getUserId());
							request.setAttribute("teacher", teacher1);
							RequestDispatcher rd2 = request.getRequestDispatcher("/editTeacher.jsp");
							rd2.forward(request, response);
							
//						}
//						else {
//							
//						}
						
						break;
					case "information":
						Teacher teacher_information = TeacherDao.getTeacher(userinfor.getUserId());
						request.setAttribute("teacher", teacher_information);
//						System.out.print("aasdsad" + teacher.getBirthDay());
						request.getRequestDispatcher("/currentTeacher.jsp").forward(request, response);
						break;
					case "logout":
						Teacher teacher_logout = TeacherDao.getTeacher(userinfor.getUserId());
						request.setAttribute("teacher", teacher_logout);
//						System.out.print("aasdsad" + teacher.getBirthDay());
						request.getRequestDispatcher("/login.jsp").forward(request, response);
						break;
					case "search":
						Teacher teacher_search = TeacherDao.getTeacher(userinfor.getUserId());
						request.setAttribute("teacher", teacher_search);
//						System.out.print("aasdsad" + teacher.getBirthDay());
						request.getRequestDispatcher("/searchUser.jsp").forward(request, response);
						break;
					}
					
						
		}
	}
	
	public Teacher getTeacher(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
//		User userinfor = (User)session.getAttribute("userinfor");
		String name = (request.getParameter("name"));
		int birthday = Integer.parseInt(request.getParameter("birthday"));
		String facutly = (request.getParameter("faculty"));
		String select_degree = (request.getParameter("degree"));
		String degree = null;
		switch (select_degree){
		case "cs":
			degree = "Cử Nhân";
			break;
		case "ths":
			degree = "Thạc Sĩ";
			break;
		case "ts":
			degree = "Tiến sĩ";
			break;
		}
		int lessons = Integer.parseInt(request.getParameter("lessons"));
		float coefficientSalary = Float.parseFloat(request.getParameter("coefficientSalary"));
		String country = (request.getParameter("country"));
		int allowance = Integer.parseInt(request.getParameter("allowance"));
		int salary = Integer.parseInt(request.getParameter("salary"));
		String username = (request.getParameter("username"));
		String password = (request.getParameter("password"));
		System.out.println("PPPPPPPP" + password);
//		int userId = userinfor.getUserID();
		Teacher teacher = new Teacher(userId, username,password,0,0,name,birthday,facutly,lessons,coefficientSalary,degree,country,allowance,salary);
		return teacher;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
