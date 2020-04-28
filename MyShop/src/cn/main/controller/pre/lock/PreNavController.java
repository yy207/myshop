package cn.main.controller.pre.lock;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.main.pojo.Address;
import cn.main.pojo.Order;
import cn.main.pojo.User;
import cn.main.service.OrderService;
import cn.main.service.address.AddressService;
import cn.main.utils.Contains;
import cn.main.utils.Page;

@Controller
@RequestMapping("pre/nav")
public class PreNavController {
	@Resource
	private  OrderService orderService;
	
	@Resource
	private  AddressService addressService;
	
	/**
	 * 请求订单页
	 * @return
	 */
	@RequestMapping("addresspage")
	public String addressPage(HttpSession session,HttpServletRequest request){
		User user  = (User) session.getAttribute(Contains.SESSION_USER);
		
		List<Address> addressList = addressService.getAddress(null, user.getId(), null, null);
		
		request.setAttribute("addressList", addressList);
		return "pre/lock/nav_address";
	}
	/**
	 * 请求地址页
	 * @return
	 */
	@RequestMapping("orderpage")
	public String orderPage(HttpSession session,HttpServletRequest request){
		User user  = (User) session.getAttribute(Contains.SESSION_USER);
		List<Order> orderList = orderService.getOrderList(null,user.getId(), null, null, null, null, null, null, null, null);		
		request.setAttribute("orderList", orderList);//将订单的信息存储在请求 
		
		return "pre/lock/nav_order";
	}
	
	

}
