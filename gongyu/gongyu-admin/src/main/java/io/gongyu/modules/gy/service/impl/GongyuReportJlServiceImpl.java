package io.gongyu.modules.gy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.common.utils.Query;
import io.gongyu.modules.gy.dao.GongyuReportJlDao;
import io.gongyu.modules.gy.entity.GongyuReportJlEntity;
import io.gongyu.modules.gy.entity.UserEntity;
import io.gongyu.modules.gy.service.GongyuReportJlService;
import io.gongyu.modules.gy.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;


@Service("gongyuReportJlService")
public class GongyuReportJlServiceImpl extends ServiceImpl<GongyuReportJlDao, GongyuReportJlEntity> implements GongyuReportJlService {

    @Autowired
    private  UserService  userService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GongyuReportJlEntity> page = this.page(
                new Query<GongyuReportJlEntity>().getPage(params),
                new QueryWrapper<GongyuReportJlEntity>().orderByDesc("creation_time")
        );
        //得到举报数据集合
        List<GongyuReportJlEntity> records = page.getRecords();
       
        //遍历举报集合
        for (GongyuReportJlEntity record : records) {
            //得到被举报人
            UserEntity user = userService.getById(record.getUserId());
            //将举报人的数据封装到举报数据集合中、
            //如果得到的用户为空，则跳过本次循环
            if(StringUtils.isEmpty(user)){
                continue;
            }
                //举报人的姓名
            record.setUsername(user.getUsername());
                //举报人的电话
            record.setMobile(user.getMobile());
        }


        return new PageUtils(page);
    }

}
