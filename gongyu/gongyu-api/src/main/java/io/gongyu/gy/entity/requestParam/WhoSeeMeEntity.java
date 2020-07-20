package io.gongyu.gy.entity.requestParam;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 谁看过我
 * @author Administrator
 *
 */
@Data
@TableName("gongyu_see_me")
public class WhoSeeMeEntity implements Serializable {

	private static final long serialVersionUID = -8921350572963464816L;
	@ApiModelProperty(value = "顾问id")
	private Integer gwId;
	@ApiModelProperty(value = "租户id")
	private Integer zhId;
	@ApiModelProperty(value = "租户头像")
	private String zhImg;
	@ApiModelProperty(value = "租户手机号")
	private String zhMobile;
	@ApiModelProperty(value = "这个参数不传")
	private String seeTime;
}
