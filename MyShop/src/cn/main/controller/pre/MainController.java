package cn.main.controller.pre;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.main.pojo.Cart;
import cn.main.pojo.Category;
import cn.main.pojo.Good;
import cn.main.pojo.History;
import cn.main.pojo.Image;
import cn.main.pojo.Love;
import cn.main.pojo.News;
import cn.main.pojo.Shop;
import cn.main.pojo.User;
import cn.main.service.CategoryService;
import cn.main.service.GoodService;
import cn.main.service.ImageService;
import cn.main.service.NewsService;
import cn.main.service.ShopService;
import cn.main.service.cart.CartService;
import cn.main.service.history.HistoryService;
import cn.main.service.love.LoveService;
import cn.main.utils.Contains;
import cn.main.utils.Page;

@Controller
@RequestMapping("/pre")
public class MainController {
 
	@Resource
	private HistoryService historyService;//历史记录
	@Resource
	private LoveService loveService;//收藏
	@Resource
	private GoodService goodService;// 商品
	@Resource
	private ShopService shopService;// 商店
	@Resource
	private CategoryService categoryService;// 分类
	@Resource
	private NewsService newsService;// 新闻分类
	@Resource
	private ImageService imageService;// 图片集合
	@Resource
	private CartService cartService;
	private Logger logger = Logger.getLogger(getClass());

	@RequestMapping("index")
	public String index(Model model,HttpSession session,
			@RequestParam(value="cate",required=false)Integer cate,
			@RequestParam(value="name",required=false)String name, 
			@RequestParam(value="currentIndex",required=false)Integer currentIndex) {
		Page pages = new Page(8);// 分页 8 条
		logger.debug(">========cate========" + cate);
		logger.debug(">========name========" + name);
		logger.debug(">========currentIndex========" + currentIndex);
		// 前台请求页面信息，包含 标题分类信息 ，
		// title 获取所有一级分类、二级分类
		List<Category> cateList1 = categoryService.getCategory(null,null, null, 1);
		List<Category> cateList2 = categoryService.getCategory(null,null, null, 2);
		// 新闻集合
		List<News> newsList = newsService.getNewsList(null, null, null, null,
				0, 20);
		// 图片集合
		List<Image> imageList = imageService.getImageList(null, 1, null, null,
				0, 6);
		// 热销商品
		List<Good> goodList = goodService.getGoodList(null, null, null, null,null,
					null, 4, 0, 20);//state 4 已上架
		
		
		//猜你喜欢
		List<Good> likeList = goodService.getGoodList(null, null, name, cate,null,
				null, 4, 0, 20);//state 4 已上架 
		if (likeList.size() <= 20) {// 长度小于5,集合再次查询补充
			likeList.addAll(goodService.getGoodList(null, null, null, null,
					null, cate, null, 0, 20 - goodList.size()));
		}
		if (likeList.size() <= 20) {// 长度小于5,集合再次查询补充
			likeList.addAll(goodService.getGoodList(null, null, null, null,
					null, null, null, 0, 20 - goodList.size()));
		}
		
		
		//进口生鲜
		List<Good> goodList1 = goodService.getGoodList(null, null, null, 660, null, null,4, 0, 11);
		//化妆品
		List<Good> goodList2 = goodService.getGoodList(null, null, null, 548, null, null,4, 0, 11);
		//家用商品
		List<Good> goodList3 = goodService.getGoodList(null, null, null, 628, null, null,4, 0, 11); 
		//商品6数码
		List<Good> goodList4 = goodService.getGoodList(null, null, null, 670, null, null,4, 0, 11);

		
		//购物车
		if(session.getAttribute(Contains.SESSION_USER)!=null) {
			User user = (User) session.getAttribute(Contains.SESSION_USER);
			List<Cart> cartList = cartService.getList(null, user.getId(), null, null, null, null, null);
			
			if(cartList.size()!=0) {
				for (Cart cart : cartList) {
					cart.setGood(goodService.getGoodList(cart.getGid(), null, null, null, null, null, null, null, null).get(0));
				}
			} 
			model.addAttribute("cartList", cartList);
		} 
		model.addAttribute("cateList1", cateList1);
		model.addAttribute("cateList2", cateList2);
		model.addAttribute("newsList", newsList);
		model.addAttribute("imageList", imageList);
		model.addAttribute("goodList", goodList);
		
		System.out.println(">>>>>>>>>"+goodList3.size());
		model.addAttribute("goodList1", goodList1); 
		model.addAttribute("goodList2", goodList2); 
		model.addAttribute("goodList3", goodList3); 
		model.addAttribute("goodList4", goodList4);
		model.addAttribute("likeList", likeList); 
		model.addAttribute("name", name);
		 
		
		return "index";
	}

