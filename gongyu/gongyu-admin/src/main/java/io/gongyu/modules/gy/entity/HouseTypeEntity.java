package io.gongyu.modules.gy.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("gongyu_house_type")
public class HouseTypeEntity implements Serializable {

	private static final long serialVersionUID = -5248880868428262636L;
	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 房间户型
	 */
	private String houseType;
}
