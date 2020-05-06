package cn.main.controller.pre.lock;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.main.pojo.Love;
import cn.main.pojo.User;
import cn.main.service.love.LoveService;
import cn.main.utils.Contains;

@Controller
@RequestMapping("pre/love")
public class LockLoveController {

	private Logger logger = Logger.getLogger(getClass());
	@Resource
	private LoveService loveService;
	
	@RequestMapping("add/{sid}/{type}")
	@ResponseBody
	public String addLove(HttpSession session,@PathVariable(value="sid")Integer sid,
			@PathVariable(value="type")Integer type,@PathVariable(value="add")Integer add) {
			User user = (User) session.getAttribute(Contains.SESSION_USER);
			if(user==null) {
				return "false";
			}
			logger.debug(">>>>>>>>>>>>>>"+sid); 
			logger.debug(">>>>>>>>>>>>>>"+type);
			
			List<Love> list = loveService.getLoveList(null, user.getId(), sid, type, null, null);
			
			if(add==0) {
				if(list==null) {
					Love love = new Love();
					love.setUid(user.getId());
					love.setSid(sid);
					love.setType(type); 
					
					if ( loveService.insertLove(love)>0) { 
						logger.debug(">>>>>>>>>>>>>>  true");
						return "true";
					} else { 
						logger.debug(">>>>>>>>>>>>>>  false");
						return "false";
					} 
				} else {
					return "true";
				}
			}else {
				if ( loveService.deleteLove(5)>0) { 
					logger.debug(">>>>>>>>>>>>>>  true");
					return "true";
				} else { 
					logger.debug(">>>>>>>>>>>>>>  false");
					return "false";
				} 
			}
	}
	
	
	
	
	
	
	
}
