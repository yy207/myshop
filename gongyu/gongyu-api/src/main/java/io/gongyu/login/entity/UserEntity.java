package io.gongyu.login.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户
 *
 */
@Data
@TableName("tb_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@TableId
	private Long userId;
	/**
	 * 用户头像
	 */
	private String userImg;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 密码
	 */
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	/**
	 * 申请状态
	 */
	private Integer sqStatus;
	/**
	 * 职位
	 */
	private Integer position;
	/**
	 * 微信账号
	 */
	private String wechatUsername;
	/**
	 * 微信二维码
	 */
	private String wechatImg;
	/**
	 *主管区域
	 */
	private String directorOfRegional;
	/**
	 * 顾问姓名
	 */
	private String gwName;
	/**
	 *补贴金额
	 */
	private String subsidyMoney;
	/**
	 * 分期内容
	 */
	private String installment;
	/**
	 * 保证金
	 */
	private String guaranteeMoney;
	/**
	 * 状态1.正常2.禁用
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

}
