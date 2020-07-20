package io.gongyu.gy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.gongyu.common.utils.R;
import io.gongyu.gy.entity.responseParam.houseTypeEntity;
import io.gongyu.gy.service.houseTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * 房间类型
 *
 */
@RestController
@RequestMapping("/api/houseType")
@Api(tags="房间类型接口")
public class houseTypeController {

	@Autowired
	private houseTypeService userMsgService;
	
    @GetMapping("/list")
    @ApiOperation(value="房间类型列表")
    public R listUser(){
    	List<houseTypeEntity> list = userMsgService.list();
        return R.ok().put("list", list);
    }
}
