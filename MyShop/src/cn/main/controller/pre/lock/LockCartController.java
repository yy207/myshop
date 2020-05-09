package cn.main.controller.pre.lock;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.main.pojo.Cart;
import cn.main.pojo.User;
import cn.main.service.GoodService;
import cn.main.service.cart.CartService;
import cn.main.utils.Contains;

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
	private GoodService goodService;
	
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
		
	@RequestMapping("addcart")
	public String addcart(HttpSession session,
			HttpServletRequest request,
			@Param(value="sid")Integer sid
			,@Param(value="gid")Integer gid) {
		User user = (User) session.getAttribute(Contains.SESSION_USER);
		Cart cart = new Cart();
		cart.setGid(gid);
		cart.setUid(user.getId());
		cartService.insertCart(cart); 
		return "redirect:/pre/goodinfo/"+gid+"/"+sid;
	}
		
	
}
