package cn.main.service.serviceimpl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.main.dao.datadictionary.DataDictionaryMapper;
import cn.main.pojo.DataDictionary; 
import cn.main.service.DataDictionaryService;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
	
	@Resource
	private DataDictionaryMapper mapper;

	@Override
	public List<DataDictionary> getDataDictionaryList(String keyCode,
			Integer valueId) {
		// TODO Auto-generated method stub
		return mapper.getDataDictionaryList(keyCode, valueId);
	}
	
	 

}
