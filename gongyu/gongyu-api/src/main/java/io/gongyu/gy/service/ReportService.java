package io.gongyu.gy.service;

import com.baomidou.mybatisplus.extension.service.IService;

import io.gongyu.gy.entity.requestParam.ReportJlEntity;
import io.gongyu.gy.entity.responseParam.ReportXZEntity;

public interface ReportService extends IService<ReportXZEntity>{

	void saveReportJL(ReportJlEntity reportJL);

}
