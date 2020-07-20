package io.gongyu.modules.gy.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 区域
 * 
 * @author 
 * @email 
 * @date 2020-04-20 16:52:12
 */
@Data
@TableName("gongyu_area")
public class GongyuAreaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer areaId;
	/**
	 * 区域名字
	 */
	private String areaName;

}
