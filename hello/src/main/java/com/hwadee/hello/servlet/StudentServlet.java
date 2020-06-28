package com.hwadee.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwadee.hello.dao.StudentDao2;
import com.hwadee.hello.entity.Student;

public class StudentServlet extends HttpServlet {

	private StudentDao2 studentDao = new StudentDao2();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>学生列表</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(" <h1>学生列表在此</h1>");
		out.println("<table>					");
		out.println("	<thead>");
		out.println("		<tr>");
		out.println("			<th>学号</th>");
		out.println("			<th>姓名</th>");
		out.println("			<th>性别</th>");
		out.println("			<th>年龄</th>");
		out.println("		</tr>");
		out.println("	</thead>");
		out.println("	<tbody>");
		Student stu = studentDao.findById(Integer.parseInt(id));
		
			out.println("		<tr>");
			out.println("			<td>");
			out.print("			");
			out.print(stu.getStuId());
			out.println("			</td>");
			out.println("			<td>");
			out.print("			");
			out.print(stu.getStuName());
			out.println("			</td>");
			out.println("			<td>");
			out.print("			");
			out.print(stu.getStuSex());
			out.println("			</td>");
			out.println("			<td>");
			out.print("			");
			out.print(stu.getStuAge());
			out.println("			</td>");
			out.println("		</tr>");

		out.println("	</tbody>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
