package io.gongyu.modules.gy.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.gongyu.modules.gy.entity.UserEntity;
import io.gongyu.modules.gy.service.UserService;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.common.utils.R;
import io.gongyu.common.utils.ShareCodeUtils;
import io.gongyu.common.validator.ValidatorUtils;



/**
 * 用户
 *
 * @author 
 * @email 
 * @date 2020-04-21 18:11:59
 */
@RestController
@RequestMapping("gy/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("gy:user:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("gy:user:info")
    public R info(@PathVariable("userId") Long userId){
        UserEntity user = userService.getById(userId);

        return R.ok().put("user", user);
    }

    /**
     * 保存
     */
    @SuppressWarnings("deprecation")
	@RequestMapping("/save")
    @RequiresPermissions("gy:user:save")
    public R save(@RequestBody UserEntity user){
    	
    	
        userService.save(user);

        return R.ok();
    }

    /**
     * 修改
     */
    @SuppressWarnings("deprecation")
	@RequestMapping("/update")
    @RequiresPermissions("gy:user:update")
    public R update(@RequestBody UserEntity user){
        ValidatorUtils.validateEntity(user);
        user.setPassword(DigestUtils.shaHex(user.getPassword()));
        userService.updateById(user);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("gy:user:delete")
    public R delete(@RequestBody Long[] userIds){
        userService.removeByIds(Arrays.asList(userIds));

        return R.ok();
    }
    /**
     * 租赁顾问列表
     * 
     */
    @RequestMapping("/listCounselor")
    @RequiresPermissions("gy:user:list")
    public R listCounselor(){
    	List<UserEntity> list = userService.listCounselor();
        return R.ok().put("list", list);
    }

    
}
