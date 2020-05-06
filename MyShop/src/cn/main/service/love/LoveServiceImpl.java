package cn.main.service.love;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.main.dao.love.LoveMapper;
import cn.main.pojo.Love;
@Service
public class LoveServiceImpl implements LoveService {

	@Resource
	private LoveMapper loveMapper;
	
	@Override
	public List<Love> getLoveList(Integer id, Integer uid, Integer sid, Integer type, Integer from, Integer pageSize) {
		// TODO Auto-generated method stub
		return loveMapper.getLoveList(id, uid, sid, type, from, pageSize);
	}
	@Override
	public int insertLove(Love love) {
		// TODO Auto-generated method stub
		return loveMapper.insertLove(love);
	}
	@Override
	public int deleteLove(Integer id) {
		// TODO Auto-generated method stub
		return loveMapper.deleteLove(id);
	}

}
