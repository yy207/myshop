package cn.main.dao.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.main.pojo.Order;

/**
 * 订单
 * @author sff
 *
 */
public interface OrderMapper {
	//按条件获取
	List<Order> getOrderList(@Param(value="id") Integer id,
						@Param(value="uid") Integer uid,
						@Param(value="sid") Integer sid,
						@Param(value="gid") Integer gid,
						@Param(value="number") Integer number,
						@Param(value="orderCode") String orderCode,
						@Param(value="alipayCode") String alipayCode,
						@Param(value="createTime") String createTime,
						@Param(value="end") String endTime,
						@Param(value="price") Double price,
						@Param(value="state") Integer state,
						@Param(value="logidtics") String logidtics,
						@Param(value="from")Integer from,
						@Param(value="pageSize")Integer pageSize);
	
	//添加一条记录
	int addOrder(@Param(value="order")Order order);
	
	//更新记录  
	int updateOrder(  
			@Param(value="orderCode") String orderCode,  
			@Param(value="state") Integer state );
	
		//更新记录  
		int updateOrderById(  
				@Param(value="id") Integer id,@Param(value="logidtics") String logidtics, 
				@Param(value="state") Integer state );
	//更新记录  
	int updateOrderAll(@Param(value="order")Order order);
	
	
	
	//删除记录  
	int deleteOrder(@Param(value="id") Integer id);
		
	
	
	
	
	
}
