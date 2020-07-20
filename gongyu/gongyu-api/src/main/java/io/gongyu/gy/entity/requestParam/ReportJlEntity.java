package io.gongyu.gy.entity.requestParam;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 添加举报记录
 * @author Administrator
 *
 */
@Data
public class ReportJlEntity implements Serializable{

	private static final long serialVersionUID = -3566949846702462451L;
	@ApiModelProperty("用户id")
	private Integer userId;
	@ApiModelProperty("举报类型")
	private String reportName;
	@ApiModelProperty("描述")
	private String description;
	@ApiModelProperty("图片")
	private String imger;
}
