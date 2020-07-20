package io.gongyu.gy.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import io.gongyu.gy.entity.requestParam.ReportJlEntity;
import io.gongyu.gy.entity.responseParam.ReportXZEntity;

@Mapper
public interface ReportDao extends BaseMapper<ReportXZEntity>{

	void saveReportJL(ReportJlEntity reportJL);

}
