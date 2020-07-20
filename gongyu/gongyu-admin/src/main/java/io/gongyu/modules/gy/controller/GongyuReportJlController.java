package io.gongyu.modules.gy.controller;

import io.gongyu.common.utils.PageUtils;
import io.gongyu.common.utils.R;
import io.gongyu.common.validator.ValidatorUtils;
import io.gongyu.modules.gy.entity.GongyuReportJlEntity;
import io.gongyu.modules.gy.service.GongyuReportJlService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 举报记录
 *
 * @author 
 * @email 
 * @date 2020-04-27 10:13:37
 */
@RestController
@RequestMapping("gy/gongyureportjl")
public class GongyuReportJlController {
    @Autowired
    private GongyuReportJlService gongyuReportJlService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("gy:gongyureportjl:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gongyuReportJlService.queryPage(params);
        System.out.println(page);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("gy:gongyureportjl:info")
    public R info(@PathVariable("id") Integer id){
        GongyuReportJlEntity gongyuReportJl = gongyuReportJlService.getById(id);

        return R.ok().put("gongyuReportJl", gongyuReportJl);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("gy:gongyureportjl:save")
    public R save(@RequestBody GongyuReportJlEntity gongyuReportJl){
        gongyuReportJlService.save(gongyuReportJl);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("gy:gongyureportjl:update")
    public R update(@RequestBody GongyuReportJlEntity gongyuReportJl){
        ValidatorUtils.validateEntity(gongyuReportJl);
        gongyuReportJlService.updateById(gongyuReportJl);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("gy:gongyureportjl:delete")
    public R delete(@RequestBody Integer[] ids){
        gongyuReportJlService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
