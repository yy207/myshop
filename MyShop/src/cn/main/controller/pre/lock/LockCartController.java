package cn.main.controller.pre.lock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.main.pojo.Address;
import cn.main.pojo.Cart;
import cn.main.pojo.Good;
import cn.main.pojo.Love;
import cn.main.pojo.Order;
import cn.main.pojo.Shop;
import cn.main.pojo.User;
import cn.main.service.GoodService;
import cn.main.service.OrderService;
import cn.main.service.ShopService;
import cn.main.service.UserService;
import cn.main.service.address.AddressService;
import cn.main.service.cart.CartService;
import cn.main.service.love.LoveService;
import cn.main.utils.Contains;
import cn.main.utils.StringUtil;

/**
 * 购物车
 * @author sff
 *
 */
@Controller
@RequestMapping("pre/cart")
public class LockCartController {
	
	private Logger logger = Logger.getLogger(getClass());
	@Resource
	private CartService cartService;
	@Resource
	private ShopService shopService;
	
	@Resource
	private GoodService goodService;
	
	@Resource
	private AddressService addressService;
	@Resource
	private UserService userService;
	@Resource
	private LoveService loveService;
	@Resource
	private OrderService orderService;
	
	@RequestMapping("cartpage")
	public String cartPage(HttpSession session,HttpServletRequest request) {
		User user = (User) session.getAttribute(Contains.SESSION_USER);
		List<Cart> cartList = cartService.getList(null, user.getId(), null, null, null, null, null);
		
		if(cartList.size()!=0) {
			for (Cart cart : cartList) {
				cart.setGood(goodService.getGoodList(cart.getGid(), null, null, null, null, null, null, null, null).get(0));
			}
		} 
		request.setAttribute("cartList", cartList);
		return "cart";
	}
		
	//@RequestMapping("addcart")
//	public String addcart(HttpSession session,
//			HttpServletRequest request,
//			@Param(value="sid")Integer sid
//			,@Param(value="gid")Integer gid) {
//		User user = (User) session.getAttribute(Contains.SESSION_USER);
//		Cart cart = new Cart();
//		cart.setGid(gid);
//		cart.setUid(user.getId());
//		cartService.insertCart(cart); 
//		return "redirect:/pre/goodinfo/"+gid+"/"+sid;
//	}
	@RequestMapping("addcart")
	@ResponseBody
	public String addcart2(HttpSession session,
			HttpServletRequest request,
			@Param(value="sid")Integer sid
			,@Param(value="gid")Integer gid) {
		User user = (User) session.getAttribute(Contains.SESSION_USER);
		Cart cart = new Cart();
		cart.setGid(gid);
		cart.setUid(user.getId());
		if(cartService.insertCart(cart)>0) {
			return "true";
		}else {
			return "false";
		} 
	} 
	
	/**
	 * 收藏一个
	 * @param session
	 * @param request
	 * @param cid
	 * @return
	 */
	@RequestMapping("addheart")
	@ResponseBody
	public String addhearts(HttpSession session,HttpServletRequest request,
			@Param(value="cid")Integer cid ) { 
		User user = (User) session.getAttribute(Contains.SESSION_USER);
		Cart cart = cartService.getList(cid, user.getId(), null, null, null, null, null).get(0);
		Good good = goodService.getGoodList(cart.getGid(), null, null, null, null, null, null, null, null).get(0);
		List<Love> list = loveService.getLoveList(null, user.getId(), good.getId(),1, null, null);
			if(list.size()==0) {
				Love love = new Love();
				love.setUid(user.getId());
				love.setSid(good.getId());
				love.setType(1); 
				if(cartService.deleteCart(cid)>0&&loveService.insertLove(love)>0 ) {
					return "true";
				}else {
					return "false";
				} 
			}
			if(cartService.deleteCart(cid)>0) {
				return "true";
			}else {
				return "false";
			} 
		} 
	/**
	 * 删除一个
	 * @param session
	 * @param request
	 * @param cid
	 * @return
	 */
	@RequestMapping("delcart")
	@ResponseBody
	public String delartById(HttpSession session,HttpServletRequest request,
			@Param(value="cid")Integer cid ) {
		if(cartService.deleteCart(cid)>0) {
			return "true";
		}else {
			return "false";
		} 
	}

	@RequestMapping(value="delcarts")
	@ResponseBody
	public String delcart(HttpSession session,HttpServletRequest request) {
		Integer count= 0;
		 String[] ss = request.getParameterValues("ids");
		 logger.debug("??????????????  "+ss);
		Integer [] cids = new Integer[ss.length];
		for (int i = 0; i < ss.length; i++) {
			cids[i] = Integer.parseInt(ss[i]);
		}
		  
		for (Integer cid : cids) { 
			logger.debug("??????????????  "+cid);
			if(cartService.deleteCart(cid)>0) {
				count++;
			}; 
		}
		
		if(count==cids.length) {
			return "true";
		}else {
			return "false";
		} 
	}
	@RequestMapping("addhearts")
	@ResponseBody
	public String addheart(HttpSession session,HttpServletRequest request) {
		User user = (User) session.getAttribute(Contains.SESSION_USER);
		Integer count= 0;
		 String[] ss = request.getParameterValues("ids");
		 logger.debug("??????????????  "+ss);
		Integer [] cids = new Integer[ss.length];
		for (int i = 0; i < ss.length; i++) {
			cids[i] = Integer.parseInt(ss[i]);
		} 
		return addhearts(user, cids);
	}
	private String addhearts(User user,Integer ...cids) {
		for (Integer cid : cids) {
			Cart cart = cartService.getList(cid, user.getId(), null, null, null, null, null).get(0);
			Good good = goodService.getGoodList(cart.getGid(), null, null, null, null, null, null, null, null).get(0);
			List<Love> list = loveService.getLoveList(null, user.getId(), good.getId(),1, null, null);
				if(list.size()==0) {
					Love love = new Love();
					love.setUid(user.getId());
					love.setSid(good.getId());
					love.setType(1); 
					loveService.insertLove(love); 
				} 
			cartService.deleteCart(cid);
		}		
		return "true";
 }
	
	 
	
}
