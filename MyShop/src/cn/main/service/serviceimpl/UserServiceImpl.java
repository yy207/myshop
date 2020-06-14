package cn.main.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.main.dao.shop.ShopMapper;
import cn.main.dao.user.UserMapper;
import cn.main.pojo.Shop;
import cn.main.pojo.User;
import cn.main.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper mapper;
	@Resource
	private ShopMapper shopMapper;

	@Override
	public User getUserByUserCode(String userCode) {
		User user =mapper.getUserByUserCode(userCode);
		if(user!=null) {
			user.setShop( shopMapper.getShopById(null,user.getId(), null));
		}
		return user;
	}
	@Override
	public int getAllUserCount(String userCode, String userName,
			Integer userRole, String idCard, String address, String realName,
			String sex, String email, String phone, String birthday,
			Integer loginState) {
		// TODO Auto-generated method stub
		return mapper.getAllUserCount(userCode, userName, userRole, idCard, address, realName, sex, email, phone, birthday, loginState);
	}
	@Override
	public List<User> getAllUser(String userCode, String userName,
			Integer userRole, String idCard, String address, String realName,
			String sex, String email, String phone, String birthday,
			Integer loginState, Integer currentIndex, Integer pageSize) {
		return mapper.getAllUser(userCode, userName, userRole, idCard, address, realName, sex, email, phone, birthday, loginState, currentIndex, pageSize);
	}

	@Override
	public boolean addUser(User user) {
		
		return mapper.addUser(user)>0;
	}
	@Override
	public boolean updateUserLastLoginTime(int id, String date, Integer loginState) {
		// TODO Auto-generated method stub
		return mapper.updateUserLastLoginTime(id, date, loginState)>0;
	}
	
	@Override
	public int upateUserInfo(int id, String userName, String email, String phone, String userPassword, String userPic,String sex) {
		// TODO Auto-generated method stub
		return mapper.upateUserInfo(id, userName, email, phone, userPassword, userPic,sex);
	}
	@Override
	public User getUserByUserId(Integer Id) {
		// TODO Auto-generated method stub
		return mapper.getUserByUserId(Id);
	}
	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return mapper.deleteUser(id);
	}

	
	
	
	
	
	
}
