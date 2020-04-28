package cn.main.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.main.dao.good.GoodMapper;
import cn.main.pojo.Good;

public interface GoodService {

	public List<Good> getGoodList(@Param(value="id") Integer id,
			@Param(value="sid")Integer sid,
			@Param(value="name")String name,
			@Param(value="type1")Integer type1,
			@Param(value="type2")Integer type2,
			@Param(value="type3")Integer type3,
			@Param(value="state")Integer state,
			@Param(value="from")Integer from,
			@Param(value="size")Integer size
			);
	//根据条件查询记录数
	public int getGoodCount(@Param(value="sid")Integer sid,@Param(value="name")String name);
	//添加对象
	public int addGood(@Param(value="good")Good good);
	//修改状态
}
