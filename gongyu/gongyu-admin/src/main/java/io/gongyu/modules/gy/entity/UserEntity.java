package io.gongyu.modules.gy.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * 
 * @author 
 * @email 
 * @date 2020-04-21 18:11:59
 */
@Data
@TableName("tb_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
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
	private String password;
	/**
	 * 申请顾问状态
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
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 顾问姓名
	 */
	private String gwName;

}
