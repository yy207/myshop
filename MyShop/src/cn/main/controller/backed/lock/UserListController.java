package cn.main.controller.backed.lock;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import cn.main.controller.backed.UserController;
import cn.main.pojo.Address;
import cn.main.pojo.DataDictionary;
import cn.main.pojo.Order;
import cn.main.pojo.Shop;
import cn.main.pojo.User;
import cn.main.service.DataDictionaryService;
import cn.main.service.OrderService;
import cn.main.service.ShopService;
import cn.main.service.UserService;
import cn.main.service.address.AddressService;
import cn.main.utils.Contains;
import cn.main.utils.Page;
import cn.main.utils.StringUtil;

@Controller
@RequestMapping("/user")
public class UserListController {

	private Logger log = Logger.getLogger(UserController.class);
	@Resource
	private UserService service;
	@Resource
	private DataDictionaryService dataService;
	@Resource
	private ShopService shopService;
	@Resource
	private AddressService addressService;
	@Resource
	private OrderService orderService;
	
	// 用户列表
	@RequestMapping(value = "/userlist")
	public String userList(
			Model model,
			Page page,
			@RequestParam(value = "userCode", required = false) String userCode,
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "userRole", required = false) String userRole,
			@RequestParam(value = "currentIndex", required = false) String currentIndex,Integer pageSize) {
		log.debug("======================/list/userlist");
		log.debug("======================userCode" + userCode);
		log.debug("======================userRole" + userRole);
		log.debug("======================page" + page);
		log.debug("======================userName" + userName);
		log.debug("======================currentIndex" + currentIndex);
		// load userRole
		List<DataDictionary> dataList = dataService.getDataDictionaryList(
				"userRole", null);
		Integer role = null;
		log.debug(dataList.size());
		if (null != userRole && userRole != "") {
			role = Integer.parseInt(userRole);
		}
		page.setPageSize(pageSize==null?10:pageSize);
		// loag page tool
		page.setCurrentIndex(currentIndex != null && currentIndex != "" ? Integer
				.parseInt(currentIndex) : 1);
		page.setTotalCount(service.getAllUserCount(userCode, userName, role,
				null, null, null, null, null, null, null, null));
		// get data
		List<User> list = service.getAllUser(userCode, userName, role, null,
				null, null, null, null, null, null, null,
				(page.getCurrentIndex() - 1) * page.getPageSize(),
				page.getPageSize());
		// save data
		model.addAttribute("userCode", userCode);
		model.addAttribute("userName", userName);
		model.addAttribute("userRole", userRole);
		if (list.size() == 0)
			model.addAttribute("msg", "当前条件下暂无记录！");
		// page
		model.addAttribute("pages", page);
		model.addAttribute("dataList", dataList);
		model.addAttribute("userList", list);

		return "jsp/list/userList";
	}

	// ajax加载用户角色
	@RequestMapping(value = "userRole", method = RequestMethod.GET)
	@ResponseBody
	public String getUserRole(
			@RequestParam(value = "keyCode", required = false) String keyCode) {
		List<DataDictionary> dataList = dataService.getDataDictionaryList(
				keyCode, null);
		log.debug(">>>>>>>>>>>>>>" + JSON.toJSONString(dataList));
		return JSON.toJSONString(dataList);
	}

	@RequestMapping(value = "userCode", method = RequestMethod.GET)
	@ResponseBody
	public String getUserCode(
			@RequestParam(value = "userCode", required = false) String userCode) {
		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>" + userCode + ">>>>>>>>>");
		if (StringUtil.isEmpty(userCode)) {
			return "error";
		}
		User user = service.getUserByUserCode(userCode);
		if (user == null) {
			return "true";
		} else {
			return "false";
		}
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Model model) {
		// load userRole
		List<DataDictionary> dataList = dataService.getDataDictionaryList(
				"userRole", null);
		model.addAttribute("dataList", dataList);
		return "jsp/add/useradd";
	}
	/**
	 * 删除
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "del", method = RequestMethod.GET)
	@ResponseBody
	public boolean del(Model model,Integer id) {
		//店铺清除
		Shop shop = shopService.getShopById(null, id, null);
		if(shop!=null) {
			shopService.deleteById(shop.getId());
		}
		//删除订单
		List<Order> order = orderService.getOrderList(null, id, null, null, null, null, null, null, null, null, null, null, null, null) ;
		for (Order order2 : order) {
			orderService.deleteOrder(order2.getId());
		}
		//
		List<Address> address = addressService.getAddress(null, id, null, null); 
		for (Address address2 : address) {
			addressService.deleteAddress(address2.getId(), id);
		} 
		if(service.deleteUser(id)>0) {
			return true;
		}else {
			return false;
		}
	} 
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(@RequestParam(value = "id", required = true) Integer id,Model  model) {
		User user = service.getUserByUserId(id);
				
				// load userRole
		List<DataDictionary> dataList = dataService.getDataDictionaryList("userRole", null);
		model.addAttribute("user", user);
		model.addAttribute("dataList", dataList);
		model.addAttribute("action", "保存");
		return "jsp/add/useradd";
	}
	@RequestMapping(value = "registe", method = RequestMethod.POST)
	public String registe(
			String action,
			User user,
			Model model,
			HttpSession session,
			HttpServletRequest request,
			@RequestParam(value = "userImage", required = false) MultipartFile file) {
		log.debug("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		log.debug(user.getBirthday());
		log.debug(user.getUserCode());
		log.debug(user.getUserName());
		log.debug(user.getUserPassword());
		log.debug(user.getRealName());
		log.debug("======================getPhone" + user.getPhone());
		log.debug(user.getUserPassword());
		log.debug(file.getName() + "" + file.getOriginalFilename() + " ");
		//注册
		if("add".equals(action)) {
			int i;
			try {
				i = new SimpleDateFormat("yyyy-mm-dd").parse(user.getBirthday())
						.compareTo(new Date());
				log.debug(i);
				if (i > 0) {
					request.setAttribute("birthday", "出生日期输入时间错误");
					return "add/useradd";
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				request.setAttribute("birthday", "出生日期输入格式错误");
				return "add/useradd";
			}
			log.warn("================================upload file");
			if (!file.isEmpty()) {// 上传文件不为空
				try {
					String name = file.getOriginalFilename();
					String type = FilenameUtils.getExtension(name);// 文件类型
					int k = 500000;
					if (!Contains.IMG_TYPE.contains(type)) {
						request.setAttribute("file",
								"文件类型错误,文件类型后缀只能为(jpg;jpeg;png;)");
						model.addAttribute(user);
						return "add/useradd";
					}
					if (file.getSize() > k) {
						request.setAttribute("file", "文件大小超过限制（500KB）");
						model.addAttribute(user);
						return "jsp/add/useradd";
					}
					String path = request.getSession().getServletContext()
							.getRealPath("statics" + File.separator + "images");
					log.debug(path);

					File f = new File(path, user.getUserCode() + "." + type);
					if (!f.exists()) {
						f.mkdirs();
					}
					file.transferTo(f);
					user.setUserPic(user.getUserCode() + "." + type);
				} catch (Exception e) {
					request.setAttribute("file", "文件上传失败");
					model.addAttribute(user);
					return "jsp/add/useradd";
				}
			} else if (file.isEmpty()) {
				user.setUserPic("default.jpg");
			}

			user.setCreateTime(Contains.getDate());// new
													// SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new
													// Date()).toString()
			user.setCreateBy(((User) session.getAttribute(Contains.SESSION_USER))
					.getId());

			if (service.addUser(user)) {
				return "redirect:/user/userlist";
			} else {
				model.addAttribute(user);
				return "jsp/add/useradd";
			}
		}else { 
			
			if (service.upateUserInfo(user.getId(), user.getUserName(), user.getEmail(), user.getPhone(), user.getUserPassword(), null)>0) {
				return "redirect:/user/userlist";
			} else {
				model.addAttribute(user);
				return "redirect:/user/update?id="+user.getId();
			}
			
			
		}
		
	}

	// 登出
	@RequestMapping(value = "loginout")
	public String loginOut(HttpSession session) {
		User user = (User) session.getAttribute(Contains.SESSION_USER);
		if(user != null){
			service.updateUserLastLoginTime(user.getId(), Contains.getDate(), 0);
			session.removeAttribute(Contains.SESSION_USER);
		} 
		return "redirect:/login/login";
	}

	// 主页面跳转
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main() {

		return "jsp/index";
	}

}
