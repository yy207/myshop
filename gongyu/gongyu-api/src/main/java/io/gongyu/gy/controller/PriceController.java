package io.gongyu.gy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.gongyu.common.utils.R;
import io.gongyu.gy.entity.responseParam.PriceEntity;
import io.gongyu.gy.service.PriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/price")
@Api(tags="价格接口")
public class PriceController {

	@Autowired
	private PriceService priceService;
	@GetMapping("/list")
    @ApiOperation(value="价格")
    public R listPrice(){
		List<PriceEntity> list = priceService.list();
		return R.ok().put("msg", list);
	}
}
