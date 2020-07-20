package io.gongyu.gy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.gongyu.gy.entity.UserEntity;

/**
 * 用户
 *
 * @author 
 * @email 
 * @date 2020-04-24 10:30:11
 */
public interface UserService extends IService<UserEntity> {


    UserEntity getUserName(UserEntity user);
}

