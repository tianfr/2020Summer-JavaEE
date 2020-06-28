package com.hwadee.hello.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwadee.hello.dao.StudentDao2;


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	private StudentDao2 dao = new StudentDao2();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("5");
		String id = req.getParameter("id");
		int rows = dao.delete(Integer.parseInt(id));
		resp.sendRedirect("/students?sid=ok");
	}

}
