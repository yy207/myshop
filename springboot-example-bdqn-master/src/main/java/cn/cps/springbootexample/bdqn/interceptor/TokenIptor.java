package cn.cps.springbootexample.bdqn.interceptor;

import cn.cps.springbootexample.bdqn.annotation.Token;
import cn.cps.springbootexample.bdqn.context.UserContext;
import cn.cps.springbootexample.bdqn.entity.user.vo.UserInfoVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author: Cai Peishen
 * @Date: 2020/7/2 10:21
 * @Description: 定义Token拦截器
 */
public class TokenIptor extends HandlerInterceptorAdapter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 进入时的拦截
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 上下文信息初始化（防止脏数据）
		UserContext.setToken(null);
		UserContext.setUserId(null);
		UserContext.setUserInfoVO(null);

		try {
			if (handler instanceof HandlerMethod) {
				// 获取handler中的方法
				HandlerMethod handlerMethod = (HandlerMethod) handler;
				Method method = handlerMethod.getMethod();
				// 得到得到方法的Jump注解
				Token tokenAnt = method.getAnnotation(Token.class);

				// 方法上有注解标记，且为true，则重定向到检查Token的控制器中进行Token的验证
				if (tokenAnt != null) {
					String token = request.getHeader("token"); // Token
					logger.info("token={}",token);
					if (!StringUtils.isEmpty(token)) {

						//查询Session
						String content = (String)request.getSession().getAttribute(token);

						if(StringUtils.isEmpty(content)){
							logger.error("token已失效或者为空");
							request.setAttribute("token_error", "token已失效或者为空....");
							request.getRequestDispatcher("/user/returnLogin").forward(request, response);
						}

						//解析JSON数据
						ObjectMapper objectMapper = new ObjectMapper();
						UserInfoVO userInfoVO = objectMapper.readValue(content, UserInfoVO.class);

						//设置用户信息(本次线程中)
						UserContext.setToken(token);
						UserContext.setUserId(userInfoVO.getId());
						UserContext.setUserInfoVO(userInfoVO);

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("----- TokenIptor Exception -----", e);
			return false;
		}

		logger.info("----- TokenIptor Pass！-----");
		return true;
	}

	/**
	 * 数据用户上下文信息（防止脏数据）
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		UserContext.setToken(null);
		UserContext.setUserId(null);
		UserContext.setUserInfoVO(null);
	}
}
