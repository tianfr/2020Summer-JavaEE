package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.PasswordReminderInfo;
import com.xjtuse.summerproject.controllerEntity.ResponseInfo;
import com.xjtuse.summerproject.entity.Student;
import com.xjtuse.summerproject.entity.Teacher;
import com.xjtuse.summerproject.mail.MailSenderInfo;
import com.xjtuse.summerproject.mail.SimpleMailSender;
import com.xjtuse.summerproject.mapper.StudentMapper;
import com.xjtuse.summerproject.mapper.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class PasswordReminderController {

    @RequestMapping("/PasswordReminder")
    public @ResponseBody ResponseInfo passwordReminder(@RequestBody PasswordReminderInfo passwordReminderInfo) throws Exception {
        ResponseInfo responseInfo = new ResponseInfo();
        if (!isEmail(passwordReminderInfo.getEmail())) {
            responseInfo.setSuccess_value("0");
            responseInfo.setFail_content("邮箱格式错误");
        }
        else {
            InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            SqlSession sqlSession = factory.openSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            Student student = studentMapper.findByUsername(passwordReminderInfo.getUsername());
            Teacher teacher = teacherMapper.findByUsername(passwordReminderInfo.getUsername());
            sqlSession.close();
            in.close();
            if(student == null && teacher == null) {
                responseInfo.setSuccess_value("0");
                responseInfo.setFail_content("用户名不存在");
            }
            else if (student != null && !student.getStudent_email().equals(passwordReminderInfo.getEmail()) ||
            teacher != null && !teacher.getTeacher_email().equals(passwordReminderInfo.getEmail())) {
                responseInfo.setSuccess_value("0");
                responseInfo.setFail_content("用户名与邮箱不对应，如忘记对应邮箱，请联系管理员");
            }
            else {
                String seed = "myNAMEisCDH"; // des加密时使用的key
                Date date = new Date(); // 获取当前时间
                long time = date.getTime();
                String plainText = "" + time + "@" + passwordReminderInfo.getUsername(); // 组装时间和用户名
                String c = com.xjtuse.summerproject.encrytion.DESUtil.encrypt(seed, plainText); // 加密参数
                String link = "http://localhost:8080/resetPassword.html?key=" + c;
                System.out.println("-----------加密后的链接为---------------------");
                System.out.println(link);

                MailSenderInfo mailInfo = new MailSenderInfo();
                mailInfo.setMailServerHost("smtp.qq.com");
                mailInfo.setMailServerPort("25");
                mailInfo.setValidate(true);
                mailInfo.setUserName("940141567@qq.com");
                mailInfo.setPassword("qmpumzqiinbbbbib");// 邮箱密授权码！！！
                mailInfo.setFromAddress("940141567@qq.com");
                mailInfo.setToAddress(passwordReminderInfo.getEmail());
                mailInfo.setSubject("找回密码");
                String content = "<a href='#'>" + passwordReminderInfo.getEmail() + "</a>，您好：<br>\r\n"+
                        "请在两小时内 ，请访问如下链接，进行密码重置<br>" + "<a href=" + link + ">" + link +"</a>"+
                        "如果您还有任何的疑问，请与我们联系。邮箱地址: <a href='#'>" + "940141567@qq.com" + "</a><br>\r\n" + "请不要直接回复本邮件。<br>";
                mailInfo.setContent(content);
                //发邮件
                SimpleMailSender sms = new SimpleMailSender();
                sms.sendHtmlMail(mailInfo);// 发送html格式 一般用这个
                responseInfo.setSuccess_value("1");
                responseInfo.setFail_content("邮件发送成功，请检查邮箱");
            }
        }
        return responseInfo;
    }

    public static boolean isEmail(String string) {
        if (string == null)
            return false;
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(string);
        if (m.matches())
            return true;
        else
            return false;
    }

}
