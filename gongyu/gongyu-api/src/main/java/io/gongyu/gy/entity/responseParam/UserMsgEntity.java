package io.gongyu.gy.entity.responseParam;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 用户详细信息
 * @author Administrator
 *
 */
@Data
@TableName("tb_user")
public class UserMsgEntity implements Serializable{

	private static final long serialVersionUID = -4678338731477795094L;
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
	private String password;
	/**
	 * 申请顾问
	 */
	private String sqStatus;
	/**
	 * 职位：1.租赁顾问2.租户
	 */
	private String position;
	/**
	 * 微信账号
	 */
	private String wechatUsername;
	/**
	 * 微信二维码
	 */
	private String wechatImg;
	/**
	 * 顾问姓名
	 */
	private String gwName;
	/**
	 * 身份证号
	 */
	private String identityCardNum;
	/**
	 * 身份证图片正面
	 */
	private String identityCardImgFront;
	/**
	 * 身份证图片反面
	 */
	private String identityCardImgReverse;
	/**
	 * 主管区域
	 */
	private String directorOfRegional;
	/**
	 * 补贴金额
	 */
	private String subsidyMoney;
	/**
	 * 分期内容
	 */
	private String installment;
	/**
	 * 顾问的保证金
	 */
	private String guaranteeMoney;
	/**
	 * 自己的邀请码
	 */
	private String myInvitationCode;
	/**
	 * 被邀请人邀请码
	 */
	private String otherInvitationCode;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	
}
