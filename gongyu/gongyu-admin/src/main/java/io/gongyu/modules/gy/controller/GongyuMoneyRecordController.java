package io.gongyu.modules.gy.controller;

import io.gongyu.common.utils.PageUtils;
import io.gongyu.common.utils.R;
import io.gongyu.common.validator.ValidatorUtils;
import io.gongyu.modules.gy.entity.GongyuMoneyRecordEntity;
import io.gongyu.modules.gy.service.GongyuMoneyRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 保证金-记录
 *
 * @author 
 * @email 
 * @date 2020-04-27 10:17:42
 */
@RestController
@RequestMapping("gy/gongyumoneyrecord")
@Api(tags = "保证金-记录")
public class GongyuMoneyRecordController {
    @Autowired
    private GongyuMoneyRecordService gongyuMoneyRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("gy:gongyumoneyrecord:list")
    @ApiOperation(value = "列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gongyuMoneyRecordService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("gy:gongyumoneyrecord:info")
    public R info(@PathVariable("id") Integer id){
        GongyuMoneyRecordEntity gongyuMoneyRecord = gongyuMoneyRecordService.getById(id);

        return R.ok().put("gongyuMoneyRecord", gongyuMoneyRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("gy:gongyumoneyrecord:save")
    public R save(@RequestBody GongyuMoneyRecordEntity gongyuMoneyRecord){
        gongyuMoneyRecordService.save(gongyuMoneyRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("gy:gongyumoneyrecord:update")
    public R update(@RequestBody GongyuMoneyRecordEntity gongyuMoneyRecord){
        ValidatorUtils.validateEntity(gongyuMoneyRecord);
        gongyuMoneyRecordService.updateById(gongyuMoneyRecord);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("gy:gongyumoneyrecord:delete")
    public R delete(@RequestBody Integer[] ids){
        gongyuMoneyRecordService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
