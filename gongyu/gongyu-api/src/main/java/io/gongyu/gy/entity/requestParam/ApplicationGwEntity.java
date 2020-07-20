package io.gongyu.gy.entity.requestParam;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 申请顾问
 * @author Administrator
 *
 */
@Data
public class ApplicationGwEntity implements Serializable{

	private static final long serialVersionUID = 7078104603189123248L;
	@ApiModelProperty("用户id")
	private Long userId;
	@ApiModelProperty("手机号")
	private String mobile;
	@ApiModelProperty("顾问姓名")
	private String gwName;
	@ApiModelProperty("身份证号")
	private String identityCardNum;
	@ApiModelProperty("身份证图片正面")
	private String identityCardImgFront;
	@ApiModelProperty("身份证图片反面")
	private String identityCardImgReverse;
}
