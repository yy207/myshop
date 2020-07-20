package io.gongyu.gy.controller;

import java.util.List;

import io.gongyu.gy.entity.responseParam.GongyuInformEntity;
import io.gongyu.gy.service.GongyuInformService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import io.gongyu.common.utils.R;



/**
 * 系统通知
 *
 * @author 
 * @email 
 * @date 2020-04-29 16:27:53
 */
@RestController
@RequestMapping("api/gongyuinform")
@Api(tags="系统通知")
public class GongyuInformController {
    @Autowired
    private GongyuInformService gongyuInformService;

    /**
     * 列表
     */
    @GetMapping("/listInform")
    @ApiOperation(value="系统通知列表")
    public R listInform(Integer userId){
        List<GongyuInformEntity> list = gongyuInformService.listInform(userId);

        return R.ok().put("msg", list);
    }



}
