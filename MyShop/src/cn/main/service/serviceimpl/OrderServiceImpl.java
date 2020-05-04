package cn.main.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.main.dao.good.GoodMapper;
import cn.main.dao.order.OrderMapper;
import cn.main.dao.shop.ShopMapper;
import cn.main.pojo.Order;
import cn.main.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private GoodMapper goodMapper;
	
	@Resource
	private ShopMapper shopMapper;
	
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

	@Override
	public List<Order> getOrderList(Integer id, Integer uid, Integer sid, Integer gid, Integer number, String orderCode,String alipayCode,
			String createTime, String endTime, Double price, Integer state, String logidtics, Integer from,
			Integer pageSize) {
		List<Order> list =orderMapper.getOrderList(id, uid, sid, gid, number, orderCode, alipayCode, createTime, endTime, price, state, logidtics, from, pageSize);
		for (Order order : list) {
			System.out.println(">>>>>>>>sid   "+order.getSid());
			System.out.println(">>>>>>>>gid   "+order.getGid());
			if(order.getShop()==null) {
				order.setShop(shopMapper.getShopById(order.getSid(), null, null));
			}
			if(order.getGood()==null) {
				order.setGood(goodMapper.getGoodList(order.getGid(),null , null, null, null, null, null, null, null).get(0));
			}
		}  
		return  list;
	}

	@Override
	public int updateOrderAll(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.updateOrderAll(order);
	}

	@Override
	public int deleteOrder(Integer id) {
		// TODO Auto-generated method stub
		return orderMapper.deleteOrder(id);
	}

	 

}
