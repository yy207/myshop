package cn.main.controller.backed;

import javax.annotation.Resource; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.main.pojo.User;
import cn.main.service.UserService;
import cn.main.utils.Contains;
import cn.main.utils.StringUtil;

@Controller
@RequestMapping(value="/login")
public class UserController {
	private Logger log = Logger.getLogger(UserController.class);
	
	@Resource
	private UserService service;
	//跳转登录页面
		@RequestMapping(value="login",method=RequestMethod.GET)
		public String login(HttpServletRequest req){
			
			log.debug("===================login"+req.getRemoteUser()+":"+req.getRemoteHost()+":"+req.getRemotePort());
			return "loginPage";
		}
		//登录
		@RequestMapping(value="dologin",method=RequestMethod.POST)
		public String doLogin(@RequestParam String userCode,@RequestParam String userPassword,
								HttpServletRequest request,HttpSession session){
			log.debug("===================dologin");
			log.debug(userCode);
			log.debug(userPassword); 
			User user = service.getUserByUserCode(userCode);
			if(null != user){
				if(user.getUserPassword().equals(userPassword)){ 
					session.setAttribute(Contains.SESSION_USER, user);
					service.updateUserLastLoginTime(user.getId(),Contains.getDate(), 1);
					return "redirect:/user/main";
				}else{
					request.setAttribute(Contains.ERROR, Contains.USER_LOGIN_ERROR_USERPWD);
				} 
			}else{
				request.setAttribute(Contains.ERROR, Contains.USER_LOGIN_ERROR_USERCODE);
			} 
			return "loginPage";
		}
		/**
		 * 前台的ajax验证
		 * @param userCode
		 * @return
		 */
		@RequestMapping(value = "userCode", method = RequestMethod.GET)
		@ResponseBody
		public String getUserCode(
				@RequestParam(value = "userCode", required = false) String userCode) {
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>" + userCode + ">>>>>>>>>");
			if (StringUtil.isEmpty(userCode)) {
				return "error";
			}
			User user = service.getUserByUserCode(userCode);
			if (user == null) {
				return "true";
			} else {
				return "false";
			}
		}
	
}
