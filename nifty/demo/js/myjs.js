// JavaScript Document


	function sign_in() {
			alert("已点击按钮");
			let Username = $.trim($("#Username").val());
			let Password = $.trim($("#Password").val());
			
          	


		$.ajax({
			type:"POST", // 使用post方式

			// 志愿者报名
			url:"http://192.168.14.240:8888/login",
			contentType:"application/json",


			data: JSON.stringify({
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

			success: function(result){
				// 请求成功后的操作
				if (result.successValue == "1"){
					alert("登陆成功");
					location.href = "http://xjtumun2020.xjtupsa.com/homepage/index.html";
				}
				else{
					alert("用户名或密码错误");
				}
			},

			error: function(XMLHttpRequest, textStatus, errorThrown) {
				alert("插入数据失败");
				alert(textStatus);
			}
		});
	}
