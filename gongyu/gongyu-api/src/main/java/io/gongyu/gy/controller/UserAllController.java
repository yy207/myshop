package io.gongyu.gy.controller;

import java.util.List;

import io.gongyu.common.exception.RRException;
import io.gongyu.gy.entity.requestParam.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.gongyu.common.utils.R;
import io.gongyu.gy.entity.responseParam.SearchRecordEntity;
import io.gongyu.gy.entity.responseParam.UserAllEntity;
import io.gongyu.gy.entity.responseParam.UserGwMsgEntity;
import io.gongyu.gy.entity.responseParam.UserMsgEntity;
import io.gongyu.gy.service.UserAllService;
import io.gongyu.util.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/userAll")
@Api(tags = "用户接口")
public class UserAllController {

    @Autowired
    private UserAllService userAllService;

    @GetMapping("/getUserById")
    @ApiOperation(value = "获取用户详细信息")
    public R getUserById(Long userId, String mobile) {
        UserMsgEntity list = userAllService.getUserById(userId, mobile);
        return R.ok().put("msg", list);
    }

    @GetMapping("/getGWRelationMsg")
    @ApiOperation(value = "查看顾问联系方式")
    public R getGWRelationMsg(WhoSeeMeEntity wsm) {
        UserGwMsgEntity list = userAllService.getGWRelationMsg(wsm);
        return R.ok().put("msg", list);
    }

    @GetMapping("/listUserGwAll")
    @ApiOperation(value = "顾问列表")
    public R listUserGwAll(@RequestParam("areaParam") String areaParam, Integer zhId) {
        List<UserAllEntity> list = userAllService.listUserGwAll(areaParam, zhId);
        return R.ok().put("msg", list);
    }

    @PostMapping("/updateGwMsgById")
    @ApiOperation(value = "申请成为顾问")
    public R updateGwMsgById(ApplicationGwEntity applicationGw) {
        String idNum = MD5Util.convertMD5(applicationGw.getIdentityCardNum());
        applicationGw.setIdentityCardNum(idNum);
        userAllService.updateGwMsgById(applicationGw);
        return R.ok();
    }

    @PostMapping("/updateUserPerfectInformation")
    @ApiOperation(value = "顾问-信息完善")
    public R updateUserPerfectInformation(PerfectInformationEntity piParam) {

            if(piParam.getMobile() != null){
                userAllService.updateUserPerfectInformation(piParam);
                return R.ok();
            }else {
                throw new RRException("mobile参数没有");
            }

    }
    @PostMapping("/updateModifySupervisorArea")
    @ApiOperation(value = "顾问-信息完善-修改主管区域")
    public R updateModifySupervisorArea(String gwArea , String mobile) {
            userAllService.updateModifySupervisorArea(gwArea,mobile);
            return R.ok();
    }

    @PostMapping("/updateSubsidy")
    @ApiOperation(value = "顾问-补贴设置")
    public R updateSubsidy(UserSubsidyEntity SubsidyParam) {
        userAllService.updateSubsidy(SubsidyParam);
        return R.ok();
    }

    @PostMapping("/updateGuaranteeMoneyShock")
    @ApiOperation(value = "顾问保证金-激纳")
    public R updateGuaranteeMoneyShock(GuaranteeMoneyEntity GuaranteeMoneyParam) {
        userAllService.updateGuaranteeMoney(GuaranteeMoneyParam);
        return R.ok();
    }

    @PostMapping("/updateGuaranteeMoneyEmbody")
    @ApiOperation(value = "顾问保证金-体现")
    public R updateGuaranteeMoneyEmbody(GuaranteeMoneyEntity GuaranteeMoneyParam) {
        userAllService.updateGuaranteeMoneyEmbody(GuaranteeMoneyParam);
        return R.ok();
    }

    @PostMapping("/userListBrowseRecord")
    @ApiOperation(value = "咨询记录")
    public R userListBrowseRecord(@RequestParam("userId") Integer userId) {
        List<SearchRecordEntity> list = userAllService.userListBrowseRecord(userId);
        return R.ok().put("msg", list);
    }

    @PostMapping("/listGwWhoSeeMe")
    @ApiOperation(value = "顾问-谁看过我")
    public R listGwWhoSeeMe(@RequestParam("userId") Integer userId) {
        List<WhoSeeMeEntity> list = userAllService.listGwWhoSeeMe(userId);
        return R.ok().put("msg", list);
    }

    @GetMapping("/listMoneyRecord")
    @ApiOperation(value = "查询保证金")
    public R listMoneyRecord(UserIdAndMobileEntity userIdAndMobileEntity) {
        List<GuaranteeMoneyEntity> list = userAllService.listMoneyRecord(userIdAndMobileEntity);
        return R.ok().put("msg", list);
    }

    @GetMapping("/selectUserCompleteInformation")
    @ApiOperation(value = "查看顾问信息是否完善")
    public R selectUserCompleteInformation(UserIdAndMobileEntity userIdAndMobile) {
        UserMsgEntity select = userAllService.selectUserCompleteInformation(userIdAndMobile);
        return R.ok().put("msg", "已完善");
    }

    @GetMapping("/updateGwMsgByIdFalse")
    @ApiOperation(value = "查看顾问信息是否完善")
    public R updateGwMsgByIdFalse(UserIdAndMobileEntity userIdAndMobile) {
        UserMsgEntity list = userAllService.updateGwMsgByIdFalse(userIdAndMobile);
        return R.ok();
    }

    @PostMapping("/mobileCode")
    @ApiOperation(value = "手机号验证")
    public R mobileCode(String mobile,String codeNum) {
        userAllService.mobileCode(codeNum,mobile);
        return R.ok();
    }
}
