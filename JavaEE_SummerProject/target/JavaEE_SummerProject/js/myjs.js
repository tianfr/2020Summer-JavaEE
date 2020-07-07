// JavaScript Document

function sign_in() {
    let user_name = $.trim($("#user_name").val());
    let pass_word = $.trim($("#pass_word").val());
    $.ajax({
        type: "POST", // 使用post方式
        url: "/Login",
        contentType: "application/json",
        data: JSON.stringify({
            "status": "0",
            "message": "volunteerSend",
            "user_name": user_name,
            "pass_word": pass_word,
        }),
        dataType: "json",
        async: false,
        success: function (result) {
            // 请求成功后的操作
            if (result.success_value == "1") {
                alert("登录成功");
                location.href = "/index.html";
            } else {
                alert(result.fail_content);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("请求失败，请重新尝试");
        }
    });
}

function Register() {
    let full_name = $.trim($("#full_name").val());
    let email = $.trim($("#email").val());
    let user_name = $.trim($("#user_name").val());
    let pass_word = $.trim($("#pass_word").val());
    let pass_word_again = $.trim($("#pass_word_agian").val());
    let role = $.trim($("#role").val());
    if (pass_word != pass_word_again) {
        alert("两次密码不一致，请重新输入");
        return;
    }

    $.ajax({
        type: "POST", // 使用post方式
        url: "/Register",
        contentType: "application/json",
        data: JSON.stringify({
            "status": "0",
            "message": "register",
            "user_name": user_name,
            "pass_word": pass_word,
            "email": email,
            "full_name": full_name,
            "role": role,
        }),
        dataType: "json",
        async: false,
        success: function (result) {
            if (result.success_value == "1") {
                alert("注册成功，id是" + result.role_id);
                location.href = "/login/pages-login.html";
            } else {
                alert(result.fail_content);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接失败,请重新尝试");
        }
    });
}

function find_pw() {
    let email_pwreminder = $.trim($("#email_pwreminder").val());
    let user_name = $.trim($("#user_name").val());
    $.ajax({
        type: "POST", // 使用post方式

        url: "/PasswordReminder",
        contentType: "application/json",


        data: JSON.stringify({
            "status": "0",
            "message": "password_reminder",
            "email": email_pwreminder,
            "username": user_name,
        }),

        dataType: "json",
        async: false,
        success: function (result) {
            // 请求成功后的操作
            if (result.success_value == "1") {
                alert("已将密码发送至对应邮箱");
                location.href = "/login/pages-login.html";
                //发邮件
            } else {
                alert(result.fail_content);
            }
        },

        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接失败,请重新尝试");
            //alert(textStatus);
        }
    });
}

function reset_pw() {
    let pass_word = $.trim($("#password_reset").val());
    let pass_word_again = $.trim($("#password_reset2").val());
    if(pass_word != pass_word_again) {
        alert("两次输入密码不一致，请重新输入");
        return;
    }
    let urlparam = location.search;
    if(urlparam.substr(0,5) != "?key=") {
        alert("链接有误，请重试");
        return;
    }
    let key = urlparam.substr(5);
    $.ajax({
        type: "POST", // 使用post方式
        url: "/PasswordReset",
        contentType: "application/json",
        data: JSON.stringify({
            "password": pass_word,
            "key": key,
        }),
        dataType: "json",
        async: false,
        success: function (result) {
            // 请求成功后的操作
            if (result.success_value == "1") {
                alert("密码修改成功");
                location.href = "/login/pages-login.html";
                //发邮件
            } else {
                alert(result.fail_content);
            }
        },

        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接失败,请重试");
        }
    });
}

