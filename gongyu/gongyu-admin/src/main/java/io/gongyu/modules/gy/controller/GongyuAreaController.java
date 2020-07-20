package io.gongyu.modules.gy.controller;


import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.gongyu.modules.gy.entity.GongyuAreaEntity;
import io.gongyu.modules.gy.entity.GongyuAreaMetroEntity;
import io.gongyu.modules.gy.entity.GongyuMetroEntity;
import io.gongyu.modules.gy.service.GongyuAreaService;
import io.gongyu.common.utils.R;



/**
 * 区域
 *
 * @author 
 * @email 
 * @date 2020-04-20 16:52:12
 */
@RestController
@RequestMapping("gy/gongyuarea")
public class GongyuAreaController {
    @Autowired
    private GongyuAreaService gongyuAreaService;

    /**
     * 区域列表
     */
    @RequestMapping("/listArea")
    @RequiresPermissions("gy:gongyuhouse:list")
    public R list(){
    	List<GongyuAreaEntity> list = gongyuAreaService.list();
        return R.ok().put("list", list);
    }
    /**
     * 地铁列表
     */
    @RequestMapping("/listMetro")
    @RequiresPermissions("gy:gongyuhouse:list")
    public R listMetro(Integer areaId){
    	List<GongyuMetroEntity> list = gongyuAreaService.listMetro(areaId);
        return R.ok().put("list", list);
    }
    /**
     * 地铁站列表
     */
    @RequestMapping("/listMetroStation")
    @RequiresPermissions("gy:gongyuhouse:list")
    public R listMetroStation(Integer areaId ,Integer metroId){
    	List<GongyuAreaMetroEntity> list = gongyuAreaService.listMetroStation(areaId,metroId);
        return R.ok().put("list", list);
    }
}
