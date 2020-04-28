package cn.main.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.main.dao.good.GoodMapper;
import cn.main.dao.shop.ShopMapper;
import cn.main.pojo.Good;
import cn.main.service.GoodService;
@Service
public class GoodServiceImpl implements GoodService {

	@Resource
	private GoodMapper mapper;
	@Resource 
	private ShopMapper shopMapper;
	
	@Override
	public List<Good> getGoodList(Integer id, Integer sid, String name,
			Integer type1, Integer type2, Integer type3, Integer state,
			Integer from, Integer size) {
		// TODO Auto-generated method stub
		List<Good> list = mapper.getGoodList(id, sid, name, type1, type2, type3, state, from, size);
		if (list.size()>0) {
			for (Good good : list) {
				good.setShop(shopMapper.getShopList(good.getSid(), null, null, null, null,
								null, null, null, null, null, null, null, null, 0, 5).get(0));
			}
		}
		return list;
	}

	@Override
	public int getGoodCount(Integer sid,String name) {
		// TODO Auto-generated method stub
		return mapper.getGoodCount(sid,name);
	}

	@Override
	public int addGood(Good good) {
		// TODO Auto-generated method stub
		return mapper.addGood(good);
	}

}