function db_menu(){
    $.ajax({
        type:"POST", // 使用post方式
        url:"/DashboardMenu",
        contentType:"application/json",
        data: JSON.stringify({
            "status": "0",
            "message": "dashboard_menu",
            //"user_id": user_id,
        }),
        dataType:"json",
        async:false,
        success: function(result){
            $("#header_name").html(result.user_name);
            $("#header_email").html(result.email);
            var dataObj = result.value,con="";
            $.each(dataObj,function(index,item){
                con+=
                    '<li><a href="course-dashboard.html?cid='+item.id+'" target="_self"><i class="demo-psi-pen-5"></i><span class="menu-title">'
                    +item.course_name+
                    "</span></a></li>"
            });
            $("#db_index").html(con);
        }
    });
}

function recent_info() {

    $.ajax({
        type: "POST", // 使用post方式
        url: "/RecentInfo",
        contentType: "application/json",
        data: JSON.stringify({
            "status": "0",
            "message": "recent_info",
        }),
        dataType: "json",
        async: false,
        success: function (result) {
            if (result.id == "recent_info") {
                // 请求成功后的操作
                var dataObj = result.value;
                var info_data = "";
                $.each(dataObj, function (index, item) {
                    var rec_info = "";
                    rec_info += "<td>" + item.id + "</td>";
                    rec_info += "<td>" + item.course + "</td>";
                    rec_info += "<td>" + item.value + "</td>";
                    rec_info += "<td>" + item.datetime + "</td>";
                    info_data += "<tr>" + rec_info + "</tr>";
                });
                $("#recent-info-data").html(info_data);
            }
        },
    });
}

function upcoming_issue() {
    $.ajax({
        type: "POST", // 使用post方式

        url: "/UpcomingIssue",
        contentType: "application/json",


        data: JSON.stringify({
            "status": "0",
            "message": "upcoming_issue",
        }),

        dataType: "json",
        async: false,
        success: function (result) {
            var dataObj = result.value, con1 = "";
            $.each(dataObj, function (index, item) {
                con1 += "<tr>" +
                    '<td><a href="'+item.issue_id_path+'" target="_self">'+item.value+"</a></td>" +
                    "<td>"+item.course+"</td>" +
                    "<td>"+item.datetime+"</td>" +
                    "<td>"+item.content+"</td>" +
                    '<td ><div class="label label-table label-'
                    +item.status+'">'+item.status+
                    "</div></td>" +
                    "</tr>";
            });
            $("#con1").html(con1);
        }
    });
}


function get_course_panel() {
    let urlparam = location.search;
    let course_id = "";
    if (urlparam.substr(1, 4) == "cid=")
        course_id = urlparam.substr(5, 14);

    $.ajax({
        type: "POST", // 使用post方式

        // 获取course数据
        url: "/GetCoursePanel",
        contentType: "application/json",


        data: JSON.stringify({
            "status": "0",
            "message": "get_course_panel",
            "course_id": course_id,
        }),
        dataType: "json",
        async: false,
        success: function (result) {
            if (result.id == "course_panel") {
                var dataObj = result.value;
                var course_panel = "";
                $.each(dataObj, function (index, item) {
                        course_panel += "<a href=\"#" + item.panel_id + "\" class=\"list-group-item list-item-sm\" target=\"_self\"><span class=\"badge badge-purple badge-icon badge-fw pull-left\"></span>" + item.panel_name + "</a>";
                    }
                ),
                    $("#coursePanel").html(course_panel);
            }
        },
    });
}

function course_announcement() {
    let urlparam = location.search;
    let course_id = "";
    if (urlparam.substr(1, 4) == "cid=")
        course_id = urlparam.substr(5, 14);

    $.ajax({
        type: "POST", // 使用post方式

        url: "/GetCourseAnnouncements",
        contentType: "application/json",


        data: JSON.stringify({
            "status": "0",
            "message": "get_course_announcement",
            "course_id": course_id,

        }),

        dataType: "json",
        async: false,
        success: function (result) {
            var dataObj = result.value;
            var con = "";
            $.each(dataObj, function (index, item) {
                con +=
                    "<div class=\"panel\">" +
                    "<div class=\"panel-heading\">" +
                    "<h3 class=\"panel-title\">" +
                    "<a href=\"announcement.html?cid=" +
                    course_id +
                    "&aid="+
                    item.announcement_id +
                    "\">" +
                    item.announcement_title +
                    "</a>" +
                    "</h3>" +
                    "</div> " +
                    "<div class=\"panel-body1\">" +
                    "<div class=\"show-r3\" style=\"overflow: hidden;text-overflow: ellipsis;display:-webkit-box;-webkit-line-clamp:3;-webkit-box-orient:vertical;\">" +
                    item.announcement_content +
                    "</div>" +
                    "</div>" +
                    "</div>"
            });
            $("#course_an").html(con);
        }
    });
}

