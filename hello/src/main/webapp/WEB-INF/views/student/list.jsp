<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生列表</title>
</head>
<body>
	<form action="/select" method="post">
		<input type="hidden" name="sid" value="ok"/>

		按姓名关键字查询:<input name="key" value="${key }" />

				<input type="submit" value="查询"/>
	</form>
	<table>
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>专业</th>
			<th>编辑</th>
			<th><a href="/add">添加</a></th>
		</tr>
		<c:choose>
			<c:when test="${not empty requestScope.list }">
			
			<c:forEach items="${list }" var="stu">
					<tr>
						<td><c:out value="${stu.stuId }"/></td>
						<td><c:out value="${stu.stuName }" /></td>
						<td><c:out value="${stu.stuSex }" /></td>
						<td><c:out value="${stu.stuAge }" /></td>
						<td><c:out value="${stu.stuPro }" /></td>
						
						<td>
							<a href="/delete?id=${stu.stuId }">删除</a>
							<a href="/update?id=${stu.stuId }">修改</a>
						</td>
					</tr>
			</c:forEach>

			</c:when>
			
			<c:otherwise>
				
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>