package com.hwadee.hello.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("我很忙，还是找StudentsServlet帮忙吧!");
		req.setAttribute("msg", "馒头");
		//resp.sendRedirect("/students");
		req.getRequestDispatcher("/students").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = req.getParameter("msg");
		if( null != msg && ! "".equals(msg) ) {
			req.setAttribute("msg", "你输入的是:" + msg);
		} else {
			req.setAttribute("msg", "你什么都没输入啊!");
		}
		req.getRequestDispatcher("/dispatcher.jsp").forward(req, resp);
	}

}
