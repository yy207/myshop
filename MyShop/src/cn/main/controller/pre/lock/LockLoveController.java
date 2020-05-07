package cn.main.controller.pre.lock;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.main.pojo.Good;
import cn.main.pojo.Love;
import cn.main.pojo.User;
import cn.main.service.GoodService;
import cn.main.service.ShopService;
import cn.main.service.love.LoveService;
import cn.main.utils.Contains;

@Controller
@RequestMapping("pre/love")
public class LockLoveController {

	private Logger logger = Logger.getLogger(getClass());
	@Resource
	private LoveService loveService;
	@Resource
	private GoodService goodService;
	@Resource
	private ShopService shopService;
	/**
	 * 
	 * @param session
	 * @param sid
	 * @param type  1商品 2店铺
	 * @param add 0添加 1 删除
	 * @return
	 */
	@RequestMapping("add/{sid}/{type}/{add}")
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
				if(list.size()==0) {
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
				if(list.size()==0) {
					return "true";
				} else {
					if ( loveService.deleteLove(list.get(0).getId())>0) { 
						logger.debug(">>>>>>>>>>>>>>  true");
						return "true";
					} else { 
						logger.debug(">>>>>>>>>>>>>>  false");
						return "false";
					}  
				} 
			}
	} 
	@RequestMapping("lovepage/{type}") 
	public String lovepage(HttpSession session,
				HttpServletRequest request,
				@PathVariable(value="type")Integer type) {
			
			User user = (User) session.getAttribute(Contains.SESSION_USER);
		 	List<Love> loveList = loveService.getLoveList(null, user.getId(), null, type, null, null); 
			if(type==1) {
				if(loveList.size()!=0) {
					for (Love love : loveList) {
						love.setGood(goodService.getGoodList(love.getSid(), null, null, null, null, null, null, null, null).get(0));
					}
				}  
				request.setAttribute("loveList", loveList);
				return "likegood"; 
			}else {
				if(loveList.size()!=0) {
					for (Love love : loveList) {
						love.setShop(shopService.getShopById(love.getSid(), null, null));
						List<Good> list = goodService.getGoodList(null, love.getShop().getId(), null, null, null, null, 4, 0, 6);
						love.getShop().setGoods(list); 
					}
				}  
				request.setAttribute("loveList", loveList);
				return "likeshop"; 
			} 
	} 
	
	@RequestMapping("delove/{id}/{type}") 
	public String delove(HttpSession session,
				HttpServletRequest request,
				@PathVariable(value="id")Integer id,
				@PathVariable(value="type")Integer type) {
		
		loveService.deleteLove(id);
		
		if(type==1) {
			return "redirect:/pre/love/lovepage/1";
		}else {
			return "redirect:/pre/love/lovepage/2";
		} 
	}
}
