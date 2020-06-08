package cn.main.controller.pre.lock;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.main.pojo.City;
import cn.main.pojo.Order;
import cn.main.pojo.Shop;
import cn.main.pojo.User;
import cn.main.service.OrderService;
import cn.main.service.ShopService;
import cn.main.service.UserService;
import cn.main.service.city.CityService;
import cn.main.utils.Contains;

@Controller
@RequestMapping(value="pre/shop")
public class LockShopController {
	private Logger logger = Logger.getLogger(getClass());
	@Resource
	private OrderService orderService;
	 
	@Resource
	private UserService userService;
	@Resource
	private ShopService	shopService;
	@Resource
	private CityService cityService;
	
	//首页
	@RequestMapping("index")
	public String index() {
		return "shopindex";
	}
	
	//注册连接
	@RequestMapping("register")
	public String register(Model model) { 
		
		return "redirect:/pre/shop/shopreg";
	}
	@RequestMapping("shopreg")
	public String shop(Model model) {
		List<City> cityList1 = cityService.getCityList(null, null, null, 1);
		
		model.addAttribute("cityList1", cityList1);
		
		model.addAttribute("btn", "注册");
		return "shop";
	}
	//店铺信息
	@RequestMapping("shop")
	public String shop(HttpSession session,Model model) {
		User user = (User) session.getAttribute(Contains.SESSION_USER);
		Shop shop = shopService.getShopById(null, user.getId(), null); 
		
		user.setShop(shop);
		List<City> cityList1 = cityService.getCityList(null, null, null, 1);
		//查询地址列表集合
		if(shop == null ) {
			return "registerShop";
		}
		List<City> cityList2 = cityService.getCityList(null, shop.getCity1(), null, 2);
		List<City> cityList3 = cityService.getCityList(null, shop.getCity2(), null, 3); 

		model.addAttribute("cityList1", cityList1);
		model.addAttribute("cityList2", cityList2);
		model.addAttribute("cityList3", cityList3);
		model.addAttribute("shop",shop);
		model.addAttribute("btn", "保存");
		return "shop";
	}
	//发货页面
	@RequestMapping("sendshop")
	public String sendshop(HttpSession session,Model model) {
		User user = (User) session.getAttribute(Contains.SESSION_USER);
		Shop shop = shopService.getShopById(null, user.getId(), null);
		
		//state 2  待发货
		List<Order> orderList2 = orderService.getOrderList(null, null, shop.getId(), null, null, null, null, null, null, null, 2, null, null, null);
		//state 3  待收货
		List<Order> orderList3 = orderService.getOrderList(null, null, shop.getId(), null, null, null, null, null, null, null, 3, null, null, null);
				
		model.addAttribute("orderList2", orderList2);
		model.addAttribute("orderList3", orderList3);
		return "sendshop";
	}
	
	
	//发货  
	@RequestMapping("update") 
	public String update(@Param("id")Integer id,@Param("logidtics") String logidtics) {
		 logger.debug(">>>>>>>>>>>>>>>>>>>id"+id);
		 logger.debug(">>>>>>>>>>>>>>>>>>>order"+logidtics);
		 orderService.updateOrderById(id, logidtics,2);
		 return "redirect:/pre/shop/sendshop"; 
	}
	/**
	 *  修改商店信息   
	 * @param id
	 * @param logidtics
	 * @return
	 */
	@RequestMapping("updateshop") 
	public String updateShop(Shop shop,Model model) {  
		
		
		if(shopService.modifyByShop(shop)>0) {
			return "redirect:/pre/shop/shop"; 
		}else {
			
			model.addAttribute("shop", shop);
			return "shop";
		}  
	}
	
	
	/**
	  * 修改图片
	 * @param request
	 * @param id
	 * @param file
	 * @return
	 */
		@RequestMapping("upload") 
		public String upload(HttpServletRequest request,@Param("id")Integer id,
				@RequestParam(value = "shopImage", required = false) MultipartFile file) {
			Shop shop = shopService.getShopById(id, null, null);
			 logger.debug(">>>>>>>>>>>>>>>>>>>id"+id);

				if (!file.isEmpty()) {// 上传文件不为空
					try {
						String name = file.getOriginalFilename();
						String type = FilenameUtils.getExtension(name);// 文件类型
						int k = 500000;
						if (!Contains.IMG_TYPE.contains(type)) {
							request.setAttribute("imageMsg",
									"* 文件类型错误,文件类型后缀只能为(jpg;jpeg;png;)!");  
							return "shop";
						}
						if (file.getSize() > k) {
							request.setAttribute("imageMsg", "*  文件大小超过限制（500KB）!");  
							return "shop";
						}
						String path = request.getSession().getServletContext()
								.getRealPath("static" + File.separator + "img");
						File f = new File(path, shop.getPicPath());
						if (!f.exists()) {
							f.mkdirs();
						}
						file.transferTo(f); 
						//request.setAttribute("imageMsg", "* 用户头像修改失败!"); 
						return "redirect:/pre/shop/shop";
					} catch (Exception e) {
						request.setAttribute("imageMsg", "* 文件上传失败!");
					} 
				} else{
					request.setAttribute("imageMsg", "* 上传文件为空,无法修改!");
				} 
				return "shop"; 
		}
	
	
		//店铺注册 
		@RequestMapping("regist") 
		public String regist(HttpSession session,@Param("id")Integer id,@Param("shop") Shop shop,Model model) {
			User user = (User) session.getAttribute(Contains.SESSION_USER);
			shop.setUid(  user.getId());
			shop.setCreateTime(Contains.SHORT_DATE_FORMAT_24); 
			
			if(shopService.addByShop(shop)>0) {
				return "redirect:/pre/shop/shop";
			}else {
				model.addAttribute("msg", "注册失败！请检查输入输入的信息是否正确");
				return "shop";
			} 
		}
	
	
	
	
	
	
	
	
	
}
