package com.hwadee.hello.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwadee.hello.dao.StudentDao;
import com.hwadee.hello.entity.Student;

public class StudentsServlet extends HttpServlet {

	private StudentDao studentDao = new StudentDao();
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("初始方法被执行了");
		config.getInitParameter("test");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> list = studentDao.findAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/student/list.jsp").forward(req, resp);
	}
	
	

}
