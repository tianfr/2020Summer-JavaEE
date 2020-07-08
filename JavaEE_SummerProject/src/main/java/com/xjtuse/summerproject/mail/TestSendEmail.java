package com.xjtuse.summerproject.mail;


/**
 * 测试发送邮件
 * 
 * @author sakura
 *
 */
public class TestSendEmail {

	public static void main(String[] args) {
		// 设置邮件
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.qq.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("940141567@qq.com");
		mailInfo.setPassword("qmpumzqiinbbbbib");// 邮箱密授权码！！！
		mailInfo.setFromAddress("940141567@qq.com");

		mailInfo.setToAddress("3085140354@qq.com");

		mailInfo.setSubject("找回密码");
		String link = "http://localhost:8080/forgetPassword/resetPassword?key=47ebc437ad9b444400693443d1609c3bf5221568a680766ac900978672e6fdfc";
		
		String content = "<a href='#'>" + "3085140354@qq.com" + "</a>，您好：<br>\r\n"+
				"请在两小时内 ，请访问如下链接，进行密码重置<br>" + "<a href=" + link + ">" + link +"</a>"+
				"如果您还有任何的疑问，请与我们联系。邮箱地址: <a href='#'>" + "3085140354@qq.com" + "</a><br>\r\n" + "请不要直接回复本邮件。<br>";
		mailInfo.setContent(content);
		
		//发邮件
		SimpleMailSender sms = new SimpleMailSender();
		sms.sendHtmlMail(mailInfo);// 发送html格式 一般用这个
//		sms.sendTextMail(mailInfo);//发纯文本格式的邮件
		
	}

}
