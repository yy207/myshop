package cn.main.dao.datadictionary;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.main.pojo.DataDictionary;
import cn.main.pojo.Property;

/**
 * 数据字典接口
 * @author sff
 *
 */
public interface DataDictionaryMapper {
	//获取数据字典对象
	public List<DataDictionary> getDataDictionaryList(@Param(value="keyCode")String keyCode,@Param(value="valueId")Integer valueId);
}
