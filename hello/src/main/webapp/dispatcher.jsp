<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${msg }
<form action="/dispatcher" method="post">
	请输入点什么:<input name="msg"/><br/>
	<input type="submit" value="提交"/>
</form>
</body>
</html>