function get_announcement(){
    let urlparam = location.search;
    let course_id = "";
    let homework_id = "";
    if (urlparam.substr(1, 4) == "cid=" && urlparam.substr(urlparam.split("&")[0].length, 5) == "&aid=") {
        course_id = urlparam.substr(5).split("&")[0];
        homework_id = urlparam.substr(urlparam.split("&")[0].length + 5);
        alert(course_id);
        alert(homework_id);
    }

    $.ajax({
        type:"POST", // 使用post方式

        url:"/GetAnnouncement",
        contentType:"application/json",

        data: JSON.stringify({
            "status": "0",
            "message": "get_announcement",
            "course_id": course_id,
            "announcement_id": announcement_id //注意：这个变量在get_course_announcement中出现过。
        }),

        dataType:"json",
        async:false,
        success: function(result){
            $("#headline").html("<span class=\"label label-normal label-info\">公告</span>"+result.annoyncement_title);
            $("#teacher_name").html(result.author);
            $("#teacher_email").html(result.author_email);
            $("#teacher_pic").attr('src',result.author_avatar);
            $("#datetime").html(result.datetime);
            $("#annou_content").html(result.announcement_content);
        }


    });
}

function get_course_homeworks(){
    let urlparam = location.search;
    let course_id = "";
    if (urlparam.substr(1, 4) == "cid=")
        course_id = urlparam.substr(5).split("&")[0];

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
                var page_num = 10;//每页10条记录
                var page_size = Math.ceil(num/page_num);//页数
                var homeworkObj = result.value;
                var current_page = 1 ;
                var li = "";
                // document.getElementById("demo-mail-list").innerHTML = "";
                $.each(homeworkObj, function(index, item){
                    if(index<page_num){//静态显示第一页
                        li +=
                            "<li class=\"mail-list-unread mail-attach\">" +
                                "<div class=\"mail-control\">" +
                                    "<input id=\"email-list-1\" class=\"magic-checkbox\" type=\"checkbox\">" +
                                    "<label for=\"email-list-1\"></label>" +
                                "</div>" +
                                "<div class=\"mail-star\"><a href=\"#\"><i class=\"demo-psi-star\"></i></a></div>" +
                                "<strong class=\"mail-from\">" +
                                    "<a href=\"homework-message.html?cid=" + course_id + "&hid=" + item.homework_id + "\" target=\"_self\" "  + ">" +
                                        item.homework_title +
                                    "</a><br>" +
                                "</strong>" +
                                "<div class=\"mail-time\">" + item.homework_deadline + "</div>" +
                                "<div class=\"mail-attach-icon\"></div>" +
                                "<div class=\"mail-subject\">" +
                                    "<a href=\"homework-message.html?cid=" + course_id + "&hid=" + item.homework_id + "\">" + item.homework_content + "</a> " +
                                "</div>"+
                            "</li>";
                    }
                });
                $("#demo-mail-list").html(li);
                $("#tab2_page_id").html(current_page);
                $("#tab2_page_total").html(page_size);
                document.getElementById("tab2_page_id").setAttribute("value", current_page);
            }
        }
    });
}


