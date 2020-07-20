package cn.cps.springbootexample.bdqn.service.impl;

import cn.cps.springbootexample.bdqn.dao.UserMapper;
import cn.cps.springbootexample.bdqn.entity.GlobalConstants;
import cn.cps.springbootexample.bdqn.entity.user.User;
import cn.cps.springbootexample.bdqn.entity.user.to.UserInfoTO;
import cn.cps.springbootexample.bdqn.entity.user.to.UserLoginTO;
import cn.cps.springbootexample.bdqn.entity.user.vo.UserInfoVO;
import cn.cps.springbootexample.bdqn.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author _Cps
 * @create 2019-02-14 10:25
 * @Description: 用户Service实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    public UserMapper userMapper;


    @Override
    public UserInfoVO getUserById(Long userId) {

        //使用Mybatis-Plus自带方法
        User user = userMapper.selectById(userId);

        //为空直接返回
        if(user == null){
            return null;
        }

        //将user的数据复制一份到userInfoVO中
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(user, userInfoVO);

        return userInfoVO;
    }


    @Override
    public IPage<UserInfoVO> getUserList(UserInfoTO userInfoTO) {

        //组装分页信息
        Page<UserInfoVO> userInfoVOPage = new Page<UserInfoVO>(userInfoTO.getCurrent(), userInfoTO.getPageSize());

        //调用查询方法
        IPage<UserInfoVO> userVOIPage = userMapper.getUserList(userInfoVOPage, userInfoTO);

        //设置性别中文
        setGenderName(userVOIPage.getRecords());

        return userVOIPage;
    }


    @Override
    public UserInfoVO userLogin(UserLoginTO userLoginTO) {

        //练习使用QueryWrapper定义查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("username",userLoginTO.getUsername());
        queryWrapper.eq("password",userLoginTO.getPassword());
        User user = userMapper.selectOne(queryWrapper);

        //为空直接返回
        if(user==null){
            return null;
        }

        //将user的数据复制一份到userInfoVO中
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(user, userInfoVO);

        return userInfoVO;
    }



    /**
     * 设置性别(中文) -> 对象集合
     * @param userInfoVOS
     */
    public void setGenderName(List<UserInfoVO> userInfoVOS){
        for(UserInfoVO vo : userInfoVOS){
            if(StringUtils.isEmpty(vo)){
                if(vo.getGender()== GlobalConstants.GenderCode.WO_MAN.getCode()){
                    vo.setGenderName(GlobalConstants.GenderCode.WO_MAN.getValue());
                }else if(vo.getGender()== GlobalConstants.GenderCode.MAN.getCode()){
                    vo.setGenderName(GlobalConstants.GenderCode.MAN.getValue());
                }else{
                    vo.setGenderName("其他");
                }
            }
        }
    }


}
