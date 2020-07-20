package io.gongyu.wechat.pay.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * @author Mr.wang
 * @version 2019年12月14日 上午9:52:00 企业转账到零钱
 */
@Data
public class PayTransferEntity implements Serializable {

	private static final long serialVersionUID = -7416703892098733988L;
	@ApiModelProperty(value = "支付给用户openid")
	private String openid;
	@ApiModelProperty(value = "企业付款金额")
	private String money;
}