function homework_flip_left(){
    let current_page = document.getElementById("tab2_page_id").getAttribute("value");
    alert(current_page)
    let urlparam = location.search;
    let course_id = "";
    if (urlparam.substr(1, 4) == "cid=")
        course_id = urlparam.substr(5).split("&")[0];

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
                var page_num = 10;//每页10条记录
                var page_size = Math.ceil(num/page_num);//页数
                var homeworkObj = result.value;
                var li = "";
                if(current_page>1){
                    current_page--;
                    document.getElementById("demo-mail-list").innerHTML = "";
                    $.each(homeworkObj, function(index, item){
                        if(current_page-1*page_num<=index
                            &&index<current_page*page_num){
                            li +=
                                "<li class=\"mail-list-unread mail-attach\">" +
                                    "<div class=\"mail-control\">" +
                                        "<input id=\"email-list-1\" class=\"magic-checkbox\" type=\"checkbox\">" +
                                        "<label for=\"email-list-1\"></label>" +
                                    "</div>" +
                                    "<div class=\"mail-star\"><a href=\"#\"><i class=\"demo-psi-star\"></i></a></div>" +
                                        "<strong class=\"mail-from\">" +
                                            "<a href=\"homework-message.html\" target=\"_self\" id=\" " + course_id + ":" + item.homework_id + "\" onclick=\"get_homework(this.id)\">" +
                                                item.homework_title +
                                            "</a>" +
                                            "<br>" +
                                        "</strong>" +
                                    "<div class=\"mail-time\">" + item.homework_deadline + "</div>" +
                                    "<div class=\"mail-attach-icon\"></div>" +
                                    "<div class=\"mail-subject\"> <a href=\"homework-message.html\">" + item.homework_content + "</a> </div> " +
                                "</li>" ;
                        }
                    });
                    $("#demo-mail-list").html(li);
                    $("#page_id").html(current_page);
                    $("#page_total").html(page_size);
                    document.getElementById("tab2_page_id").setAttribute("value", current_page);
                }
            }
        }
    });
}

function homework_flip_right(){
    let current_page = document.getElementById("tab2_page_id").getAttribute("value");
    alert(current_page);
    let urlparam = location.search;
    let course_id = "";
    if (urlparam.substr(1, 4) == "cid=")
        course_id = urlparam.substr(5).split("&")[0];

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
                var page_num = 10;//每页10条记录
                var page_size = Math.ceil(num/page_num);//页数
                var homeworkObj = result.value;
                var li = "";
                if(current_page<page_size){
                    current_page++;
                    document.getElementById("demo-mail-list").innerHTML = "";
                    $.each(homeworkObj, function(index, item){
                        if((current_page-1)*page_num<=index
                            &&index<current_page*page_num){
                            li +=
                                "<li class=\"mail-list-unread mail-attach\" value=\"" + item.homework_id + "\">" +
                                    "<div class=\"mail-control\">" +
                                        "<input id=\"email-list-1\" class=\"magic-checkbox\" type=\"checkbox\">" +
                                        "<label for=\"email-list-1\"></label>" +
                                    "</div>" +
                                    "<div class=\"mail-star\"><a href=\"#\"><i class=\"demo-psi-star\"></i></a></div>" +
                                    "<strong class=\"mail-from\"> " +
                                        "<a href=\"homework-message.html\" target=\"_self\" id=\"" + course_id + ":" + item.homework_id + "\" onclick=\"get_homework(this.id)\">" +
                                            item.homework_title +
                                        "</a><br>" +
                                    "</strong>" +
                                    "<div class=\"mail-time\">" + item.homework_deadline + "</div>" +
                                    "<div class=\"mail-attach-icon\"></div>" +
                                    "<div class=\"mail-subject\"> <a href=\"homework-message.html\">" + item.homework_content + "</a> </div>" +
                                "</li>" ;
                        }
                    });
                    $("#demo-mail-list").html(li);
                    $("#page_id").html(current_page);
                    $("#page_total").html(page_size);
                    document.getElementById("tab2_page_id").setAttribute("value", current_page);
                }
            }
        }

    })
}

