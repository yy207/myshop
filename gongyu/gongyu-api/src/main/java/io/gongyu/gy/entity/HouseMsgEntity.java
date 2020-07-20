package io.gongyu.gy.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class HouseMsgEntity implements Serializable{

	private static final long serialVersionUID = 5537115272867946201L;

	/**
	 * 主键
	 */
	@TableId
	private Integer houseId;
	/**
	 * 房子名称
	 */
	private	String	houseName;
	/**
	 * 房子区域
	 */
	private	String	houseArea;
	/**
	 * 房子附近地铁
	 */
	private	String	houseMetro;
	/**
	 * 地体站站名
	 */
	private	String	stationName;
	/**
	 * 房子顾问
	 */
	private	String	houseCounselor;
	/**
	 * 房子价格
	 */
	private	String	housePrice;
	/**
	 * 房子介绍
	 */
	private	String	houseDesc;
	/**
	 * 房子图片
	 */
	private	String	houseImg;
	/**
	 * 房子户型
	 */
	private	String	houseType;
}
