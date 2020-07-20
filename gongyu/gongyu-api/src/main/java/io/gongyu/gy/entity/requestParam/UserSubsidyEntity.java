package io.gongyu.gy.entity.requestParam;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 补贴设置
 * @author Administrator
 *
 */
@Data
public class UserSubsidyEntity implements Serializable{

	private static final long serialVersionUID = -3517872932387458665L;
	@ApiModelProperty(value = "手机号")
	@NotBlank(message="手机号不能为空")
	private String mobile;
	@ApiModelProperty(value = "补贴金额")
	private String subsidyMoney;
	@ApiModelProperty(value = "分期内容")
	private String installment;
}
