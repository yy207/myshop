package io.gongyu.gy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.gongyu.gy.dao.UserDaoUp;
import io.gongyu.gy.entity.UserEntity;
import io.gongyu.gy.service.UserService;
import org.springframework.stereotype.Service;


@Service("userServiceUp")
public class UserServiceImpl extends ServiceImpl<UserDaoUp, UserEntity> implements UserService {


    @Override
    public UserEntity getUserName(UserEntity user) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());

        return baseMapper.selectOne(queryWrapper);
    }
}
