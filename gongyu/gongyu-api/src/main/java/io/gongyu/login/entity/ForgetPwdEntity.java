package io.gongyu.login.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 忘记密码
 * @author Administrator
 *
 */
@Data
public class ForgetPwdEntity implements Serializable{

	private static final long serialVersionUID = -3882952462631040732L;
	
	@ApiModelProperty(value = "手机号")
	private String mobile;
	@ApiModelProperty(value = "密码")
	private String password;
	@ApiModelProperty(value = "二次密码")
	private String passwordTwo;
	@ApiModelProperty(value = "验证码")
    private String verifyCode;

}