function get_homework(){

    let urlparam = location.search;
    let course_id = "";
    let homework_id = "";
    if (urlparam.substr(1, 4) == "cid=" && urlparam.substr(urlparam.split("&")[0].length, 5) == "&hid=") {
        course_id = urlparam.substr(5).split("&")[0];
        homework_id = urlparam.substr(urlparam.split("&")[0].length + 5);
        alert(course_id);
        alert(homework_id);
    }
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
            var alert_content = "";
            var headline_content = "<span class=\"label label-normal label-info\">作业</span>" + result.homework_title;
            $("#headline").html(headline_content);
            $("#teacher_name").html(result.author);
            $("#teacher_email").html(result.author_email);
            $("#teacher_pic").attr('src',result.author_avatar);
            $("#datetime").html(result.datetime);
            $("#homework_content").html(result.homework_content);
            //还没有判断作业有没有提交过
            if(days_diff<0){
                alert_content += '<div class="alert alert-danger"> <strong>';
            }
            else if(days_diff<1){
                alert_content += '<div class="alert alert-warning"> <strong>';
            }
            else{
                alert_content += '<div class="alert alert-primary"> <strong>';
            }
            alert_content += result.homework_deadline+
                '</strong> </div>';
            $("#homework_ddl").html(alert_content);

            $.each(attachmentObj, function(index, item){
                li += '<li> <a href="#" class="thumbnail"><div class="mail-file-img"><a href=" '
                    +item.attachment_path+
                    ' " target="_self">' +
                '<img class="image-responsive" src="img/bg-img/bg-img-4.jpg"   alt="image"></a></div><div class="caption"> ' +
                '<p class="text-primary mar-no" id="attachment_name">'
                +item.attachment_name+
                '</p></div></a></li>'
            });
            $("#mail-attach-list").html(li);
        }


    });

}


function load_homework(){

    let urlparam = location.search;
    let course_id = "";
    let homework_id = "";
    if (urlparam.substr(1, 4) == "cid=" && urlparam.substr(urlparam.split("&")[0].length, 5) == "&hid=") {
        course_id = urlparam.substr(5).split("&")[0];
        homework_id = urlparam.substr(urlparam.split("&")[0].length + 5);
        alert(course_id);
        alert(homework_id);
    }

    $.ajax({
        type:"POST", // 使用post方式

        url:"/GetExistedHomework",
        contentType:"application/json",


        data: JSON.stringify({
            "status": "0",
            "message": "get_existed_homework",
            "course_id": course_id,
            "homework_id": homework_id,

        }),

        dataType:"json",
        async:false,
        success: function(result){
            var con="";
            var string_ddl = result.homework_deadline+":00";
            var ddl_day = new Date(string_ddl);
            var today = new Date();
            var days_diff = (ddl_day.getTime() - today.getTime())/(1*24*60*60*1000);
            if(result.homework_status=="drafted"){
                // $(".note-editable .p").html(result.homework_content);
                $(".demo-mail-compose").summernote("code",result.homework_content);
            }
            if(result.homework_status=="submitted"){
                con+='<div class="alert alert-mint"><strong>Well done!</strong>Your homework has been submitted, SUBMITTED TIME: '+result.submitted_time+"</div>";
            }
            if((result.homework_status=="drafted"||result.homework_status=="null")&&days_diff>0){
                con+='<div class="alert alert-warning">Deadline of this homework is '+result.homework_deadline+"</div>";
            }
            if((result.homework_status=="drafted"||result.homework_status=="null")&&days_diff<0){
                con+='<div class="alert alert-danger">This homework has been expired.</div>';
            }
            $("#hw_status").html(con);

        }
    });
}



function tab1Location() {
    let course_id = "";
    let urlparam = location.search;
    if (urlparam.substr(1, 4) == "cid=")
        course_id = urlparam.substr(5).split("&")[0];
    location = "course-dashboard.html?cid=" +course_id;
}