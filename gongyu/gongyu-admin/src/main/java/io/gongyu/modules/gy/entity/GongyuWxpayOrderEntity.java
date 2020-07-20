package io.gongyu.modules.gy.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 微信交易记录
 * 
 * @author 
 * @email 
 * @date 2020-05-11 09:33:39
 */
@Data
@TableName("gongyu_wxpay_order")
public class GongyuWxpayOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 微信支付订单号
	 */
	private String transactionId;
	/**
	 * 实际支付的订单金额:单位 分
	 */
	private String totalFee;
	/**
	 * 商户订单号
	 */
	private String outTradeNo;
	/**
	 * 业务结果
	 */
	private String resultCode;
	/**
	 * 充值类型
	 */
	private String payType;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 用户手机号
	 */
	private String mobile;
	/**
	 * 支付完成时间
	 */
	private Date timeEnd;

	/**
	 * 顾问姓名
	 */
	@TableField(exist = false)
	private String gwName;
}
