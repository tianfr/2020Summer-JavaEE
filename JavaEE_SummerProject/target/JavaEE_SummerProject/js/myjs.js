// JavaScript Document


	function sign_in() {
			alert("已点击按钮");
			let user_name = $.trim($("#user_name").val());
			let pass_word = $.trim($("#pass_word").val());




		$.ajax({
			type:"POST", // 使用post方式

			// 志愿者报名
			url:"/Login",
			contentType:"application/json",


			data:JSON.stringify({
				"status": "0",
				"message": "volunteerSend",
				"user_name":user_name,
				"pass_word":pass_word,
				
								}),


			dataType:"json",
			async:false,
			success: function(result){
				// 请求成功后的操作
				if (result.success_value == "1"){
					alert("登录成功");
					location.href = "index.html";
				}
				else{
					alert(result.fail_content);
					//location.href = "pages-login.html";
				}
			},

			error: function(XMLHttpRequest, textStatus, errorThrown) {
				alert("插入数据失败,请检查数据库链接");
				//alert(textStatus);
			}
		});
	}

	function Register() {
			alert("已点击按钮");
			let full_name = $.trim($("#full_name").val());
			let email = $.trim($("#email").val());
			let user_name = $.trim($("#user_name").val());
			let pass_word = $.trim($("#pass_word").val());
	




		$.ajax({
			type:"POST", // 使用post方式
			url:"/Register",
			contentType:"application/json",
			data:JSON.stringify({
				"status": "0",
				"message": "register",
				"user_name":user_name,
				"pass_word":pass_word,
				"email":email,
				"full_name":full_name,
               
			}),
			dataType:"json",
			async:false,
			success: function(result){
				// 请求成功后的操作
				if (result.success_value == "1"){
					alert("注册成功");
					location.href = "pages-login.html";
				}
				else{ 
					alert(result.fail_content);
					//location.href = "pages-login.html";
				}
			},

			error: function(XMLHttpRequest, textStatus, errorThrown) {
				alert("插入数据失败,请检查数据库链接");
				//alert(textStatus);
			}
		});
	}

function reset_pw() {
	alert("已点击按钮");
	let email_pwreminder = $.trim($("#email_pwreminder").val());

	$.ajax({
		type:"POST", // 使用post方式

		url:"/PasswordReminder",
		contentType:"application/json",


		data: JSON.stringify({
			"status": "0",
			"message": "password_reminder",
			"email":email_pwreminder,

		}),

		dataType:"json",
		async:false,
		success: function(result){
			// 请求成功后的操作
			if (result.success_value == "1"){
				alert("已将密码发送至对应邮箱");
				location.href = "pages-login.html";
				//发邮件
			}
			else{
				alert("邮箱不存在");
			}
		},

		error: function(XMLHttpRequest, textStatus, errorThrown) {
			alert("查找失败,请检查数据库链接");
			//alert(textStatus);
		}
	});
}

	function recent_info(){

	$.ajax({
		type:"POST", // 使用post方式
		url:"/RecentInfo",
		contentType:"application/json",
		data: JSON.stringify({
			"status": "0",
			"message": "recent_info",
		}),
		dataType:"json",
		async:false,
		success: function(result){
			if (result.id == "recent_info"){
				// 请求成功后的操作
				var dataObj = result.value;
				var info_data = "";
					$.each(dataObj, function(index, item){
						var rec_info="";
						rec_info += "<td>"+item.id+"</td>";
						rec_info += "<td>"+item.course+"</td>";
						rec_info += "<td>"+item.value+"</td>";
						rec_info += "<td>"+item.datetime+"</td>";
						info_data += "<tr>"+rec_info+"</tr>" ;
					});
				$("#recent-info-data").html(info_data);
			}
			// else{
			// 	alert(result.fail_content);
			// 	//location.href = "pages-login.html";
			// }
		},

	});
}

function upcoming_issue(){
	$.ajax({
		type:"POST", // 使用post方式

		url:"/UpcomingIssue",
		contentType:"application/json",


		data: JSON.stringify({
			"status": "0",
			"message": "upcoming_issue",
		}),

		dataType:"json",
		async:false,
		success: function(result){
			var dataObj = result.value,con1="";
			$.each(dataObj,function(index,item){
				con1+= "<tr>"+
					"<td>"+item.value+"</td>" +
					"<td>"+item.course+"</td>" +
					"<td>"+item.datetime+"</td>" +
					"<td>"+item.content+"</td>" +
					"<td>"+item.status+"</td>" +
					"</tr>";
			});
			$("#con1").html(con1);
		}
	});
}