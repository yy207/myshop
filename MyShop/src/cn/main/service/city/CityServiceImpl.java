package cn.main.service.city;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.main.dao.city.CityMapper;
import cn.main.pojo.City;
@Service
public class CityServiceImpl implements CityService {
	@Resource
	private CityMapper cityMapper;
	
	@Override
	public List<City> getCityList(Integer id, Integer pid, String cityName, Integer type) {
		// TODO Auto-generated method stub
		return cityMapper.getCityList(id, pid, cityName, type);
	}

}
