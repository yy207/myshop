package io.gongyu.gy.entity.requestParam;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 保证金
 * 
 * @author Administrator
 *
 */
@Data
public class GuaranteeMoneyEntity implements Serializable {

	private static final long serialVersionUID = -42784814057052360L;
	@ApiModelProperty(value = "用户id")
	private Long userId;
	@ApiModelProperty(value = "手机号")
	private String mobile;
	@ApiModelProperty(value = "金额")
	private String money;
	@ApiModelProperty(value = "操作")
	private String operationType;
	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date creationTime;
}
