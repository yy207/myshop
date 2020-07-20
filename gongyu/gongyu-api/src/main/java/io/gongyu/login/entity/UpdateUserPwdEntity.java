package io.gongyu.login.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class UpdateUserPwdEntity implements Serializable{

	private static final long serialVersionUID = -5357664566644120962L;
	@ApiModelProperty(value = "手机号")
	private String mobile;
	@ApiModelProperty(value = "原密码")
	private String password;
	@ApiModelProperty(value = "新密码")
	private String passwordTwo;
}
