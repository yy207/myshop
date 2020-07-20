package io.gongyu.modules.gy.controller;

import java.util.Arrays;
import java.util.Map;

import io.gongyu.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.gongyu.modules.gy.entity.GongyuHouseImgEntity;
import io.gongyu.modules.gy.service.GongyuHouseImgService;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.common.utils.R;



/**
 * 房源图片
 *
 * @author 
 * @email 
 * @date 2020-04-22 15:23:52
 */
@RestController
@RequestMapping("gy/gongyuhouseimg")
public class GongyuHouseImgController {
    @Autowired
    private GongyuHouseImgService gongyuHouseImgService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("gy:gongyuhouseimg:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gongyuHouseImgService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("gy:gongyuhouseimg:info")
    public R info(@PathVariable("id") Integer id){
        GongyuHouseImgEntity gongyuHouseImg = gongyuHouseImgService.getById(id);

        return R.ok().put("gongyuHouseImg", gongyuHouseImg);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("gy:gongyuhouseimg:save")
    public R save(@RequestBody GongyuHouseImgEntity gongyuHouseImg){
        gongyuHouseImgService.save(gongyuHouseImg);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("gy:gongyuhouseimg:update")
    public R update(@RequestBody GongyuHouseImgEntity gongyuHouseImg){
        ValidatorUtils.validateEntity(gongyuHouseImg);
        gongyuHouseImgService.updateById(gongyuHouseImg);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("gy:gongyuhouseimg:delete")
    public R delete(@RequestBody Integer[] ids){
        gongyuHouseImgService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
