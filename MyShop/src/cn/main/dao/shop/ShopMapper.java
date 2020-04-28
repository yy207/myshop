package cn.main.dao.shop;
 

import java.util.List;

import org.apache.ibatis.annotations.Param; 

import cn.main.pojo.Shop;

/**
 * 商店接口
 * @author sff
 *
 */
public interface ShopMapper {
	
	//根据ID获取商店
	public Shop getShopById(@Param(value="id") Integer id,@Param("uid")Integer uid,@Param("name")String name); 
	//根据name获取商店
	public List<Shop> getShopByName(@Param("name")String name); 
	//个数
	public int getShopCount(@Param("name")String name);
	//根据条件获取商店集合
	public List<Shop> getShopList(@Param(value="id")Integer id,
								  @Param(value="uid")Integer uid,
								  @Param(value="name")String name,
								  @Param(value="describe")String describe,
								  @Param(value="address")String address,
								  @Param(value="picPath")String picPath,
								  @Param(value="liker")Integer liker,
								  @Param(value="level")Integer level,
								  @Param(value="type1")Integer type1,
								  @Param(value="type2")Integer type2,
								  @Param(value="type3")Integer type3,
								  @Param(value="state")Integer state,
								  @Param(value="createTime")String createTime,
								  @Param(value="from")Integer from,
								  @Param(value="pageSize")Integer pageSize
								  );
	//修改
	public int modifyByShop(@Param(value="shop")Shop shop);
	//新增
	public int addByShop(@Param(value="shop")Shop shop);
	//删除
	public int deleteById(@Param(value="id")Integer id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
