package io.gongyu.gy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.gongyu.common.utils.R;
import io.gongyu.gy.entity.responseParam.AreaMetroEntity;
import io.gongyu.gy.entity.responseParam.CityAddressEntity;
import io.gongyu.gy.service.AreaMetroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/areaMetro")
@Api(tags="区域&地铁")
public class AreaMetroController {

	@Autowired
	private	AreaMetroService areaMetroService;
	@GetMapping("/list")
    @ApiOperation(value="区域&地铁")
    public R listAreaMetro(){
    	List<AreaMetroEntity> list = areaMetroService.listAreaMetro();
        return R.ok().put("msg", list);
    }
	@GetMapping("/listAddress")
    @ApiOperation(value="全国地址")
    public R listAddress(){
    	List<CityAddressEntity> list = areaMetroService.listAddress();
        return R.ok().put("msg", list);
    }
}
