package com.hwadee.hello.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwadee.hello.dao.StudentDao;
import com.hwadee.hello.entity.Student;

@WebServlet("/select")
public class SelectServlet extends HttpServlet {
       
	private StudentDao dao = new StudentDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Student> list = dao.findByKey(request.getParameter("key"));
		request.setAttribute("list", list);
		request.setAttribute("key", request.getParameter("key"));
		request.getRequestDispatcher("/WEB-INF/views/student/list.jsp").forward(request, response);
	}

}
