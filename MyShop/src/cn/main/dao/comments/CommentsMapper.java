package cn.main.dao.comments;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.main.pojo.Comments;

public interface CommentsMapper {
	//查询
	List<Comments> getCommentsList(@Param(value="id")Integer id,
			@Param(value="uid")Integer uid,
			@Param(value="gid")Integer gid,
			@Param(value="createTime")String  createTime,
			@Param(value="content")String content,
			@Param(value="from")Integer from,
			@Param(value="pageSize")Integer pageSize);
	
	//添加
	int addComments(Comments comments);
	
	
	
}
