package cn.main.controller.pre.lock;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.main.pojo.User;
import cn.main.service.UserService;
import cn.main.utils.Contains;

/**
 * 用户信息维护
 * @author sff
 *
 */

@Controller
@RequestMapping("pre/user")
public class LockUserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="userName",method=RequestMethod.POST)
	public String userName(HttpServletRequest request,HttpSession session  ,
			@RequestParam(required=true,value="userName")String userName) {
		User user = (User) session.getAttribute(Contains.SESSION_USER);//获取当前用户
		if(userName!=null && userName.length()>0) {
			if(userService.upateUserInfo(user.getId(), userName , null, null, null, null)==0) {
				request.setAttribute("userNameMsg", "* 昵称修改失败!");
			}else {
				session.setAttribute(Contains.SESSION_USER, userService.getUserByUserCode(user.getUserCode()));
			}
		} else {
			request.setAttribute("userNameMsg", "* 请输入正确的昵称!");
		} 
		return "account";
	}
	@RequestMapping(value="pwd",method=RequestMethod.POST)
	public String pwd(HttpServletRequest request,HttpSession session   ,
			@RequestParam(required=true,value="userPassword")String userPassword) {
		User user = (User) session.getAttribute(Contains.SESSION_USER);//获取当前用户
		if(userPassword!=null && userPassword.length()>0) {
			if(userService.upateUserInfo(user.getId(), null, null, null, userPassword, null)==0) {
				request.setAttribute("userPasswordMsg", "* 密码修改失败!");
			}else {
				session.setAttribute(Contains.SESSION_USER, userService.getUserByUserCode(user.getUserCode()));
			}
		} else {
			request.setAttribute("userPasswordMsg", "* 请输入正确的密码!");
		} 
		return "account";
	}
	@RequestMapping(value="email",method=RequestMethod.POST)
	public String email(HttpServletRequest request,HttpSession session  ,
			@RequestParam(required=true,value="email")String email) {
		User user = (User) session.getAttribute(Contains.SESSION_USER);//获取当前用户
		if(email!=null && email.length()>0) {
			if(userService.upateUserInfo(user.getId(), null, email, null, null, null)==0) {
				request.setAttribute("emailMsg", "* 邮箱修改失败!");
			}else {
				session.setAttribute(Contains.SESSION_USER, userService.getUserByUserCode(user.getUserCode()));
			}
		} else {
			request.setAttribute("emailMsg", "* 请检查输入的邮箱格式是否正确!");
		}
		return "account";
	}
	@RequestMapping(value="phone",method=RequestMethod.POST)
	public String phone(HttpServletRequest request ,HttpSession session ,
			@RequestParam(required=true,value="phone")String phone) {
		User user = (User) session.getAttribute(Contains.SESSION_USER);//获取当前用户
		if(phone!=null && phone.length()>0) {
			if(userService.upateUserInfo(user.getId(), null, null, phone, null, null)==0) {
				request.setAttribute("phoneMsg", "* 手机号码修改失败!");
			}else {
				session.setAttribute(Contains.SESSION_USER, userService.getUserByUserCode(user.getUserCode()));
			}
		} else {
			request.setAttribute("phoneMsg", "* 手机号码输入不正确!");
		}
		return "account";
	}
	@RequestMapping(value="image",method=RequestMethod.POST)
	public String image(HttpServletRequest request,HttpSession session , 
			@RequestParam(value = "userImage", required = false) MultipartFile file) {
			User user = (User) session.getAttribute(Contains.SESSION_USER);//获取当前用户
		
		if (!file.isEmpty()) {// 上传文件不为空
			try {
				String name = file.getOriginalFilename();
				String type = FilenameUtils.getExtension(name);// 文件类型
				int k = 500000;
				if (!Contains.IMG_TYPE.contains(type)) {
					request.setAttribute("imageMsg",
							"* 文件类型错误,文件类型后缀只能为(jpg;jpeg;png;)!");  
					return "account";
				}
				if (file.getSize() > k) {
					request.setAttribute("imageMsg", "*  文件大小超过限制（500KB）!");  
					return "account";
				}
				String path = request.getSession().getServletContext()
						.getRealPath("static" + File.separator + "img");
				File f = new File(path, user.getUserCode() + "." + type);
				if (!f.exists()) {
					f.mkdirs();
				}
				file.transferTo(f);
				user.setUserPic(user.getUserCode() + "." + type);
				if(userService.upateUserInfo(user.getId(), null, null, null, null,user.getUserPic())==0) {
					request.setAttribute("imageMsg", "* 用户头像修改失败!");
				}
				
			} catch (Exception e) {
				request.setAttribute("imageMsg", "* 文件上传失败!");
			} 
		} else{
			request.setAttribute("imageMsg", "* 上传文件为空,无法修改!");
		} 
		return "account";
	}
	
}
