package io.gongyu.wechat.pay.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * @author Mr.wang
 * @version 2019年12月11日 下午4:11:07
 * 
 */
@Data
public class WxpayEntity implements Serializable {

	private static final long serialVersionUID = -7989728199968636556L;
	@ApiModelProperty(value = "code码")
	private String code;
	@ApiModelProperty(value = "金额")
	private String moneyType;
	@ApiModelProperty(value = "APP和网页支付提交用户端ip")
	private String spbillCreateIp;
	@ApiModelProperty(value = "openID")
	private String openId;
	@ApiModelProperty(value = "用户ID")
	private Integer userId;
	@ApiModelProperty(value = "用户手机号")
	private String mobile;
	@ApiModelProperty(value = "充值类型名称")
	private String payType;
}
