package io.gongyu.wechat.pay.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * @author Mr.wang
 * @version 2019年12月14日 下午2:21:53
 * 
 */
@Data
public class PaySuccessEntity implements Serializable {

	private static final long serialVersionUID = -1420002483699249367L;
	@ApiModelProperty(value = "微信支付订单号")
	private String transactionId;
	@ApiModelProperty(value = "实际支付的订单金额:单位 分")
	private String totalFee;
	@ApiModelProperty(value = "商户订单号")
	private String outTradeNo;
	@ApiModelProperty(value = "业务结果")
	private String resultCode;
	@ApiModelProperty(value = "充值类型")
	private String payType;
	@ApiModelProperty(value = "用户Id")
	private String userId;
	@ApiModelProperty(value = "用户手机号")
	private String mobile;
	@ApiModelProperty(value = "支付完成时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date timeEnd;
}
