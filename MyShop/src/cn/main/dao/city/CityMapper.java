package cn.main.dao.city;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.main.pojo.City;

public interface CityMapper {
	List<City> getCityList(@Param(value="id")Integer id,
			@Param(value="pid")Integer pid,
			@Param(value="cityName")String cityName,
			@Param(value="type")Integer type);
	
	
}
