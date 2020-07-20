package io.gongyu.modules.gy.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import io.gongyu.common.validator.ValidatorUtils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.gongyu.modules.gy.entity.UserListEntity;
import io.gongyu.modules.gy.service.UserListService;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.common.utils.R;
import io.gongyu.common.utils.ShareCodeUtils;



/**
 * 用户
 *
 * @author 
 * @email 
 * @date 2020-04-29 13:07:53
 */
@RestController
@RequestMapping("gy/tbuser")
public class UserListController {
    @Autowired
    private UserListService tbUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("gy:user:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tbUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("gy:user:info")
    public R info(@PathVariable("userId") Long userId){
        UserListEntity tbUser = tbUserService.getById(userId);

        return R.ok().put("tbUser", tbUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("gy:user:save")
    public R save(@RequestBody UserListEntity tbUser){
//    	tbUser.setPassword(DigestUtils.shaHex(tbUser.getPassword()));
//    	Long codeLong = Long.parseLong(tbUser.getMobile());
//    	String codeString = ShareCodeUtils.toSerialCode(codeLong).toString();
//    	tbUser.setMyInvitationCode(codeString);
//    	tbUser.setCreateTime(new Date());
        tbUserService.save(tbUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("gy:user:update")
    public R update(@RequestBody UserListEntity tbUser){
        ValidatorUtils.validateEntity(tbUser);
        tbUserService.updateById(tbUser);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("gy:user:delete")
    public R delete(@RequestBody Long[] userIds){
        tbUserService.removeByIds(Arrays.asList(userIds));

        return R.ok();
    }

}
