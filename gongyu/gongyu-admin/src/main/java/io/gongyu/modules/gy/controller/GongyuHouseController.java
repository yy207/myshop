package io.gongyu.modules.gy.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.gongyu.modules.gy.entity.GongyuHouseEntity;
import io.gongyu.modules.gy.entity.HouseTypeEntity;
import io.gongyu.modules.gy.entity.PriceEntity;
import io.gongyu.modules.gy.service.GongyuHouseService;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.common.utils.R;
import io.gongyu.common.validator.ValidatorUtils;



/**
 * 房源-房子信息
 *
 * @author 
 * @email 
 * @date 2020-04-17 15:41:56
 */
@RestController
@RequestMapping("gy/gongyuhouse")
public class GongyuHouseController {
    @Autowired
    private GongyuHouseService gongyuHouseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("gy:gongyuhouse:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = gongyuHouseService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{houseId}")
    @RequiresPermissions("gy:gongyuhouse:info")
    public R info(@PathVariable("houseId") Integer houseId){
        GongyuHouseEntity gongyuHouse = gongyuHouseService.getById(houseId);

        return R.ok().put("gongyuHouse", gongyuHouse);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("gy:gongyuhouse:save")
    public R save(@RequestBody GongyuHouseEntity gongyuHouse){
    	gongyuHouse.setHouseTime(new Date());
        gongyuHouseService.save(gongyuHouse);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("gy:gongyuhouse:update")
    public R update(@RequestBody GongyuHouseEntity gongyuHouse){
        ValidatorUtils.validateEntity(gongyuHouse);
        gongyuHouseService.updateById(gongyuHouse);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("gy:gongyuhouse:delete")
    public R delete(@RequestBody Integer[] houseIds){
        gongyuHouseService.removeByIds(Arrays.asList(houseIds));

        return R.ok();
    }

    /**
     * 房子类型
     */
    @RequestMapping("/listType")
    @RequiresPermissions("gy:gongyuhouse:list")
    public R listType(){
    	List<HouseTypeEntity> list = gongyuHouseService.listType();
        return R.ok().put("list", list);
    	
    }
    /**
     * 房子价格
     */
    @RequestMapping("/listPrice")
    @RequiresPermissions("gy:gongyuhouse:list")
    public R listPrice(){
    	List<PriceEntity> list = gongyuHouseService.listPrice();
        return R.ok().put("list", list);
    	
    }
}
