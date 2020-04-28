package cn.main.dao.orderdetails;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.beust.jcommander.Parameter;

import cn.main.pojo.OrderDetails;

/**
 * 订单详情
 * @author sff
 *
 */
public interface OrderDetailsMapper {
	
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
