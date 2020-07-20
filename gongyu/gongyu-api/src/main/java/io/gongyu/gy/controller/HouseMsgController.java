package io.gongyu.gy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.gongyu.common.utils.R;
import io.gongyu.gy.entity.HouseMsgEntity;
import io.gongyu.gy.entity.requestParam.HouseParamEntity;
import io.gongyu.gy.service.HouseMsgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/house")
@Api(tags="房源接口")
public class HouseMsgController {

	@Autowired
	private HouseMsgService houseMsgService;
	@GetMapping("/listHouseMsg")
    @ApiOperation(value="房源列表")
    public R listHouseMsg(HouseParamEntity houseParam){
		List<HouseMsgEntity> list = houseMsgService.listHouseMsg(houseParam);
		return R.ok().put("msg", list);
	}
}
