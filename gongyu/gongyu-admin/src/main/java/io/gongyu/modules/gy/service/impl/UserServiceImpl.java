package io.gongyu.modules.gy.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.gongyu.common.utils.Constant;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.common.utils.Query;

import io.gongyu.modules.gy.dao.UserDao;
import io.gongyu.modules.gy.entity.UserEntity;
import io.gongyu.modules.gy.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
    	String mobile = (String)params.get("mobile");
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(params),
                new QueryWrapper<UserEntity>()
                .like(StringUtils.isNotBlank(mobile),"mobile", mobile)
				.apply(params.get(Constant.SQL_FILTER) != null, (String)params.get(Constant.SQL_FILTER))
        );

        return new PageUtils(page);
    }

	@Override
	public List<UserEntity> listCounselor() {
		return baseMapper.listCounselor();
	}

}
