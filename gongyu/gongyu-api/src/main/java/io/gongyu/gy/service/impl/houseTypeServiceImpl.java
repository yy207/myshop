package io.gongyu.gy.service.impl;


import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.gongyu.gy.dao.houseTypeDao;
import io.gongyu.gy.entity.responseParam.houseTypeEntity;
import io.gongyu.gy.service.houseTypeService;

@Service("userMsgService")
public class houseTypeServiceImpl extends ServiceImpl<houseTypeDao,houseTypeEntity> implements houseTypeService{

}
