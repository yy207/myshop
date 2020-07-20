package io.gongyu.modules.gy.controller;


import java.util.Map;

import io.gongyu.modules.gy.entity.GongyuWxpayOrderEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gongyu.modules.gy.service.GongyuWxpayOrderService;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.common.utils.R;



/**
 * 微信交易记录
 *
 * @author 
 * @email 
 * @date 2020-05-11 09:33:39
 */
@RestController
@RequestMapping("gy/gongyuwxpayorder")
public class GongyuWxpayOrderController {
    @Autowired
    private GongyuWxpayOrderService gongyuWxpayOrderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("gy:gongyuwxpayorder:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gongyuWxpayOrderService.queryPage(params);

        return R.ok().put("page", page);
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("gy:gongyuwxpayorder:info")
    public R info(@PathVariable("id") Integer id){
        GongyuWxpayOrderEntity gongyuWxpayOrder = gongyuWxpayOrderService.getById(id);

        return R.ok().put("gongyuWxpayOrder", gongyuWxpayOrder);
    }

}
