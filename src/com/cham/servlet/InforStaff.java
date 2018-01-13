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
import com.cham.bean.Staff;
import com.cham.bean.Teacher;
import com.cham.bean.User;

/**
 * Servlet implementation class Infor
 */
//@WebServlet("/InforStaff")
public class InforStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InforStaff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

//		staffDao.getListStaffs();
//		request.setAttribute("listStaff", staffDao.getListStaffs());
//		System.out.println("size: "+staffDao.getListStaffs().size());
//		RequestDispatcher rd = request.getRequestDispatcher("/listStaff.jsp");
//		rd.forward(request, response);
		
		
		
		HttpSession session = request.getSession();
		User userinfor = (User)session.getAttribute("userinfor");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action;
		action = request.getParameter("action");
		System.out.println(action);
		if(action == null) {
			StaffDao staffDao = new StaffDao();
			request.setAttribute("listStaff", staffDao.getListStaffs());
			System.out.println("size: "+staffDao.getListStaffs().size());
			RequestDispatcher rd = request.getRequestDispatcher("/currentStaff.jsp");
			rd.forward(request, response);
		}
		else {
				switch (action) {
					case "edit":
						Staff staff = StaffDao.getStaff(userinfor.getUserId());
						request.setAttribute("staff", staff);
						RequestDispatcher rd1 = request.getRequestDispatcher("/editStaff.jsp");
						rd1.forward(request, response);
						break;
					case "update":
						Staff staff_update = getStaff(request);
						boolean update_return = StaffDao.update(staff_update);
						System.out.println(update_return);
						if (update_return) {
							Staff staff1 = StaffDao.getStaff(userinfor.getUserId());
							request.setAttribute("staff", staff1);
							RequestDispatcher rd2 = request.getRequestDispatcher("/editStaff.jsp");
							rd2.forward(request, response);
							
						}
						else {
							
						}
						break;
					case "information":
						Staff staff_information = StaffDao.getStaff(userinfor.getUserId());
						request.setAttribute("staff", staff_information);
						request.getRequestDispatcher("/currentStaff.jsp").forward(request, response);
						break;
					case "logout":
						Staff staff_logout = StaffDao.getStaff(userinfor.getUserId());
						request.setAttribute("staff", staff_logout);
						request.getRequestDispatcher("/login.jsp").forward(request, response);
						break;
					case "search":
						Staff staff_search = StaffDao.getStaff(userinfor.getUserId());
						request.setAttribute("staff", staff_search);
//						System.out.print("aasdsad" + teacher.getBirthDay());
						request.getRequestDispatcher("/searchUser.jsp").forward(request, response);
						break;
					}
					
						
		}
	}

	private Staff getStaff(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User userinfor = (User)session.getAttribute("userinfor");
		String name;
		name = (request.getParameter("name"));
		int userId = userinfor.getUserId();
		Staff staff = new Staff(userId, name);
		
		return staff;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
