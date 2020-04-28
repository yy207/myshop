package cn.main.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.main.pojo.News;

public interface NewsService {
	//查询集合
		public List<News> getNewsList(@Param(value="id")Integer id,@Param(value="sid")Integer sid,
									@Param(value="type")Integer type,
									@Param(value="content")String content,
									@Param(value="from")Integer from,
									@Param(value="pageSize")Integer pageSize);
		//记录数
		public int getCount(@Param(value="sid")Integer sid,
				@Param(value="type")Integer type,
				@Param(value="content")String content);
		//添加一条
		public int addNews(@Param(value="news")News news);
		
		//删除一条
		public int deleteNews(@Param(value="id")Integer id);
		
		
}
