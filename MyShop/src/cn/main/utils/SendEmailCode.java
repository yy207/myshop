package cn.main.utils;
import org.apache.commons.mail.HtmlEmail;
/**
 * 邮件发送验证码
 * @author sff
 *
 */
public class SendEmailCode {
	protected static boolean sendEmail(String emailaddress,String code,String title,String content){
		try {
			HtmlEmail email = new HtmlEmail();//不用更改
			email.setHostName("smtp.qq.com");//需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
			email.setCharset("UTF-8");
			email.addTo(emailaddress);// 收件地址
 
			email.setFrom("3215389364@qq.com", "淘宝");//此处填邮箱地址和用户名,用户名可以任意填写
 
			email.setAuthentication("3215389364@qq.com", "vioefelynvkpdffd");//此处填写邮箱地址和客户端授权码
 
			email.setSubject(title);//此处填写邮件名，邮件名可任意填写
			email.setMsg(content);//此处填写邮件内容 
			email.send();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public static boolean sendEmailByCode(String emailaddress,String code) {
		String title="淘宝";
		String content="【淘宝】验证码："+code+"。您正在使用登录功能，该验证码仅用于身份验证，请勿泄露给他人使用!";
		return sendEmail( emailaddress, code, title, content);
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(sendEmailByCode("207527106@qq.com", "3369"));;
		
		
	}
}
