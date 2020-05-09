package cn.main.service.cart;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.main.dao.cart.CartMapper;
import cn.main.pojo.Cart;
@Service
public class CartServiceImpl implements CartService {

	@Resource
	private CartMapper cartMapper;
	
	@Override
	public List<Cart> getList(Integer id, Integer uid, Integer gid, Integer number, Double price, Integer from,
			Integer pageSize) {
		// TODO Auto-generated method stub
		return cartMapper.getList(id, uid, gid, number, price, from, pageSize);
	}

	@Override
	public int insertCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartMapper.insertCart(cart);
	}

	@Override
	public int deleteCart(Integer id) {
		// TODO Auto-generated method stub
		return cartMapper.deleteCart(id);
	}

}
