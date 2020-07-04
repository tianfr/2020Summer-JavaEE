// JavaScript Document


function sign_in() {
    alert("已点击按钮");
    let user_name = $.trim($("#user_name").val());
    let pass_word = $.trim($("#pass_word").val());


    $.ajax({
        type: "POST", // 使用post方式

        // 志愿者报名
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
                location.href = "index.html";
            } else {
                alert(result.fail_content);
                //location.href = "pages-login.html";
            }
        },

        error: function (XMLHttpRequest, textStatus, errorThrown) {
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

        }),
        dataType: "json",
        async: false,
        success: function (result) {
            // 请求成功后的操作
            if (result.success_value == "1") {
                alert("注册成功");
                location.href = "pages-login.html";
            } else {
                alert(result.fail_content);
                //location.href = "pages-login.html";
            }
        },

        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("插入数据失败,请检查数据库链接");
            //alert(textStatus);
        }
    });
}

function reset_pw() {
    alert("已点击按钮");
    let email_pwreminder = $.trim($("#email_pwreminder").val());

    $.ajax({
        type: "POST", // 使用post方式

        url: "/PasswordReminder",
        contentType: "application/json",


        data: JSON.stringify({
            "status": "0",
            "message": "password_reminder",
            "email": email_pwreminder,

        }),

        dataType: "json",
        async: false,
        success: function (result) {
            // 请求成功后的操作
            if (result.success_value == "1") {
                alert("已将密码发送至对应邮箱");
                location.href = "pages-login.html";
                //发邮件
            } else {
                alert("邮箱不存在");
            }
        },

        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("查找失败,请检查数据库链接");
            //alert(textStatus);
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
            // else{
            // 	alert(result.fail_content);
            // 	//location.href = "pages-login.html";
            // }
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
                    "<td>" + item.value + "</td>" +
                    "<td>" + item.course + "</td>" +
                    "<td>" + item.datetime + "</td>" +
                    "<td>" + item.content + "</td>" +
                    "<td>" + item.status + "</td>" +
                    "</tr>";
            });
            $("#con1").html(con1);
        }
    });
}


function get_course_panel() {
    let urlparam = location.search;
    let course_id = "";
    if (urlparam.substr(1, 9) == "courseid=")
        course_id = urlparam.substr(10, 7);

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
    $.ajax({
        type: "POST", // 使用post方式

        url: "/GetCourseAnnouncements",
        contentType: "application/json",


        data: JSON.stringify({
            "status": "0",
            "message": "get_course_announcement",
            //"course": course,

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
                    "<h3 class=\"panel-title\">" + item.announcement_title + "</h3>" +
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