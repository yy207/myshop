package cn.main.dao.category;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.main.pojo.Category;

public interface CategoryMapper {
	public List<Category> getCategory(
								@Param(value="id")Integer id,
								@Param(value="name")String name,
								@Param(value="parentId")Integer parentId,
								@Param(value="type")Integer type); 
	
	
}
