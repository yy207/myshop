package cn.main.controller.backed.lock;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 

import cn.main.pojo.Category;
import cn.main.pojo.Shop;
import cn.main.pojo.User;
import cn.main.service.CategoryService;
import cn.main.service.ShopService;
import cn.main.utils.Contains;
import cn.main.utils.Page;
import cn.main.utils.StringUtil;

@Controller
@RequestMapping("/shop")
public class ShopListController { 
	@Resource 
	private ShopService shopService ;
	@Resource
	private CategoryService categoryService;
	
	private Logger logger = Logger.getLogger(getClass());
	
	@RequestMapping("/shoplist")
	public String shopList(Model model,String shopName,String currentIndex,Integer pageSize){
		//鏉′欢杞寲 
		
		Integer index = 1;
		if(currentIndex!=null&&currentIndex!=""){
			index = Integer.parseInt(currentIndex);
		}
		logger.debug(">>>>>>currentIndex"+currentIndex);
		logger.debug(">>>>>>index"+index);
		//灏佽鍒伴〉
				Page pages = new Page();
				pages.setPageSize(pageSize==null?10:pageSize);
		//鑾峰彇鍒伴泦鍚堝璞�
		List<Shop> shopList = shopService.getShopList(null, null, shopName, null, 
					null, null, null, null, null, null, null, null, null, (index-1)* pages.getPageSize(), pages.getPageSize())	;
		
		for (Shop shop : shopList) {
			logger.debug(">>>>>>"+shop.getId()+"     "+shop.getName()); 
		}  
		
		pages.setCurrentIndex(index);
		pages.setTotalCount(shopService.getShopCount(shopName));
		//灏嗘暟鎹瓨鍒癿odel 
		model.addAttribute("shopName",shopName);//鏌ヨ鏉′欢鍚嶇О
		model.addAttribute("shopList", shopList);//缁撴灉闆� 
		model.addAttribute("pages", pages);
		if(shopList.size()<=0){
			model.addAttribute("msg", "褰撳墠鏉′欢涓嬫殏鏃犺褰曪紒");
		}
		return "list/shopList";
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public String shopAdd(Model model,Shop shop,HttpServletRequest  request){
		User user = ((User)request.getSession().getAttribute(Contains.SESSION_USER));
		shop.setUid(user.getId());
		logger.debug(">>>>>>>>>>>>>>date:  "+Contains.getDate());
		logger.debug(">>>>>>>>>>>>>>uid:  "+user.getId());
		shop.setCreateTime(Contains.getDate()); 
		
		if(shopService.getShopList(null, user.getId(), null, null, null, null, null, null, null, null, null, null, null, 0, 5).size()==0){
			if(shopService.addByShop(shop)>0){
				return "redirect:/shop/shoplist";
			}else{
				model.addAttribute("msg", "* 鍟嗗簵淇℃伅瑷诲唺澶辨晽锛�");}
		} else{
			model.addAttribute("msg", "* 鎮ㄥ凡鏈夊簵閶紝涓嶅彲浠ラ噸瑜囪ɑ鍐婏紒");
		}
		
		model.addAttribute("shop", shop);
		
		return "add/shopadd";
		 
		//logger.debug(">>>>>>>>>"+shop.getName()+""+shop.getAddress());
	}
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String shopAdd(Model model){
		//涓�绾у垎绫�
		List<Category> cList1 = categoryService.getCategory(null,null, 0, 1);
		//浜岀骇鍒嗙被
		List<Category> cList2 = categoryService.getCategory(null,null, null, 2);
		//涓夌骇鍒嗙被
		List<Category> cList3 = categoryService.getCategory(null,null, null, 3);
		
		
		model.addAttribute("cate1", cList1);
		model.addAttribute("cate2", cList2);
		model.addAttribute("cate3", cList3); 
		return "add/shopadd";
	}
	/**
	 * ajax瀹炵幇鍒嗙被涓夌骇鑱斿姩
	 * @param parentId
	 * @param type
	 * @return
	 */
	@RequestMapping("/cate")
	@ResponseBody
	public Object getCateList(Integer parentId,Integer type){
		//浜岀骇鍒嗙被
		List<Category> cList = categoryService.getCategory(null,null, parentId, type); 
		
		return cList;
	}
	/**
	 * 鍔ㄦ�侀獙璇佸瓨鍦�
	 * @param name
	 * @return
	 */
	@RequestMapping("/shopname")
	@ResponseBody
	public Object getShopName(String name){
		if(StringUtil.isEmpty(name)){
			return "error";
		}
		List<Shop> list = shopService.getShopByName(name);
		return list.size()<1;
	}
	
	
	
}
