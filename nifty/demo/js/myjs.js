// JavaScript Document


	function sign_in() {
			alert("已点击按钮");
			let user_name = $.trim($("#Username").val());
			let pass_word = $.trim($("#Password").val());




		$.ajax({
			type:"POST", // 使用post方式

			// 志愿者报名
			url:"/login",
			contentType:"application/json",


			data:JSON.stringify({
                "status": "0",
                "message": "login",
                "user_name": user_name,
                "pass_word": pass_word,

                
            }),
			

			dataType:"json",
			async:false,
			success: function(result){
				// 请求成功后的操作
				if (result.success_value == "1"){
					alert("登陆成功");
					location.href = "index.html";
				}
				else{
					alert(fail_content);
					//location.href = "pages-login.html";
				}
			},

			error: function(XMLHttpRequest, textStatus, errorThrown) {
				alert("插入数据失败,请检查数据库链接");
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



	function recent_info(){
		
		$.ajax({
			type:"POST", // 使用post方式

			url:"/UpcomingIssue",
			contentType:"application/json",
			
			data: JSON.stringify({
                "status": "0",
                "message": "upcoming_issue",
                
            }),
			
			
			dataType:"json",
			async:false,
			success: function(result){
				if (result.success_value == "1"){
				
				// 请求成功后的操作
					var dataObj = result,
					var info_data = "",
                	$.each(dataObj, function(index, item){
						var rec_info="";
						rec_info += "<td>"+item.id+"</td>";
                    	rec_info += "<td>"+item.value+"</td>";
						rec_info += "<td>"+item.info_id_path+"</td>";
  						rec_info += "<td>"+item.course+"</td>";
						rec_info += "<td>"+item.datetime+"</td>";
						rec_info += "<td>"+item.content+"</td>";
						info_data += "<tr>"+rec_info+"</tr>" ;
				});
					$("#recent-info-data").html(info_data);
	 				
	
			}
				else{
					alert(fail_content);
					//location.href = "pages-login.html";
				}
		  },

		});
		}
		

