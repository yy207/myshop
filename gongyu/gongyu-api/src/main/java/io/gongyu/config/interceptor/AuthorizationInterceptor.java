package io.gongyu.config.interceptor;

import io.gongyu.annotation.Login;
import io.gongyu.common.exception.RRException;
import io.gongyu.login.entity.TokenEntity;
import io.gongyu.login.entity.UserEntity;
import io.gongyu.login.service.TokenService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 权限(Token)验证
 *
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private TokenService tokenService;

	public static final String USER_KEY = "userId";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		// 每一个项目对于登陆的实现逻辑都有所区别，我这里使用最简单的Session提取User来验证登陆。
		// 这里的User是登陆时放入session的
		UserEntity user = (UserEntity) session.getAttribute("user");
		if (user == null) {
			// 这个方法返回false表示忽略当前请求，如果一个用户调用了需要登陆才能使用的接口，如果他没有登陆这里会直接忽略掉
			throw new RRException("请先登录。");
		} else {
			Login annotation;
			if (handler instanceof HandlerMethod) {
				annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
			} else {
				return true;
			}

			if (annotation == null) {
				return true;
			}

			// 从header中获取token
			String token = request.getHeader("token");
			// 如果header中不存在token，则从参数中获取token
			if (StringUtils.isBlank(token)) {
				token = request.getParameter("token");
			}

			// token为空
			if (StringUtils.isBlank(token)) {
				throw new RRException("token不能为空");
			}

			// 查询token信息
			TokenEntity tokenEntity = tokenService.queryByToken(token);
			if (tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()) {
				throw new RRException("token失效，请重新登录");
			}

			// 设置userId到request里，后续根据userId，获取用户信息
			request.setAttribute(USER_KEY, tokenEntity.getUserId());
			return true;
		}
	}
}
