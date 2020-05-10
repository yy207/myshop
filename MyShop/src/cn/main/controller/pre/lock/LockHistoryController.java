package cn.main.controller.pre.lock;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.main.pojo.History;
import cn.main.pojo.User;
import cn.main.service.GoodService;
import cn.main.service.history.HistoryService;
import cn.main.utils.Contains;
/**
 * 历史记录
 * @author sff
 *
 */
@Controller
@RequestMapping("pre/history")
public class LockHistoryController {
	
	@Resource
	private HistoryService historyService;
	@Resource 
	private GoodService goodService;
	
	@RequestMapping("historypage")
	public String historypage(HttpSession session,HttpServletRequest request) {
		User user = (User) session.getAttribute(Contains.SESSION_USER);
		 
		List<History> historyList = historyService.getHistoryList(null, user.getId(), null, null, null, null);
		if(historyList.size()!=0) {
			for (History history : historyList) {
				history.setGood(goodService.getGoodList(history.getSid(), null, null, null, null, null, null, null, null).get(0));
			}
		} 
		request.setAttribute("historyList", historyList);
		return "history";
	}
	@RequestMapping("deletehistory/{id}")
	public String delete(HttpSession session,HttpServletRequest request,@PathVariable(value="id")Integer id) {
		historyService.deleteHistory(id); 
		return "redirect:/pre/history/historypage";
	}
	
	@RequestMapping("deleteall")
	@ResponseBody
	public String deleteall(HttpSession session,HttpServletRequest request) {
		User user = (User) session.getAttribute(Contains.SESSION_USER);
		if(historyService.deleteHistoryByUid(user.getId())>0) {
			return "true";
		}else {
			return "false";
		}
	}
	
}
