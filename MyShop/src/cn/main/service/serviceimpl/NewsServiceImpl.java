package cn.main.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import cn.main.dao.datadictionary.DataDictionaryMapper;
import cn.main.dao.news.NewsMapper;
import cn.main.pojo.News;
import cn.main.service.NewsService;
@Service
public class NewsServiceImpl implements NewsService {
	@Resource
	private NewsMapper newsMapper;
	@Resource 
	private DataDictionaryMapper dataDictionaryMapper;
	
	@Override
	public List<News> getNewsList(@Param(value="id")Integer id,Integer sid, Integer type, String content,
			Integer from, Integer pageSize) {
		// TODO Auto-generated method stub
		List<News> list =   newsMapper.getNewsList(id,sid, type, content, from, pageSize); 
		for (News news : list) {
			news.setDataDictionary(dataDictionaryMapper.getDataDictionaryList("news", news.getType()).get(0));
		}
		return list;
	}

	@Override
	public int getCount(Integer sid, Integer type, String content) {
		// TODO Auto-generated method stub
		return newsMapper.getCount(sid, type, content);
	}

	@Override
	public int addNews(News news) {
		// TODO Auto-generated method stub
		return newsMapper.addNews(news);
	}

	@Override
	public int deleteNews(Integer id) {
		// TODO Auto-generated method stub
		return newsMapper.deleteNews(id);
	}

}
