package cn.main.service;

import java.net.Inet4Address;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.main.pojo.Category;

public interface CategoryService {
	public List<Category> getCategory(@Param(value="id")Integer id,@Param(value="name")String name,
			@Param(value="parentId")Integer parentId,
			@Param(value="type")Integer type); 
}
