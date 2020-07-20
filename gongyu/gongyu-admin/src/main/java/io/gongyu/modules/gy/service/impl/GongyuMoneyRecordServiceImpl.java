package io.gongyu.modules.gy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.common.utils.Query;
import io.gongyu.modules.gy.dao.GongyuMoneyRecordDao;
import io.gongyu.modules.gy.entity.GongyuMoneyRecordEntity;
import io.gongyu.modules.gy.entity.UserEntity;
import io.gongyu.modules.gy.service.GongyuMoneyRecordService;
import io.gongyu.modules.gy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("gongyuMoneyRecordService")
public class GongyuMoneyRecordServiceImpl extends ServiceImpl<GongyuMoneyRecordDao, GongyuMoneyRecordEntity> implements GongyuMoneyRecordService {
    @Autowired
    UserService userService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GongyuMoneyRecordEntity> page = this.page(
                new Query<GongyuMoneyRecordEntity>().getPage(params),
                new QueryWrapper<GongyuMoneyRecordEntity>().orderByDesc("creation_time")
        );
        /**
         * 获取当前数据集合,存入List集合
         */
        List<GongyuMoneyRecordEntity> list = page.getRecords();
        /**
         * 遍历数据
         */
        list.forEach(gongyuMoneyRecordEntity -> {
            UserEntity userEntity = userService.getById(gongyuMoneyRecordEntity.getUserId());
            /**
             * 判断userEntity 是否为null
             */
            if(userEntity != null) {
                /**
                 * 根据userId获取username
                 */
            	gongyuMoneyRecordEntity.setUsername(userEntity.getUsername());
            }
        });

        return new PageUtils(page);
    }


}
