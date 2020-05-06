package cn.main.service.love;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.main.pojo.Love;

public interface LoveService {
	
	
	List<Love> getLoveList(@Param(value="id")Integer id,
			@Param(value="uid")Integer uid,
			@Param(value="sid")Integer sid,
			@Param(value="type")Integer type,
			@Param(value="from")Integer from,
			@Param(value="pageSize")Integer pageSize);
	
	int insertLove(@Param(value="love")Love love);
	int deleteLove(@Param(value="id")Integer id);
}
