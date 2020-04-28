package cn.main.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.main.pojo.User;
import cn.main.utils.Contains;

public class interceptor extends HandlerInterceptorAdapter {
	Logger logger = Logger.getLogger(interceptor.class);

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
			response.sendRedirect(request.getContextPath() + "/403.jsp");
			return false;
		} 
	}

}
