<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改学生信息</title>
<link href="/assets/css/test.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form action="/update" method="post">
		<input type="hidden" name="sid" value="ok"/>
		<input type="hidden" name="stuId" value="${stuId }"/>
		学生姓名:<input name="stuName" value= "${stuName }" /><br/>
		学生性别:<input type="radio" name="stuSex" value="男" ${("男" eq stuSex)?"checked":""  } />男
				<input type="radio" name="stuSex" value="女" ${("女" eq stuSex)?"checked":""  } />女<br/>
		学生年龄:<input name="stuAge" value= "${stuAge }"/><br/>
		学生专业:<select name="stuPro">
					<option value="软件工程" ${("软件工程" eq stuPro)?"selected":""  } >软件工程</option>
					<option value="计科" ${("计科" eq stuPro)?"selected":""  } >计科</option>
				</select><br/>
				
				<input type="submit" value="修改"/>
	</form>
</body>
</html>