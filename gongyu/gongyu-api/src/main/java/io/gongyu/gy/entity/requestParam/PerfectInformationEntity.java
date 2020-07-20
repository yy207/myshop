package io.gongyu.gy.entity.requestParam;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 	完善信息
 * @author Administrator
 *
 */
@Data
public class PerfectInformationEntity implements Serializable{

	
	private static final long serialVersionUID = -2175877702786589875L;
	@ApiModelProperty(value = "用户头像")
	private String userImg;
	@ApiModelProperty(value = "用户昵称")
	private String username;
	@ApiModelProperty(value = "手机号")
	private String mobile;
	@ApiModelProperty(value = "微信号")
	private String wechatUsername;
	@ApiModelProperty(value = "微信二维码")
	private String wechatImg;
}
