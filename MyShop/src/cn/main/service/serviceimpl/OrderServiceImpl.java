package cn.main.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.main.dao.order.OrderMapper;
import cn.main.pojo.Order;
import cn.main.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderMapper orderMapper;
	
	@Override
	public List<Order> getOrderList(Integer id, Integer uid, String orderCode,
			String createTime, String endTime, Double price, Integer state,
			String logidtics, Integer from, Integer pageSize) {
		// TODO Auto-generated method stub
		return orderMapper.getOrderList(id, uid, orderCode, createTime, endTime, price, state, logidtics, from, pageSize);
	}

	@Override
	public int addOrder(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.addOrder(order);
	}

	@Override
	public int updateOrder(String orderCode, Integer state) {
		// TODO Auto-generated method stub
		return orderMapper.updateOrder(orderCode, state);
	}

}
