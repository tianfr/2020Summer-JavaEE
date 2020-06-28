<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:choose>
		<c:when test="${ not empty sessionScope.user }">
			欢迎您:${sessionScope.user }<a href="/logout">退出登录</a>
		</c:when>
		<c:otherwise>
			未登录，<a href="/login">点我登录</a>
		</c:otherwise>
	</c:choose>