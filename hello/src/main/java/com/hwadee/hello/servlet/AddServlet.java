package com.hwadee.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwadee.hello.dao.StudentDao2;
import com.hwadee.hello.entity.Student;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	
	private StudentDao2 dao = new StudentDao2();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String stuName = req.getParameter("stuName");
		String stuSex = req.getParameter("stuSex");
		String stuAge = req.getParameter("stuAge");
		String stuPro = req.getParameter("stuPro");
		Student student = new Student(
					stuName,
					stuSex,
					Integer.parseInt(stuAge),
					stuPro
				);
		
		long id = dao.insert(student);
		String stuId = String.valueOf(id);
		req.setAttribute("stuId", stuId);
		req.getRequestDispatcher("/addresult.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("/add.jsp");
		//req.getRequestDispatcher("/students").forward(req, resp);
	}
}
