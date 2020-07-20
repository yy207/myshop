package io.gongyu.gy.entity.responseParam;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("tb_user")
public class UserAllEntity implements Serializable {

	private static final long serialVersionUID = 9016219171650468831L;
	@ApiModelProperty(value = "用户id")
	@TableId
	private Integer userId;
	@ApiModelProperty(value = "用户头像")
	private String userImg;
	@ApiModelProperty(value = "用户姓名")
	private String gwName;
	@ApiModelProperty(value = "微信账号")
	private String wechatUsername;
	@ApiModelProperty(value = "微信二维码")
	private String wechatImg;
	@ApiModelProperty(value = "补贴金额")
	private String subsidyMoney;
	@ApiModelProperty(value = "分期内容")
	private String installment;
	@ApiModelProperty(value = "状态")
	private String identStatus;
}
