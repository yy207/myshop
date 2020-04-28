package cn.main.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.main.dao.category.CategoryMapper;
import cn.main.pojo.Category;
import cn.main.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {

	@Resource
	private CategoryMapper mapper;
	
	@Override
	public List<Category> getCategory(Integer id,String name, Integer parentId,
			Integer type) { 
		return mapper.getCategory(id,name, parentId, type);
	}
	
}
