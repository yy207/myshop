package io.gongyu.gy.service.impl;

import io.gongyu.gy.dao.GongyuInformDao;
import io.gongyu.gy.entity.responseParam.GongyuInformEntity;
import io.gongyu.gy.service.GongyuInformService;
import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("gongyuInformService")
public class GongyuInformServiceImpl extends ServiceImpl<GongyuInformDao, GongyuInformEntity> implements GongyuInformService {


    @Override
    public List<GongyuInformEntity> listInform(Integer userId) {

        //根据用户id查询用户的系统通知
        List<GongyuInformEntity> list = baseMapper.selectList(new QueryWrapper<GongyuInformEntity>()
                .eq("user_id", userId).orderByDesc("creationTime"));
        return list;
    }
}
