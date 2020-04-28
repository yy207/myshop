package cn.main.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.main.pojo.Shop;

public interface ShopService {
	//根据ID获取商店
		public Shop getShopById(Integer id,Integer uid,String name);
		//根据Name
		public List<Shop> getShopByName(@Param("name")String name); 
		//个数
		public int getShopCount(String name);
		//根据条件获取商店集合
		public List<Shop> getShopList( Integer id, Integer uid, String name, 
										String describe, String address, String picPath,
										Integer liker, Integer level, Integer type1,
										Integer type2, Integer type3, Integer state, 
										String createTime,  Integer from, Integer pageSize);
		//修改
		public int modifyByShop(@Param(value="shop")Shop shop);
		//新增
		public int addByShop(@Param(value="shop")Shop shop);
		//删除
		public int deleteById(@Param(value="id")Integer id);
		
}
