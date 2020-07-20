package io.gongyu.gy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.gongyu.common.RedisUtil;
import io.gongyu.gy.entity.requestParam.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.gongyu.common.exception.RRException;
import io.gongyu.gy.dao.UserAllDao;
import io.gongyu.gy.entity.responseParam.GwZhIdEntity;
import io.gongyu.gy.entity.responseParam.SearchRecordEntity;
import io.gongyu.gy.entity.responseParam.UserAllEntity;
import io.gongyu.gy.entity.responseParam.UserGwMsgEntity;
import io.gongyu.gy.entity.responseParam.UserMsgEntity;
import io.gongyu.gy.service.UserAllService;
import io.gongyu.wechat.pay.entity.PaySuccessEntity;

@Service("userAllService")
public class UserAllServiceImpl extends ServiceImpl<UserAllDao, UserAllEntity> implements UserAllService {

	@Autowired
    private UserAllService userAllService;
    @Autowired
    private RedisUtil redisUtil;
	
    @Override
    public UserMsgEntity getUserById(Long userId, String mobile) {
        return baseMapper.getUserById(userId, mobile);
    }

    @Override
    public List<UserAllEntity> listUserGwAll(String areaParam, Integer zhId) {
        List<UserAllEntity> listUserGwAll = baseMapper.listUserGwAll(areaParam);
        if (zhId != null) {
            for (UserAllEntity userAllEntity : listUserGwAll) {
                WhoSeeMeEntity wsm = baseMapper.selectwsmMsg(userAllEntity.getUserId(), zhId);
                System.out.println(wsm);
                if (wsm != null) {
                    userAllEntity.setIdentStatus("已看过");
                } else {
                    userAllEntity.setIdentStatus("未看过");
                }
            }
        } else {
            for (UserAllEntity userAllEntity : listUserGwAll) {
                userAllEntity.setIdentStatus("未看过");
            }
        }
        return listUserGwAll;
    }

    /**
     * 顾问完善信息
     * @param piParam
     */
    @Override
    public void updateUserPerfectInformation(PerfectInformationEntity piParam) {
        baseMapper.updateUserPerfectInformation(piParam);
    }

    @Override
    public void updateSubsidy(UserSubsidyEntity subsidyParam) {
        baseMapper.updateSubsidy(subsidyParam);
    }

    @Override
    public void updateGuaranteeMoney(GuaranteeMoneyEntity guaranteeMoneyParam) {
        UserMsgEntity usermsg = baseMapper.getUserById(guaranteeMoneyParam.getUserId(),
                guaranteeMoneyParam.getMobile());
        if (usermsg.getGuaranteeMoney() == null) {
            // 修改金额
            baseMapper.updateGuaranteeMoney(guaranteeMoneyParam);
        } else {
            Integer hMoney = Integer.parseInt(usermsg.getGuaranteeMoney());
            Integer nMoney = Integer.parseInt(guaranteeMoneyParam.getMoney());
            Integer zMoney = hMoney + nMoney;
            guaranteeMoneyParam.setMoney(zMoney.toString());
            baseMapper.updateGuaranteeMoney(guaranteeMoneyParam);
        }
        // 添加保证金记录
        guaranteeMoneyParam.setCreationTime(new Date());
        baseMapper.saveGuaranteeMoneyRecord(guaranteeMoneyParam);
    }

    @Override
    public void updateGuaranteeMoneyEmbody(GuaranteeMoneyEntity guaranteeMoneyParam) {
        UserMsgEntity usermsg = baseMapper.getUserById(guaranteeMoneyParam.getUserId(),
                guaranteeMoneyParam.getMobile());
        Integer hMoney = Integer.parseInt(usermsg.getGuaranteeMoney());
        Integer txMoney = Integer.parseInt(guaranteeMoneyParam.getMoney());
        if (hMoney >= txMoney) {
            Integer zMongy = hMoney - txMoney;
            guaranteeMoneyParam.setMoney(zMongy.toString());
            baseMapper.updateGuaranteeMoneyEmbody(guaranteeMoneyParam);
        } else {
            throw new RRException("提现的余额不足");
        }
        // 添加保证金记录
        guaranteeMoneyParam.setMoney(txMoney.toString());
        guaranteeMoneyParam.setCreationTime(new Date());
        baseMapper.saveGuaranteeMoneyRecord(guaranteeMoneyParam);
    }

    @Override
    public void updateGwMsgById(ApplicationGwEntity applicationGw) {
        baseMapper.updateGwMsgById(applicationGw);
    }

