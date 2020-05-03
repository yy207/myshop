package cn.main.service.address;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.main.dao.address.AddressMapper;
import cn.main.pojo.Address;
@Service
public class AddressServiceImpl implements AddressService {

	@Resource
	private AddressMapper mapper;
	
	
	@Override
	public List<Address> getAddress(Integer id, Integer uid, Integer from,
			Integer pageSize) {
		// TODO Auto-generated method stub
		return mapper.getAddress(id, uid, from, pageSize);
	}

	@Override
	public Address getAddressByDefault(Integer uid) {
		// TODO Auto-generated method stub
		return mapper.getAddressByDefault(uid);
	}

	@Override
	public int deleteAddress(Integer id, Integer uid) {
		// TODO Auto-generated method stub
		return mapper.deleteAddress(id, uid);
	}

	@Override
	public int addAddress(Address address) {
		// TODO Auto-generated method stub
		return mapper.addAddress(address);
	}

	@Override
	public int updateDefaultAddress(Integer id, Integer uid) {
		// TODO Auto-generated method stub
		return mapper.updateDefaultAddress(id, uid);
	}

	@Override
	public int updateAddress(Integer uid) {
		// TODO Auto-generated method stub
		return mapper.updateAddress(uid);
	}

	@Override
	public int updateAddressById(Address address) {
		// TODO Auto-generated method stub
		return mapper.updateAddressById(address);
	}

}
