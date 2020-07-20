package io.gongyu.gy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.gongyu.common.utils.R;
import io.gongyu.gy.entity.requestParam.ReportJlEntity;
import io.gongyu.gy.entity.responseParam.ReportXZEntity;
import io.gongyu.gy.service.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/report")
@Api(tags = "举报接口")
public class ReportController {

	@Autowired
	private ReportService reportService;
	
	@GetMapping("/listReportXZ")
	@ApiOperation(value = "举报选项列表")
	public R listReportXZ() {
		List<ReportXZEntity> list = reportService.list();
		return R.ok().put("msg", list);
	}
	
	@PostMapping("/saveReportJL")
	@ApiOperation(value = "添加举报")
	public R saveReportJL(ReportJlEntity reportJL) {
		reportService.saveReportJL(reportJL);
		return R.ok();
	}
}
