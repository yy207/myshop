package io.gongyu.gy.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import io.gongyu.gy.entity.requestParam.*;
import io.gongyu.gy.entity.responseParam.SearchRecordEntity;
import io.gongyu.gy.entity.responseParam.UserAllEntity;
import io.gongyu.gy.entity.responseParam.UserGwMsgEntity;
import io.gongyu.gy.entity.responseParam.UserMsgEntity;
import io.gongyu.wechat.pay.entity.PaySuccessEntity;

public interface UserAllService extends IService<UserAllEntity>{

	List<UserAllEntity> listUserGwAll(String areaParam, Integer zhId);

	void updateUserPerfectInformation(PerfectInformationEntity piParam);

	void updateSubsidy(UserSubsidyEntity subsidyParam);

	void updateGuaranteeMoney(GuaranteeMoneyEntity guaranteeMoneyParam);

	UserMsgEntity getUserById(Long userId, String mobile);

	void updateGuaranteeMoneyEmbody(GuaranteeMoneyEntity guaranteeMoneyParam);

	void updateGwMsgById(ApplicationGwEntity applicationGw);

	UserGwMsgEntity getGWRelationMsg(WhoSeeMeEntity wsm);

	List<SearchRecordEntity> userListBrowseRecord(Integer userId);

	List<WhoSeeMeEntity> listGwWhoSeeMe(Integer userId);

    List<GuaranteeMoneyEntity> listMoneyRecord(UserIdAndMobileEntity userIdAndMobileEntity);

    UserMsgEntity selectUserCompleteInformation(UserIdAndMobileEntity userIdAndMobile);
    //微信交易订单
	void insertWxOrder(PaySuccessEntity payMessage);

	void mobileCode(String codeNum,String mobile);

	void updateModifySupervisorArea(String gwArea, String mobile);

	UserMsgEntity updateGwMsgByIdFalse(UserIdAndMobileEntity userIdAndMobile);
}
