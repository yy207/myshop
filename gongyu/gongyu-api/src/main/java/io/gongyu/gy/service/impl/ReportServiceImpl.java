package io.gongyu.gy.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.gongyu.gy.dao.ReportDao;
import io.gongyu.gy.entity.requestParam.ReportJlEntity;
import io.gongyu.gy.entity.responseParam.ReportXZEntity;
import io.gongyu.gy.service.ReportService;
@Service("reportService")
public class ReportServiceImpl extends ServiceImpl<ReportDao, ReportXZEntity> implements ReportService{

	@Override
	public void saveReportJL(ReportJlEntity reportJL) {
		baseMapper.saveReportJL(reportJL);
	}

}
