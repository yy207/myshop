package io.gongyu.gy.entity.responseParam;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserGwMsgEntity implements Serializable{

	private static final long serialVersionUID = 5910452794265640973L;
	private Long userId;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 微信账号
	 */
	private String wechatUsername;
	/**
	 * 微信二维码
	 */
	private String wechatImg;
}
