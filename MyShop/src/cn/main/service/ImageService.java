package cn.main.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.main.pojo.Image;

public interface ImageService {
	//获取所有记录
		public List<Image> getImageList(@Param(value="id")Integer id,
									@Param(value="type")Integer type,
									@Param(value="sid") Integer sid,
									@Param(value="createTime")String createTime,
									@Param(value="from")Integer from,
									@Param(value="pageSize")Integer pageSize);
		//记录数		
		public Integer getListCount(@Param(value="id")Integer id,
									@Param(value="type")Integer type,
									@Param(value="sid") Integer sid,
									@Param(value="createTime")String createTime);
}
