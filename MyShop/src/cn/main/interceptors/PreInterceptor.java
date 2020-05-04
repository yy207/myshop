package cn.main.interceptors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.main.pojo.User;
import cn.main.utils.Contains;
import cn.main.utils.CookieUtil;

public class PreInterceptor extends HandlerInterceptorAdapter {
	Logger logger = Logger.getLogger(PreInterceptor.class);

	@Override
	//
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 前置拦截
		logger.debug("SysInterceptor preHandle ==========================");
		HttpSession session = request.getSession();// 获取会话

		User user = (User) session.getAttribute(Contains.SESSION_USER);
		
		if (user != null) {
			logger.debug("当前登录用户信息  "+user.getUserCode()+"    "+user.getUserName());
			return true;
		} else {
			//response.sendRedirect(request.getContextPath() + "/pre403.jsp");
			//根据cookie的信息转发一次请求 
			if(CookieUtil.exists(request)) {
				logger.debug("====================跳转到Cookie登录");
				response.sendRedirect(request.getContextPath() + "/pre/cookie");
			}else {
				response.sendRedirect(request.getContextPath() + "/pre/login");
			}			
			return false;
		} 
	}

}
