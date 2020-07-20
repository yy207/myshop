package io.gongyu.modules.gy.service.impl;

import io.gongyu.modules.gy.dao.GongyuWxpayOrderDao;
import io.gongyu.modules.gy.entity.GongyuReportJlEntity;
import io.gongyu.modules.gy.entity.GongyuWxpayOrderEntity;
import io.gongyu.modules.gy.entity.UserEntity;
import io.gongyu.modules.gy.service.GongyuWxpayOrderService;
import io.gongyu.modules.gy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.common.utils.Query;
import org.springframework.util.StringUtils;


@Service("gongyuWxpayOrderService")
public class GongyuWxpayOrderServiceImpl extends ServiceImpl<GongyuWxpayOrderDao, GongyuWxpayOrderEntity> implements GongyuWxpayOrderService {
    @Autowired
    private UserService userService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GongyuWxpayOrderEntity> page = this.page(
                new Query<GongyuWxpayOrderEntity>().getPage(params),
                new QueryWrapper<GongyuWxpayOrderEntity>()
        );
        //得到微信支付记录数据集合
        List<GongyuWxpayOrderEntity> records = page.getRecords();

        //遍历集合
        for (GongyuWxpayOrderEntity record : records) {
            //得到被支付记录人的姓名
            UserEntity user = userService.getById(record.getUserId());
            //将支付记录人的数据封装到举报数据集合中、
            //如果得到的用户为空，则跳过本次循环
            if(StringUtils.isEmpty(user.getGwName())){
                record.setGwName("未知");
            }
            //顾问的姓名
            record.setGwName(user.getGwName());
        }
        return new PageUtils(page);
    }

}
