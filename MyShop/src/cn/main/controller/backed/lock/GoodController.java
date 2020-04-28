package cn.main.controller.backed.lock;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder.In;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.main.pojo.Good;
import cn.main.service.GoodService; 
import cn.main.utils.Page;

@Controller
@RequestMapping("/good")
public class GoodController {
	@Resource
	private GoodService goodService ;
	
	private Logger logger = Logger.getLogger(getClass());
	
	@RequestMapping(value="goodlist")
	public String goodList(Model model,Integer sid
			,String name,Integer currentIndex,Integer pageSize){
		logger.debug("==============sid		"+sid);
		logger.debug("==============name	"+name);
		logger.debug("==============currentIndex	"+currentIndex); 
		
//		Page<List<Good>> pages = new Page<List<Good>>();
		if (currentIndex==null) {
			currentIndex = 1;
		}
		
		Page pages = new Page();
		pages.setPageSize(pageSize==null?10:pageSize);
		//数据
		List<Good> goodList = 
				goodService.getGoodList(null, sid, name, null, null, null, null, (currentIndex-1)*pages.getPageSize(), pages.getPageSize());
		
		
		pages.setCurrentIndex(currentIndex);
		pages.setTotalCount(goodService.getGoodCount(sid, name)); //计总数
		
		
		model.addAttribute("goodList",goodList);
		model.addAttribute("sid", sid);
		model.addAttribute("name", name);
		model.addAttribute("currentIndex",currentIndex);
		model.addAttribute("pages", pages);
		if(goodList.size()<=0){
			model.addAttribute("msg", "当前条件下暂无记录！");
		}
		return "list/goodList";
	}
	
	
	
	
}
