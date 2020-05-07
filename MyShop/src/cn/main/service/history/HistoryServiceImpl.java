package cn.main.service.history;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.main.dao.history.HistoryMapper;
import cn.main.pojo.History;
@Service
public class HistoryServiceImpl implements HistoryService {
	@Resource
	private HistoryMapper historyMapper;
	
	@Override
	public List<History> getHistoryList(Integer id, Integer uid, Integer sid, Integer type, Integer from,
			Integer pageSize) {
		// TODO Auto-generated method stub
		return historyMapper.getHistoryList(id, uid, sid, type, from, pageSize);
	} 
	@Override
	public int insertHistory(History history) {
		// TODO Auto-generated method stub
		return historyMapper.insertHistory(history);
	} 
	@Override
	public int deleteHistory(Integer id) {
		// TODO Auto-generated method stub
		return historyMapper.deleteHistory(id);
	} 
}
