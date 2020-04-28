package cn.main.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.main.dao.shop.ShopMapper;
import cn.main.pojo.Shop;
import cn.main.service.ShopService;
@Service
public class ShopServiceImpl implements ShopService {
	@Resource
	private ShopMapper mapper  ;
	@Override
	public Shop getShopById(Integer id,Integer uid,String name) {
		// TODO Auto-generated method stub
		return mapper.getShopById(id,uid,name);
	}
	@Override
	public List<Shop> getShopByName(String name) {
		// TODO Auto-generated method stub
		return mapper.getShopByName(name);
	}
	@Override
	public List<Shop> getShopList(Integer id, Integer uid, String name,
			String describe, String address, String picPath, Integer liker,
			Integer level, Integer type1, Integer type2, Integer type3,
			Integer state, String createTime, Integer from, Integer pageSize) {
		// TODO Auto-generated method stub
		return mapper.getShopList(id, uid, name, describe, address, picPath, liker, level, type1, type2, type3, state, createTime, from, pageSize);
	}

	@Override
	public int modifyByShop(Shop shop) {
		// TODO Auto-generated method stub
		return mapper.modifyByShop(shop);
	}

	@Override
	public int addByShop(Shop shop) {
		// TODO Auto-generated method stub
		return mapper.addByShop(shop);
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteById(id);
	}
	@Override
	public int getShopCount(String name) {
		// TODO Auto-generated method stub
		return mapper.getShopCount(name);
	}

	

}
