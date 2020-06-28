<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加学生</title>
<link href="/assets/css/test.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form action="/add" method="post">
		<input type="hidden" name="sid" value="ok"/>
		<input type="hidden" name="stuId" value="0"/>
		学生姓名:<input name="stuName"/><br/>
		学生性别:<input type="radio" name="stuSex" value="男"/>男
				<input type="radio" name="stuSex" value="女"/>女<br/>
		学生年龄:<input name="stuAge"/><br/>
		学生专业:<select name="stuPro">
					<option value="软件工程">软件工程</option>
					<option value="计科">计科</option>
				</select><br/>
				
				<input type="submit" value="添加学生"/>
	</form>
</body>
</html>