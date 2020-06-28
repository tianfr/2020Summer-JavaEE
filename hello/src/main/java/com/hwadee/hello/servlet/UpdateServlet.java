package com.hwadee.hello.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwadee.hello.dao.StudentDao2;
import com.hwadee.hello.entity.Student;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	
	private StudentDao2 dao = new StudentDao2();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String stuId = req.getParameter("stuId");
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
		student.setStuId(Integer.parseInt(stuId));
		dao.update(student);
		resp.sendRedirect("/students");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.sendRedirect("/update.jsp");
		String stuId = req.getParameter("id");
		Student student = dao.findById(Integer.parseInt(stuId));
		req.setAttribute("stuId", student.getStuId());
		req.setAttribute("stuName", student.getStuName());
		req.setAttribute("stuSex", student.getStuSex());
		req.setAttribute("stuAge", student.getStuAge());
		req.setAttribute("stuPro", student.getStuPro());
		req.getRequestDispatcher("/update.jsp").forward(req, resp);
	}
}