	// 前端ajax响应图片加载
	@RequestMapping(value = "imagelist")
	@ResponseBody
	public Object getInameList(Integer type, Integer sid) {
		logger.debug("" + type);
		logger.debug("" + sid);
		List<Image> imageList = imageService.getImageList(null, type, sid,
				null, 0, 5);
		return imageList;
	}

	@RequestMapping("goodinfo/{gid}/{sid}")
	public String good(@PathVariable(value = "gid") Integer gid,
			@PathVariable(value = "sid") Integer sid, Model model,HttpSession session) {

		logger.debug(">>>>>>>>>>>" + gid);
		logger.debug(">>>>>>>>>>>" + sid);
		// 前台请求页面信息，包含 标题分类信息 ，
		// title 获取所有一级分类、二级分类
		List<Category> cateList1 = categoryService.getCategory(null,null, null, 1);
		List<Category> cateList2 = categoryService.getCategory(null,null, null, 2);
		
		
		Good good = goodService.getGoodList(gid, sid, null, null, null, null,null, 0, 2).get(0);// 获取单个对象
		good.setImages(imageService.getImageList(null, 3, sid, null, 0, 5));// 获取商品图片集合
		good.setImagesDetail(imageService.getImageList(null, 4, sid, null, 0, 5));// 获取详情图片集合
		
		//当前分类名称
		Category c1 = categoryService.getCategory(good.getType1(), null, null, null).get(0);
		Category c2 = categoryService.getCategory(good.getType2(), null, null, null).get(0);
		//找相似
		List<Good> list= goodService.getGoodList(null, sid, null, c1.getId(), c2.getId(), null, null, 0, 5);
		
		//本店
		List<Good> goodList = goodService.getGoodList(null, sid, null, null, null, null, 4, 0, 5);
				
		//对应图片
		List<Image> imageList3 = imageService.getImageList(null, 3, good.getSid(), null, 0, 5);
		
		
		//对应图片详情
		List<Image> imageList4 = imageService.getImageList(null, 4, good.getSid(), null, 0, 5);
		//所属商店
		Shop shop = shopService.getShopById(sid,null, null);
		
		User user = (User) session.getAttribute(Contains.SESSION_USER);
		if(user!=null) {
			//是否收藏了
			List<Love> loveGood = loveService.getLoveList(null,user.getId() , gid, 1, null, null);
			if(loveGood.size()!=0) {
				model.addAttribute("loveGood", 0);
			}
			List<Love> loveShop = loveService.getLoveList(null,user.getId() , sid,2, null, null);
			if(loveShop.size()!=0) {
				model.addAttribute("loveShop", 0);
			}
			List<History> history = historyService.getHistoryList(null, user.getId(), gid, 1, null, null);
			logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>history"+history);
			if(history.size()==0) {
				History h = new History();
				h.setUid(user.getId());
				h.setSid(gid);
				h.setType(1);
				historyService.insertHistory(h); 
			}else {
				historyService.updateHistory(history.get(0).getId(), Contains.getDate());
			}
			
			List<Cart> cartList = cartService.getList(null, user.getId(), null, null, null, null, null);
			
			if(cartList.size()!=0) {
				for (Cart cart : cartList) {
					cart.setGood(goodService.getGoodList(cart.getGid(), null, null, null, null, null, null, null, null).get(0));
				}
			} 
			model.addAttribute("cartList", cartList);
		}		 
		 
		
		model.addAttribute("cateList1", cateList1);
		model.addAttribute("cateList2", cateList2);
		model.addAttribute("good", good);
		model.addAttribute("c1", c1);
		model.addAttribute("c2", c2);
		model.addAttribute("goods", list);
		model.addAttribute("goodList", goodList);
		model.addAttribute("shop", shop);
		model.addAttribute("imageList3", imageList3);

		model.addAttribute("imageList4", imageList4);
		
		return "goodinfo";
	}
	
	@RequestMapping("mytb")
	public String mytb(){ 
		return "order";
	}
	
	/**
	 * ajax实现分类三级联动
	 * @param parentId
	 * @param type
	 * @return
	 */
	@RequestMapping("/cate")
	@ResponseBody
	public Object getCateList(Integer parentId,Integer type){
		//二级分类
		List<Category> cList = categoryService.getCategory(null,null, parentId, type); 
		
		return cList;
	}


}
