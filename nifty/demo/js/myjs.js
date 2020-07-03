// JavaScript Document


	function sign_in() {
			alert("已点击按钮");
			let Username = $.trim($("#Username").val());
			let Password = $.trim($("#Password").val());




		$.ajax({
			type:"POST", // 使用post方式

			// 志愿者报名
			url:"/login",
			contentType:"application/json",


			data:JSON.stringify({
				"status": "0",
				"message": "volunteerSend",
					"content": [
						{
							"id": "UserName",
							"value":Username
						},
						{
							"id": "Password",
							"value":Password
						},

					]

			}),


			dataType:"json",
			async:false,
			success: function(result){
				// 请求成功后的操作
				if (result.successvalue == "1"){
					alert("登陆成功");
					location.href = "index.html";
				}
				else{
					alert("用户名或密码错误");
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
				if (result.successvalue == "1"){
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
	
	$(document).ready(function(){ 
		$("a.list-group-item").click(function(e){
			e.preventDefault();
			var _this = $(this);
			var selector = _this.attr("href");
			var _siblings = _this.siblings(".selected");
			var id = _siblings.attr("href");

			_siblings.removeClass("selected");
			$( id ).removeClass("testing");

			_this.addClass("selected");
			$(selector).addClass("testing");

		});
	});

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

