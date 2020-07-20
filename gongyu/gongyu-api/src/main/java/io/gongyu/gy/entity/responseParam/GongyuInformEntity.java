package io.gongyu.gy.entity.responseParam;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统通知
 * 
 * @author 
 * @email 
 * @date 2020-04-29 16:27:53
 */
@Data
@TableName("gongyu_inform")
public class GongyuInformEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 内容
	 */
	private String descContent;

	/**
	 * 创建时间
	 */
	@TableField(value = "creationTime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date creationTime;

}
