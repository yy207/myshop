package cn.main.controller.backed;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.ResponseBody;

import cn.main.utils.Contains;
import cn.main.utils.ImageCode;

@Controller
@RequestMapping(value = "/image")
public class ImageController {	 
	//生成验证码图片
		@RequestMapping("/image.do") //对应/user/valicode.do请求
		@ResponseBody
		public void valicode(HttpServletResponse response,HttpSession session) throws Exception{
			System.out.println(">>>>>>>>>>>>>>>>>"+session.getCreationTime());
			//利用图片工具生成图片
			//第一个参数是生成的验证码，第二个参数是生成的图片
			Object[] objs = ImageCode.createImage();
			//将验证码存入Session
			session.removeAttribute(Contains.IMAGECODE);
			session.setAttribute(Contains.IMAGECODE,objs[0]);
			//将图片输出给浏览器
			BufferedImage image = (BufferedImage) objs[1];
			response.setContentType("image/png");
			OutputStream os = response.getOutputStream();
			ImageIO.write(image, "png", os);
		}
}
