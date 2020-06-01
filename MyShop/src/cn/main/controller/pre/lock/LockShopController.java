package cn.main.controller.pre.lock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="pre/shop")
public class LockShopController {
	//首页
	@RequestMapping("index")
	public String index() {
		return "shopindex";
	}
	//开店
	@RequestMapping("shop")
	public String shop() {
		return "shop";
	}
	//发货
	@RequestMapping("sendshop")
	public String sendshop() {
		return "sendshop";
	}
	
}
