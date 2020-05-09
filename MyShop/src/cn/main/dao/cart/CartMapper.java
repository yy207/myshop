package cn.main.dao.cart;
/**
 * 购物车数据方文成
 * @author sff
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.main.pojo.Cart;

public interface CartMapper {

	
	List<Cart> getList(@Param(value="id")Integer id,
			@Param(value="uid")Integer uid,
			@Param(value="gid")Integer gid,
			@Param(value="number")Integer number,
			@Param(value="price")Double price,
			@Param(value="from")Integer from,
			@Param(value="pageSize")Integer pageSize);
	
	int insertCart(@Param(value="cart")Cart cart);
	
	int deleteCart(@Param(value="id")Integer id);


}
