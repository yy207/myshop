package cn.cps.springbootexample.bdqn.dao;

import cn.cps.springbootexample.bdqn.entity.user.User;
import cn.cps.springbootexample.bdqn.entity.user.to.UserInfoTO;
import cn.cps.springbootexample.bdqn.entity.user.vo.UserInfoVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @Author: Cai Peishen
 * @Date: 2020/6/29 11:59
 * @Description: 用户Mapper接口 继承 MyBatis-Plus 的BaseMapper接口
 */
public interface UserMapper extends BaseMapper<User> {

    IPage<UserInfoVO> getUserList(Page<UserInfoVO> userInfoVOPage, UserInfoTO userInfoTO);

}
