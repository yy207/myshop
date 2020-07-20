package io.gongyu.gy.entity.responseParam;

import lombok.Data;

/**
 * 咨询记录
 * @author Administrator
 *
 */
@Data
public class SearchRecordEntity {

	private Long userId;
	private String userImg;
	private String username;
	private String subsidyMoney;
	private String installment;
	private String gwName;
	private String wechatUsername;
	private String wechatImg;
}
