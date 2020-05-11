package cn.main.controller.pre;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import cn.main.pojo.User;
import cn.main.service.UserService;
import cn.main.utils.Contains;
import cn.main.utils.CookieUtil;
import cn.main.utils.ImageCode;
import cn.main.utils.Md5Util;
import cn.main.utils.SendEmailCode;

@Controller
@RequestMapping(value="/pre")
public class PreUserController {
	private Logger log = Logger.getLogger(PreUserController.class);
	
	@Resource
	private UserService service;
		//登录
		@RequestMapping(value="dologin")
		public String doLogin(@RequestParam String userCode,@RequestParam String userPassword,
								@RequestParam(required=false,value="auto") Boolean auto,
								HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
			log.debug("===================dologin");
			log.debug(userCode);
			log.debug(userPassword); 
			User user = service.getUserByUserCode(userCode);
			if(null != user){
				if(Md5Util.MD5Verify(userPassword,user.getUserPassword())){ 
					session.setAttribute(Contains.SESSION_USER, user);
					service.updateUserLastLoginTime(user.getId(),Contains.getDate(), 1);
					log.debug(">>>>>>>>======================auto 1-- "+auto);
					if(auto!=null && auto) {
						log.debug(">>>>>>>>======================auto 2--  "+auto);
						Cookie name = new Cookie("userCode", userCode); 
						Cookie pwd = new Cookie("userPassword", Md5Util.MD5(userPassword)); 
						name.setMaxAge(24*60*60);
						pwd.setMaxAge(24*60*60);
						response.addCookie(name); 
						response.addCookie(pwd); 
					}else {
						log.debug(">>>>>>>>======================auto 2--  "+auto);
						Cookie name = new Cookie("userCode", userCode); 
						Cookie pwd = new Cookie("userPassword",  Md5Util.MD5(userPassword)); 
						name.setMaxAge(0);
						pwd.setMaxAge(0);
						response.addCookie(name); 
						response.addCookie(pwd);
					}
					return "redirect:/pre/index";
				}else{
					request.setAttribute(Contains.ERROR, Contains.USER_LOGIN_ERROR_USERPWD);
				} 
			}else{
				request.setAttribute(Contains.ERROR, Contains.USER_LOGIN_ERROR_USERCODE);
			} 
			return "login";
		}
		@RequestMapping(value = "registe", method = RequestMethod.POST)
		public String registe(
				User user,
				Model model,
				@RequestParam(value = "imageCode", required = true) String imageCode,
				HttpSession session,
				HttpServletRequest request,
				@RequestParam(value = "userImage", required = false) MultipartFile file) throws Exception {
			log.debug("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			log.debug(user.getUserCode()); 
			log.debug(user.getUserPassword());
			log.debug(user.getRealName());  
			if(user.getUserCode()==null||user.getRealName()==null||user.getUserPassword()==null||
					user.getUserPassword().length()<6 	){
				return "register";
			}
			user.setUserPassword(Md5Util.MD5(user.getUserPassword()));
			user.setUserName(user.getRealName()); 
			user.setUserPic("default.jpg"); 
			user.setCreateTime(Contains.getDate()); 
			User u =((User) session.getAttribute(Contains.SESSION_USER));
			user.setCreateBy(u==null?0:u.getId());
			log.debug("imageCode"+imageCode);
			log.debug(">>>>>>>>>>"+((String)session.getAttribute(Contains.IMAGECODE)));
	
			
			if(imageCode!=null && imageCode.toUpperCase().equals(((String)session.getAttribute(Contains.IMAGECODE)).toUpperCase())){
				if (service.addUser(user)) {
					
					return "redirect:/pre/login";
				} else {
					model.addAttribute(user);
					model.addAttribute("imageCodeMsg", "添加失败,请重试!");
					return "register";
				}
			} else {
				model.addAttribute(user);
				System.out.println(">>>>>>>>>>>>请输入正确的验证码");
				model.addAttribute("imageCodeMsg", "请输入正确的验证码");
				
				return "register";
			}
			
		} 
		
	
		@RequestMapping(value = "cookie")
		public String cookie(HttpServletRequest request,HttpServletResponse response,HttpSession session){
			if(CookieUtil.exists(request)) {
				String userCode = null;
				String userPassword = null;
				String [] value = CookieUtil.getCookieValue(request);
				if(value[0]!=null && value[1]!=null ) {
					userCode = value[0];
					userPassword = value[1];
				}
				User user = service.getUserByUserCode(userCode);
				log.debug("====================跳转到Cookie登录转到index code"+value[0]);
				log.debug("====================跳转到Cookie登录转到index pwd"+value[1]);
				if(null != user){
					if(user.getUserPassword().equals(userPassword)){ 
						session.setAttribute(Contains.SESSION_USER, user);
						Cookie name = new Cookie("userCode", userCode); 
						Cookie pwd = new Cookie("userPassword", userPassword); 
						name.setMaxAge(24*60*60);
						pwd.setMaxAge(24*60*60);
						response.addCookie(name); 
						response.addCookie(pwd);
						log.debug("====================跳转到Cookie登录转到index");
						return "redirect:/pre/index";
					} 
				} 
				return "login";
			}else {
				return "login";
			}
		}	
		

		@RequestMapping("sendemail")
		@ResponseBody
		public String sendEmail(HttpSession session,@Param(value="email") String email){

			List<User> user = service.getAllUser(null, null, null, null, null, null, null, email, null, null, null, null, null);
			if(user.size()==0) {
				return "null";
			}
			String code = ImageCode.createEmailCode();//创建COde
			if(SendEmailCode.sendEmailByCode(email, code)) {
				//加密存到会话
				try {
					session.setAttribute(Contains.EMAIL, email);
					session.setAttribute(Contains.EMAIL_CODE, Md5Util.MD5(code));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "false";
				}
				return "true";
			}//发送code
			else { 
				return "false";
			} 
		}
		

		@RequestMapping("loginemail") 
		public String loginEmail(HttpServletRequest request,
								HttpSession session,
								@Param(value="email") String email
								,@Param(value="code") String code){
			
			String eqEmail = (String) session.getAttribute(Contains.EMAIL);
			if(eqEmail==null) {
				session.removeAttribute("msg");
				return "redirect:/pre/login";
			}
			String eqCode = (String) session.getAttribute(Contains.EMAIL_CODE);
			session.removeAttribute(Contains.EMAIL_CODE);
			session.removeAttribute(Contains.EMAIL);
			session.removeAttribute("msg");
			if(eqEmail!=null&&email.equals(eqEmail)) {
				try {
					if(eqCode!=null&&Md5Util.MD5Verify(code, eqCode)) {
						User user = service.getAllUser(null, null, null, null, null, null, null, email, null, null, null, null, null).get(0);
						session.setAttribute(Contains.SESSION_USER, user);
						return "redirect:/pre/index";
					} 
				} catch (Exception e) { 
					e.printStackTrace();
				}
				session.setAttribute("msg", "* 验证码有误,请重新获取！");
			}else {
				session.setAttribute("msg", "* 登录邮箱与验证邮箱不一致！");
			} 
			session.setAttribute("display", email);
			return "login";
		} 
		
		@RequestMapping("login")
		public String login(){ 
			return "login";
		}
		@RequestMapping("register")
		public String register(){
			return "register";
		}
		// 登出
		@RequestMapping(value = "loginout")
		public String loginOut(HttpSession session,HttpServletResponse response) throws Exception {
			User user = (User) session.getAttribute(Contains.SESSION_USER);
			if(user != null){
				service.updateUserLastLoginTime(user.getId(), Contains.getDate(), 0);
				session.removeAttribute(Contains.SESSION_USER);
				log.debug("======================loginout==");
				Cookie name = new Cookie("userCode", user.getUserCode()); 
				Cookie pwd = new Cookie("userPassword", user.getUserPassword()); 
				name.setMaxAge(0);
				pwd.setMaxAge(0);
				response.addCookie(name); 
				response.addCookie(pwd);
			} 
			return "redirect:/pre/index";
		}
		
		
		
		
		
}
