package cn.main.dao.history;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.main.pojo.History;

public interface HistoryMapper {
	
	List<History> getHistoryList(@Param(value="id")Integer id,
								@Param(value="uid")Integer uid,
								@Param(value="sid")Integer sid,
								@Param(value="gid")Integer gid,
								@Param(value="from")Integer from,
								@Param(value="pageSize")Integer pageSize);
	
	int insertHistory(@Param(value="history")History history);
	
	int deleteHistory(@Param(value="id")Integer id);
	
}