    @Override
    public UserGwMsgEntity getGWRelationMsg(WhoSeeMeEntity wsm) {
        //进行添加查看记录
        GwZhIdEntity ww = baseMapper.selectWhoSeeMe(wsm.getGwId(), wsm.getZhId());
        if (ww == null) {
            baseMapper.saveWSM(wsm);
        }
        GwZhIdEntity br = baseMapper.selectBrowseRecord(wsm.getGwId(), wsm.getZhId());
        //判断是否查看过
        if (br == null) {
            //添加咨询记录
            baseMapper.saveBrowseRecord(wsm.getGwId(), wsm.getZhId());
        }
        return baseMapper.getGWRelationMsg(wsm.getGwId());
    }

    @Override
    public List<SearchRecordEntity> userListBrowseRecord(Integer userId) {
        List<GwZhIdEntity> intmsg = baseMapper.listGwById(userId);
        List<SearchRecordEntity> srmsg = new ArrayList<SearchRecordEntity>();
        for (GwZhIdEntity gwZhIdEntity : intmsg) {
            SearchRecordEntity srmsg2 = baseMapper.userListBrowseRecord(gwZhIdEntity.getGwId());
            System.out.println(srmsg2);
            srmsg.add(srmsg2);
        }
        return srmsg;
    }

    @Override
    public List<WhoSeeMeEntity> listGwWhoSeeMe(Integer userId) {
        List<WhoSeeMeEntity> list = baseMapper.listGwWhoSeeMe(userId);
        return list;
    }

    @Override
    public List<GuaranteeMoneyEntity> listMoneyRecord(UserIdAndMobileEntity userIdAndMobileEntity) {
        return baseMapper.listMoneyRecord(userIdAndMobileEntity);
    }

    @Override
    public UserMsgEntity selectUserCompleteInformation(UserIdAndMobileEntity userIdAndMobile) {
        UserMsgEntity select = baseMapper.selectUserCompleteInformation(userIdAndMobile);
        //姓名
        if (select.getGwName() == null) {
            throw new RRException("请完善信息-姓名");
        }
        //微信号
        if (select.getWechatUsername() == null) {
            throw new RRException("请完善信息-微信号");
        }
        //微信二维码
        if (select.getWechatImg() == null) {
            throw new RRException("请完善信息-微信二维码");
        }
        //主管区域
        if (select.getDirectorOfRegional() == null) {
            throw new RRException("请完善信息-主管区域");
        }
        //顾问的保证金
        if (select.getGuaranteeMoney() == null) {
            throw new RRException("请完善信息-保证金");
        }
        return select;
    }
    /**
     * 添加微信支付订单信息
     */
	@Override
	public void insertWxOrder(PaySuccessEntity payMessage) {
		baseMapper.insertWxOrder(payMessage);
		//添加激纳保证金记录
		GuaranteeMoneyEntity guaranteeMoneyParam = new GuaranteeMoneyEntity();
		//用户id
		Long parseLong = Long.parseLong(payMessage.getUserId());
		guaranteeMoneyParam.setUserId(parseLong);
		//用户手机号
		guaranteeMoneyParam.setMobile(payMessage.getMobile());
		//支付金额
		guaranteeMoneyParam.setMoney(payMessage.getTotalFee());
		//支付类型
		guaranteeMoneyParam.setOperationType("激纳");
		userAllService.updateGuaranteeMoney(guaranteeMoneyParam);
	}

    @Override
    public void mobileCode(String codeNum,String mobile) {
        String code = redisUtil.get(mobile);
        System.out.println("---->"+codeNum);
        System.out.println("---->"+code);
        if (codeNum.equals(code)) {

        } else {
            throw new RRException("手机号验证码错误");
        }
    }

    @Override
    public void updateModifySupervisorArea(String gwArea, String mobile) {
        String mobiles = redisUtil.jedisGetTime(mobile);
        //设置区域的修改时间
        if(mobiles != null){
            throw new RRException("区域一年之内只能修改一次，你已修改过。");
        }else{
            if (gwArea != null) {
                redisUtil.jedisSetTime(mobile);
                baseMapper.updateModifySupervisorArea(gwArea,mobile);
            }
        }
    }

    @Override
    public UserMsgEntity updateGwMsgByIdFalse(UserIdAndMobileEntity userIdAndMobile) {
        UserMsgEntity select = baseMapper.selectUserCompleteInformation(userIdAndMobile);
        //姓名
        if (select.getGwName() == null) {
            throw new RRException("请完善信息-姓名");
        }
        //身份证号
        if (select.getIdentityCardNum() == null) {
            throw new RRException("请完善信息-身份证号");
        }
        //身份证图片正面
        if (select.getIdentityCardImgFront() == null) {
            throw new RRException("请完善信息-身份证图片正面");
        }
        //身份证图片反面
        if (select.getIdentityCardImgReverse() == null) {
            throw new RRException("请完善信息-身份证图片反面");
        }
        return select;
    }

}
