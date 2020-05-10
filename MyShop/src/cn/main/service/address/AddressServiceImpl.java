package cn.main.service.address;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.main.dao.address.AddressMapper;
import cn.main.dao.city.CityMapper;
import cn.main.pojo.Address;
import cn.main.pojo.City;
@Service
public class AddressServiceImpl implements AddressService {

	@Resource
	private AddressMapper mapper;
	@Resource
	private CityMapper cityMapper;
	
	@Override
	public List<Address> getAddress(Integer id, Integer uid, Integer from,
			Integer pageSize) {
		List<Address> list = mapper.getAddress(id, uid, from, pageSize);
		if(list.size()>0) {
			for (Address address : list) {
				address.setC1(cityMapper.getCityList(address.getCity1(), null, null, null).get(0));
				address.setC2(cityMapper.getCityList(address.getCity2(), null, null, null).get(0));
				address.setC3(cityMapper.getCityList(address.getCity3(), null, null, null).get(0));
			}
		} 
		return list;
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
