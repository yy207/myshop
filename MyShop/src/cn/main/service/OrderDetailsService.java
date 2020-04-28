package cn.main.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.main.pojo.OrderDetails;

public interface OrderDetailsService {

	List<OrderDetails> getOrderDetailsList(@Param(value="id") Integer id,
								@Param(value="oid") Integer oid,
								@Param(value="sid") Integer sid,
								@Param(value="gid") Integer gid,
								@Param(value="number") Integer number,
								@Param(value="price") Double price,
								@Param(value="from")Integer from,
								@Param(value="pageSize")Integer pageSize);
	
	//添加详细记录
	int addOrderDatils(@Param(value="details")OrderDetails details);
	
}
