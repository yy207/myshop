package io.gongyu.modules.gy.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.gongyu.common.utils.Constant;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.common.utils.Query;

import io.gongyu.modules.gy.dao.UseListDao;
import io.gongyu.modules.gy.entity.UserListEntity;
import io.gongyu.modules.gy.service.UserListService;


@Service("tbUserService")
public class UserListServiceImpl extends ServiceImpl<UseListDao, UserListEntity> implements UserListService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
    	String mobile = (String)params.get("mobile");
        IPage<UserListEntity> page = this.page(
                new Query<UserListEntity>().getPage(params),
                new QueryWrapper<UserListEntity>()
                .like(StringUtils.isNotBlank(mobile),"mobile", mobile)
				.apply(params.get(Constant.SQL_FILTER) != null, (String)params.get(Constant.SQL_FILTER))
        );

        return new PageUtils(page);
    }

}
