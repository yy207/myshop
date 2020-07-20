package io.gongyu.gy.dao;

import java.util.List;

import io.gongyu.gy.entity.requestParam.*;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import io.gongyu.gy.entity.responseParam.GwZhIdEntity;
import io.gongyu.gy.entity.responseParam.SearchRecordEntity;
import io.gongyu.gy.entity.responseParam.UserAllEntity;
import io.gongyu.gy.entity.responseParam.UserGwMsgEntity;
import io.gongyu.gy.entity.responseParam.UserMsgEntity;
import io.gongyu.wechat.pay.entity.PaySuccessEntity;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserAllDao extends BaseMapper<UserAllEntity>{

	List<UserAllEntity> listUserGwAll(@Param("areaParam") String areaParam);

	void updateUserPerfectInformation(PerfectInformationEntity piParam);

	void updateSubsidy(UserSubsidyEntity subsidyParam);

	void updateGuaranteeMoney(GuaranteeMoneyEntity guaranteeMoneyParam);

	void saveGuaranteeMoneyRecord(GuaranteeMoneyEntity guaranteeMoneyParam);

	UserMsgEntity getUserById(Long userId, String mobile);

	void updateGuaranteeMoneyEmbody(GuaranteeMoneyEntity guaranteeMoneyParam);

	void updateGwMsgById(ApplicationGwEntity applicationGw);

	UserGwMsgEntity getGWRelationMsg(Integer gwId);

	WhoSeeMeEntity selectwsmMsg(Integer userId, Integer zhId);

	void saveWSM(WhoSeeMeEntity wsm);

	void saveBrowseRecord(Integer gwId, Integer zhId);

	List<GwZhIdEntity> listGwById(Integer userId);

	SearchRecordEntity userListBrowseRecord(Integer gwId);

	GwZhIdEntity selectBrowseRecord(Integer gwId, Integer zhId);

	GwZhIdEntity selectWhoSeeMe(Integer gwId, Integer zhId);

	List<WhoSeeMeEntity> listGwWhoSeeMe(Integer userId);

    List<GuaranteeMoneyEntity> listMoneyRecord(UserIdAndMobileEntity userIdAndMobileEntity);

    UserMsgEntity selectUserCompleteInformation(UserIdAndMobileEntity userIdAndMobile);

	void insertWxOrder(PaySuccessEntity payMessage);

	void updateModifySupervisorArea(String gwArea, String mobile);
}
