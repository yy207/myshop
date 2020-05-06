package cn.main.controller.pre.lock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="pre/shop")
public class LockShopController {

	@RequestMapping("index")
	public String index() {
		return "shopindex";
	}
	
	
	
}
