package cn.main.controller.pre.lock;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.main.pojo.Address;
import cn.main.pojo.User;
import cn.main.service.address.AddressService;
import cn.main.utils.Contains;

@Controller
@RequestMapping("pre/address")
public class AddressController {
	private Logger logger = Logger.getLogger(getClass());
	@Resource
	private AddressService addressService;
	
	@RequestMapping("add")
	public String add(Model model,Address address,HttpServletRequest request,HttpSession session,
			@RequestParam(value="default",required=false,defaultValue="false") Boolean def) {
		logger.debug(">>>>>>>>>>>>>>>>> id   "+address.getId());
		logger.debug(">>>>>>>>>>>>>>>>> address   "+address.getAddress());
		logger.debug(">>>>>>>>>>>>>>>>> phone   "+address.getPhone());
		logger.debug(">>>>>>>>>>>>>>>>> name   "+address.getName());
		logger.debug(">>>>>>>>>>>>>>>>> address.isDefault   "+address.getIsDefault());
		logger.debug(">>>>>>>>>>>>>>>>> isDefault   "+def);
		
		//会话用户
		User user = (User) session.getAttribute(Contains.SESSION_USER);
		//
		address.setUid(user.getId());
		
		if(def) {
			addressService.updateAddress(user.getId());
			address.setIsDefault(1);
		}else {
			address.setIsDefault(0);
		}
		if(address.getId()!=null) {
			if(addressService.updateAddressById(address)==0) {
				request.setAttribute("addressMsg", "* 地址修改失败!");
			}
		}else {
			if(addressService.addAddress(address)==0) {
				request.setAttribute("addressMsg", "* 地址添加失败!");
			}
		} 
		//重定向到地址页面
		return "redirect:/pre/nav/addresspage";
	}
	@RequestMapping("update/{id}")
	public String update(Model model,HttpServletRequest request,HttpSession session,
			@PathVariable(value="id")String id) {  
		//会话用户
		User user = (User) session.getAttribute(Contains.SESSION_USER);
		//根据用户id和地址id获取对象
		
		Integer aid =null;
		try {
			aid = Integer.parseInt(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Address address = addressService.getAddress(aid, user.getId(), null, null).get(0);

		logger.debug(">>>>>>>>>>>>>>>>> id   "+address.getId());
		logger.debug(">>>>>>>>>>>>>>>>> address   "+address.getAddress());
		logger.debug(">>>>>>>>>>>>>>>>> phone   "+address.getPhone());
		logger.debug(">>>>>>>>>>>>>>>>> name   "+address.getName());
		logger.debug(">>>>>>>>>>>>>>>>> address.isDefault   "+address.getIsDefault());
		//同时显示集合
		List<Address> addressList = addressService.getAddress(null, user.getId(), null, null);
		
		request.setAttribute("addressList", addressList);
		model.addAttribute("address", address);
		
		return "address";
	}
	@RequestMapping("default/{id}")
	public String add(HttpServletRequest request,HttpSession session,@PathVariable(value="id")String id) {
		//会话用户
		User user = (User) session.getAttribute(Contains.SESSION_USER);
		Integer aid =null;
		try {
			aid = Integer.parseInt(id);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		addressService.updateAddress(user.getId()
				);
		if(addressService.updateDefaultAddress(aid, user.getId())>0) {
			//重定向到地址页面
			return "redirect:/pre/nav/addresspage";
		}else {
			request.setAttribute("addressMsg", "* 操作失败！");
			return "address";
		}
		
	}
	@RequestMapping("delete/{id}")
	public String delete(HttpServletRequest request,HttpSession session,@PathVariable(value="id")String id) {
		//会话用户
		User user = (User) session.getAttribute(Contains.SESSION_USER);
		Integer aid =null;
		try {
			aid = Integer.parseInt(id);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		if(addressService.deleteAddress(aid, user.getId())>0) {
			//重定向到地址页面
			return "redirect:/pre/nav/addresspage";
		}else {
			request.setAttribute("addressMsg", "* 操作失败！");
			return "address";
		}
		
	}
}
