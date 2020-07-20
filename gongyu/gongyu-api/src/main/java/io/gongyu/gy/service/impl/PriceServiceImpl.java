package io.gongyu.gy.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.gongyu.gy.dao.PriceDao;
import io.gongyu.gy.entity.responseParam.PriceEntity;
import io.gongyu.gy.service.PriceService;
@Service("priceService")
public class PriceServiceImpl extends ServiceImpl<PriceDao, PriceEntity> implements PriceService{

}
