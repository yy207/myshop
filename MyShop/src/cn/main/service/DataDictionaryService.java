package cn.main.service;

import java.util.List;

import cn.main.pojo.DataDictionary;

 

public interface DataDictionaryService {
	
	//获取数据字典对象
	public List<DataDictionary> getDataDictionaryList(String keyCode,Integer valueId);

}
