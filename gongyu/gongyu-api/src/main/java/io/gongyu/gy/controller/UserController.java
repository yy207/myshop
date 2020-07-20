package io.gongyu.gy.controller;

import io.gongyu.common.utils.R;
import io.gongyu.gy.entity.UserEntity;
import io.gongyu.gy.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


/**
 * 用户
 *
 * @author 
 * @email 
 * @date 2020-04-24 10:30:11
 */
@RestController
@RequestMapping("gy/upUser")
@Api(tags="租房顾问信息完善")
public class UserController {

    @Autowired
    private UserService userServiceUp;

    /**
     * 完善用户信息
     */
    @PostMapping("/update")
    @ApiOperation(value="完善用户信息")
    public R update(UserEntity user){
        userServiceUp.updateById(user);
        return R.ok();
    }

    @PostMapping("/getUser")
    @ApiOperation(value="查找用户的昵称是否已经存在")
    public R getUser(UserEntity user){

        UserEntity flag = userServiceUp.getUserName(user);

        if(!StringUtils.isEmpty(flag)){
            return R.error().put("msg","昵称已存在,请重新选择！");
        }
        return R.ok();
    }




}
