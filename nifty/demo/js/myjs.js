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
						rec_info += "<td>"+'<a href="index.html?course_id='+
						            item.info_id_path
									'"  target="_self">'+item.id+"</a></td>";
  						rec_info += "<td>"+item.course+"</td>";
						rec_info += "<td>"+item.content+"</td>";
						rec_info += "<td>"+item.datetime+"</td>";
						info_data += "<tr>"+rec_info+"</tr>" ;
				});
					$("#recent-info-data").html(info_data);
	 				
	
			}
		  },

		});
		}

						
	function get_announcement(){
		$.ajax({
			type:"POST", // 使用post方式

			url:"/GetAnnouncement",
			contentType:"application/json",
			
			data: JSON.stringify({
    		"status": "0",
    		"message": "get_announcement",
    		"course_id": course,
    		"announcement_id": announcement_path //注意：这个变量在get_course_announcement中出现过。
			}),
			
			dataType:"json",
			async:false,
			success: function(result){
				$("#headline").html(result.announcement_title);
				$("#teacher_name").html(result.author);
				$("#teacher_email").html(result.author_email);
				$("#teacher_pic").attr('src','result.author_avatar');
				$("#datetime").html(result.datetime);
				$("#annou_content").html(result.announcement_content);
			}
			
			
		});
	}


	function get_course_homeworks(){
		$.ajax({
			type:"POST", // 使用post方式

			// 志愿者报名
			url:"/GetCourseHomeworks",
			contentType:"application/json",


			data:JSON.stringify({
                "status": "0",
                "message": "get_course_homeworks", 
 				"course_id": "course_id",
            }),
			
			dataType:"json",
			async:false,
			success: function(result){
				if(result.id == "course_homeworks"){
					
					var num = result.total_num;
					var page_num = 10;//每页10条记录
					var page_size = Math.ceil(num/page_num);//页数
					var homeworkObj = result.value;
					var current_page = 1 ;
					
					document.getElementById("tab-2-demo-mail-list").innerHTML = "";
					$.each(homeworkObj, function(index, item){
						if(index<page_num){//静态显示第一页
							var li = "";
							li += ' <li class="mail-list-unread mail-attach"> '
				                    '<div class="mail-control"> '
				                    '<input id="email-list-1" class="magic-checkbox" type="checkbox"> '
				                    '<label for="email-list-1"></label> '
			                        '</div> '
				                    '<div class="mail-star"><a href="#"><i class="demo-psi-star"></i></a></div>'
				                    '<strong class="mail-from"> '
							
									'<a href="homework-meaasge.html" target="_self" id=" '
								    +item.homework_id+
								    '" onclick="get_homework(this.id)">'
							
									+item.homework_title+
									'</a><br></strong> <div class="mail-time">';
							li += item.homework_deadline
							      + "</div>\
								<div class=\"mail-attach-icon\"></div>\
				                   <div class=\"mail-subject\"> <a href=\"mailbox-message.html\">";
							li += item.homework_content
							      + "</a> </div> </li>" ;
							$("#tab-2-demo-mail-list").html(li);
							$("#tab-2-page_id").html(current_page);
							$("#tab-2-page_total").html(page_size);
						}
							
						
					});
					
				}
				
			}
		});
	}


	function homework_flip_left(){
		let current_page = $.trim($("#tab-2-page_id").val());
		
		$.ajax({
			type:"POST", // 使用post方式

			// 志愿者报名
			url:"/GetCourseHomeworks",
			contentType:"application/json",


			data:JSON.stringify({
                "status": "0",
                "message": "get_course_homeworks", 
 				"course_id": course_id,
            }),
			
			dataType:"json",
			async:false,
			success: function(result){
				if(result.id == "course_homeworks"){
					var num = result.total_num;
					var page_num = 16;//每页16条记录
					var page_size = Math.ceil(num/page_num);//页数
					var homeworkObj = result.value;
					if(current_page>1){
						current_page--;
						document.getElementById("tab-2>demo-mail-list").innerHTML = "";
						$.each(homeworkObj, function(index, item){
							if(current_page-1*page_num<=index
							   &&index<current_page*page_num){
								var li = "";
							li += ' <li class="mail-list-unread mail-attach">
				                    '<div class="mail-control">'
				                    '<input id="email-list-1" class="magic-checkbox" type="checkbox">
				                    '<label for="email-list-1"></label>
			                        '</div>
				                    '<div class="mail-star"><a href="#"><i class="demo-psi-star"></i></a></div>'
				                    '<strong class="mail-from"> '
							
									'<a href="homework-meaasge.html" target="_self" id=" '
								    +item.homework_id+
								    '" onclick="get_homework(this.id)">'
							
									+item.homework_title
									+'</a><br></strong>
				                    '<div class="mail-time">';
							li += item.homework_deadline
							      + "</div>
				                   '<div class="mail-attach-icon"></div>
				                   '<div class="mail-subject"> <a href="mailbox-message.html">";
							li += item.homework_content
							      + "</a> </div> </li>" ;
							$("#tab-2>#demo-mail-list").html(li);
							$("#tab-2>#page_id").html(current_page);
							$("#tab-2>#page_total").html(page_size);
							}
						});
						
					}
				}
			}
		});
	}


	function homework_flip_right(){
		let current_page = $.trim($("#tab-2>#page_id").val());
		
		$.ajax({
			type:"POST", // 使用post方式

			// 志愿者报名
			url:"/GetCourseHomeworks",
			contentType:"application/json",


			data:JSON.stringify({
                "status": "0",
                "message": "get_course_homeworks", 
 				"course_id": course_id,
            }),
			
			dataType:"json",
			async:false,
			success: function(result){
				if(result.id == "course_homeworks"){
					var num = result.total_num;
					var page_num = 16;//每页16条记录
					var page_size = Math.ceil(num/page_num);//页数
					var homeworkObj = result.value;
					if(current_page<=page_size){
						current_page++;
						document.getElementById("tab-2>demo-mail-list").innerHTML = "";
						$.each(homeworkObj, function(index, item){
							if(current_page-1*page_num<=index
							   &&index<current_page*page_num){
								var li = "";
							li += ' <li class="mail-list-unread mail-attach">
				                    '<div class="mail-control">'
				                    '<input id="email-list-1" class="magic-checkbox" type="checkbox">
				                    '<label for="email-list-1"></label>
			                        '</div>
				                    '<div class="mail-star"><a href="#"><i class="demo-psi-star"></i></a></div>'
				                    '<strong class="mail-from"> '
							
									'<a href="homework-meaasge.html" target="_self" id=" '
								    +item.homework_id+
								    '" onclick="get_homework(this.id)">'
							
									+item.homework_title
									+'</a><br></strong>'
				                    '<div class="mail-time">';
							li += item.homework_deadline
							      + "</div>
				                   '<div class="mail-attach-icon"></div>
				                   '<div class="mail-subject"> <a href="mailbox-message.html">";
							li += item.homework_content
							      + "</a> </div> </li>" ;
							$("#tab-2>#demo-mail-list").html(li);
							$("#tab-2>#page_id").html(current_page);
							$("#tab-2>#page_total").html(page_size);
							}
						});
						
					
				}
			}
		}
		
	});
	}
			   


    function get_homework(this.id,course_id){
			var homework_id = this.id;
			$.ajax({
				type:"POST", // 使用post方式

				url:"/GetHomework",
				contentType:"application/json",


				data:JSON.stringify({
                	"status": "0",
                	"message": "get_homework", 
 					"course_id": course_id,
					"homework_id": homework_id,
            }),
				
				dataType:"json",
				async:false,
				success: function(result){
					var attachmentObj = result.homework_attachment;
					var li = "";
					var string_ddl = result.homework_deadline+":00";//string类型
					var ddl_day = new Date(string_ddl);//ddl转化为date类型
					var today = new Date(); //当前时间
					var days_diff = (ddl_day.getTime() - today.getTime())/(1*24*60*60*1000);
					//ddl与当前日期天数差
					var alert = "";
					$("#headline").html(result.homework_title);
					$("#teacher_name").html(result.author);
					$("#teacher_email").html(result.author_email);
					$("#teacher_pic").attr('src','result.author_avatar');
					$("#datetime").html(result.datetime);
					$("#homework_content").html(result.homework_content);
					//还没有判断作业有没有提交过
					if(days_diff<0){
						alert += '<div class="alert alert-danger"> <strong>';
					}
					else if(days_diff<1){
						alert += '<div class="alert alert-warning"> <strong>';
					}
					else{
						alert += '<div class="alert alert-primary"> <strong>';
					}
					alert += result.homework_deadline+
						     '</strong> </div>';
					$("#homework_ddl").html(alert);
					
					$.each(attachmentObj, function(index, item){						
						li += '<li> <a href="#" class="thumbnail"><div class="mail-file-          img"><a href=" '
						     +item.attachment_path+
						     ' " target="_self">'
					         '<img class="image-responsive" src="img/bg-img/bg-img-4.jpg"   alt="image"></a></div><div class="caption"> '
					         '<p class="text-primary mar-no" id="attachment_name">'
							 +item.attachment_name+
							 '</p></div></a></li>'
					}); 
					$("#mail-attach-list").html(li);
			}
				
				
			});
			
		}
		
		
    function get_course_resources(course_id){
		$.ajax({
				type:"POST", // 使用post方式

				url:"/GetCourseResources",
				contentType:"application/json",


				data:JSON.stringify({
                	"status": "0",
                	"message": "get_course_resources", 
 					"course_id": course_id,
                }),
			    
				dataType:"json",
				async:false,
				success: function(result){
					if(result.id == "course_resources"){
						var num = result.total_num;
						var resourcesObj = result.value;	
						var page_num = 10;//每页10条记录
						var page_size = Math.ceil(num/page_num);//页数
						var current_page = 1 ;
						
						document.getElementById("tab-5-demo-mail-list").innerHTML = "";
						var li = "";
					    $.each(resourcesObj, function(index, item){
							
							if(index<page_num){//静态显示第一页
								li +=' <li class="mail-list-unread mail-attach">
				                    '<div class="mail-control">'
				                    '<input id="src-list-'
								    +index+
								    '" class="magic-checkbox" type="checkbox">
				                    '<label for="src-list-
									+index+
								    "></label></div>
				                    '<div class="mail-star"><a href="#"><i class="demo-psi-star"></i></a></div>'
				                    '<strong class="mail-from"> '
							
									'<a href="src-download.html" target="_self" id=" '
								    +item.resource_path+
									'" onclick="get_resources(this.id)">'
								    +item.resource_name+
									'</a><br></strong>'
				                    '<div class="mail-time">';
									li += item.resource_upload_time
									  + "</div>
									   '<div class="mail-attach-icon"></div>
									   '<div class="mail-subject"> <a href="mailbox-message.html">";
									li += item.resource_size+item.resource_type
										  + "</a> </div> </li>" ;
								
							}
						});
						
						$("#tab-5-demo-mail-list").html(li);
						$("#tab-5-page_id").html(current_page);
						$("#tab-5-page_total").html(page_size);
					}
				}
			
			
		});
	} 



	function resources_flip_left(){
		var current_page = document.getElementById("tab-5-page_id");
		
		$.ajax({
			type:"POST", // 使用post方式

			// 志愿者报名
			url:"/GetCourseResources",
			contentType:"application/json",


			data:JSON.stringify({
                "status": "0",
                "message": "get_course_resources", 
 				"course_id": course_id,
            }),
			
			dataType:"json",
			async:false,
			success: function(result){
				if(result.id == "course_resources"){
					var num = result.total_num;
					var page_num = 10;//每页16条记录
					var page_size = Math.ceil(num/page_num);//页数
					var resourcesObj = result.value;
					if(current_page>1){
						current_page--;
						document.getElementById("tab-5-demo-mail-list").innerHTML = "";
						var li = "";
						$.each(resourcesObj, function(index, item){
							if(current_page-1*page_num<=index
							   &&index<current_page*page_num){
								
							   li +=' <li class="mail-list-unread mail-attach">
				                    '<div class="mail-control">'
				                    '<input id="src-list-'
								    +index+
								    '" class="magic-checkbox" type="checkbox">
				                    '<label for="src-list-
									+index+
								    "></label></div>
				                    '<div class="mail-star"><a href="#"><i class="demo-psi-star"></i></a></div>'
				                    '<strong class="mail-from"> '
							
									'<a href="src-download.html" target="_self" id=" '
								    +item.resource_path+
									'" onclick="get_resources(this.id)">'
								    +item.resource_name+
									'</a><br></strong>'
				                    '<div class="mail-time">';
									li += item.resource_upload_time
									  + "</div>
									   '<div class="mail-attach-icon"></div>
									   '<div class="mail-subject"> <a href="mailbox-message.html">";
									li += item.resource_size+item.resource_type
										  + "</a> </div> </li>" ;
							
							}
						});
						$("#tab-5-demo-mail-list").html(li);
						$("#tab-5-page_id").html(current_page);
						$("#tab-5-page_total").html(page_size);
					}
				}
			}
		});
	}




	function resources_flip_right(){
		var current_page = document.getElementById("tab-5-page_id");
		
		$.ajax({
			type:"POST", // 使用post方式

			// 志愿者报名
			url:"/GetCourseResources",
			contentType:"application/json",


			data:JSON.stringify({
                "status": "0",
                "message": "get_course_resources", 
 				"course_id": course_id,
            }),
			
			dataType:"json",
			async:false,
			success: function(result){
				if(result.id == "course_resources"){
					var num = result.total_num;
					var page_num = 10;//每页10条记录
					var page_size = Math.ceil(num/page_num);//页数
					var resourcesObj = result.value;
					if(current_page<=page_size){
						current_page++;
						document.getElementById("tab-5-demo-mail-list").innerHTML = "";
						var li = "";
						$.each(resourcesObj, function(index, item){
							if(current_page-1*page_num<=index
							   &&index<current_page*page_num){
								
							    li +=' <li class="mail-list-unread mail-attach">
				                    '<div class="mail-control">'
				                    '<input id="src-list-'
								    +index+
								    '" class="magic-checkbox" type="checkbox">
				                    '<label for="src-list-
									+index+
								    '"></label></div>
				                    '<div class="mail-star"><a href="#"><i class="demo-psi-star"></i></a></div>'
				                    '<strong class="mail-from"> '
							
									'<a href="src-download.html" target="_self" id=" '
								    +item.resource_path+
									'" onclick="get_resources(this.id)">'
								    +item.resource_name+
									'</a><br></strong>'
				                    '<div class="mail-time">';
									li += item.resource_upload_time
									  + "</div>
									   '<div class="mail-attach-icon"></div>
									   '<div class="mail-subject"> <a href="mailbox-message.html">";
									li += item.resource_size+item.resource_type
										  + "</a> </div> </li>" ;
							
							}
						});
						$("#tab-5-demo-mail-list").html(li);
						$("#tab-5-page_id").html(current_page);
						$("#tab-5-page_total").html(page_size);
					
				}
			}
		}
		
	});
	}



	function resources_download(){
		var chosen = 0;
		var chosen_src = new Array();
		chosen_src[0] = new Array();//0维存放文件名
		chosen_src[1] = new Array();//一维存放文件路径
		$("#tab-5-demo-mail-list>li>div>input[type=checkbox]").each(function(){
			if($(this).prop("checked") == true){
				let _li = $(this).parent().parent();
				let resource_path = (_li.find("a")).id; 
				let resource_name = (_li.find("a")).innerText;
				chosen_src[0][chosen] = resource_name;
				chosen_src[1][chosen] = resource_path;
			    chosen++;
			   }
		});
		if(chosen == 0)
			alert("请选择下载项");
		else{
			FilesDownload(chosen_src);
		}
			
		}
	


	
	function get_student_homeworks(course_id,homework_id){
		$.ajax({
			type:"POST", // 使用post方式

			// 志愿者报名
			url:"/GetStudentHomeworks",
			contentType:"application/json",


			data:JSON.stringify({
                "status": "0",
                "message": "get_student_homework", 
 				"course_id": course_id,
				"homework_id": homework_id,
            }),
			
			dataType:"json",
			async:false,
			success: function(result){
					
					var num = result.total_num;
					var page_num = 10;//每页10条记录
					var page_size = Math.ceil(num/page_num);//页数
					var homeworkObj = result.value;
					var current_page = 1 ;
					
					document.getElementById("tab-2-demo-mail-list").innerHTML = "";
					$.each(homeworkObj, function(index, item){
						if(index<page_num){//静态显示第一页
							var li = "";
							li += ' <li class="mail-list-unread mail-attach"> '
				                    '<div class="mail-control"> '
				                    '<input id="src-list-'
								    +index+
								    '" class="magic-checkbox" type="checkbox">
				                    '<label for="src-list-
									+index+
								    '"></label>
			                        '</div> '
				                    '<div class="mail-star"><a href="#"><i class="demo-psi-star"></i></a></div>'
				                    '<strong class="mail-from"> '
							
									'<a href="homework-meaasge.html" target="_self" id=" '
								    +item.homework_id+
								    '" onclick="get_homework(this.id)">'
							
									+item.homework_title+
									'</a><br></strong> <div class="mail-time">';
							li += item.homework_deadline
							      + "</div>
				                   '<div class="mail-attach-icon"></div>
				                   '<div class="mail-subject"> <a href="mailbox-message.html">";
							li += item.homework_content
							      + "</a> </div> </li>" ;
							$("#tab-2-demo-mail-list").html(li);
							$("#tab-2-page_id").html(current_page);
							$("#tab-2-page_total").html(page_size);
						}
							
						
					});
					
				
				
			}
		});
	}

	





