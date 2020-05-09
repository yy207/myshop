package cn.main.utils;
import org.apache.commons.mail.HtmlEmail;
/**
 * 邮件发送验证码
 * @author sff
 *
 */
public class SendEmailCode {
	public static boolean sendEmail(String emailaddress,String code){
		try {
			HtmlEmail email = new HtmlEmail();//不用更改
			email.setHostName("smtp.qq.com");//需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
			email.setCharset("UTF-8");
			email.addTo(emailaddress);// 收件地址
 
			email.setFrom("3215389364@qq.com", "MyShop");//此处填邮箱地址和用户名,用户名可以任意填写
 
			email.setAuthentication("3215389364@qq.com", "vioefelynvkpdffd");//此处填写邮箱地址和客户端授权码
 
			email.setSubject("注册信息验证");//此处填写邮件名，邮件名可任意填写
			email.setMsg("尊敬的用户您好,您本次注册的验证码是:" + code+" 如非本人操作,请忽略此邮件!");//此处填写邮件内容 
			email.send();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public static void main(String[] args) {
		System.out.println(sendEmail("207527106@qq.com", "3369"));;
		
		
	}
}
