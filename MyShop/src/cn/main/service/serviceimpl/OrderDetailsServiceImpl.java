package cn.main.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.main.dao.orderdetails.OrderDetailsMapper;
import cn.main.pojo.OrderDetails;
import cn.main.service.OrderDetailsService;
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
	@Resource
	private OrderDetailsMapper orderDetailsMapper;
	
	@Override
	public List<OrderDetails> getOrderDetailsList(Integer id, Integer oid,Integer sid,
			Integer gid, Integer number, Double price, Integer from,
			Integer pageSize) {
		// TODO Auto-generated method stub
		return orderDetailsMapper.getOrderDetailsList(id, oid, sid,gid, number, price, from, pageSize);
	}

	@Override
	public int addOrderDatils(OrderDetails details) {
		// TODO Auto-generated method stub
		return orderDetailsMapper.addOrderDatils(details);
	}

}
