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

			// 志愿者报名
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

