package cn.main.service.history;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.main.pojo.History;

public interface HistoryService {
	
		List<History> getHistoryList(@Param(value="id")Integer id,
			@Param(value="uid")Integer uid,
			@Param(value="sid")Integer sid,
			@Param(value="type")Integer type,
			@Param(value="from")Integer from,
			@Param(value="pageSize")Integer pageSize);

		int insertHistory(@Param(value="history")History history);

		int deleteHistory(@Param(value="id")Integer id);

}
