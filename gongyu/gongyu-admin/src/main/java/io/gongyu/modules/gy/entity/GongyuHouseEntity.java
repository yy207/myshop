package io.gongyu.modules.gy.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 房源-房子信息
 * 
 * @author 
 * @email 
 * @date 2020-04-17 15:41:56
 */
@Data
@TableName("gongyu_house")
public class GongyuHouseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer houseId;
	/**
	 * 房子名称
	 */
	private String houseName;
	/**
	 * 区域id
	 */
	private Integer areaId;
	/**
	 * 房子区域
	 */
	private String houseArea;
	/**
	 * 地铁id
	 */
	private Integer metroId;
	/**
	 * 房子附近地铁
	 */
	private String houseMetro;
	/**
	 * 地体站站名
	 */
	private String stationName;
	/**
	 * 顾问id
	 */
	private Integer counselorId;
	/**
	 * 房子顾问
	 */
	private String houseCounselor;
	/**
	 * 房子价格
	 */
	private String housePrice;
	/**
	 * 房子介绍
	 */
	private String houseDesc;
	/**
	 * 房子图片
	 */
	private String houseImg;
	/**
	 * 房子添加时间
	 */
	private Date houseTime;
	/**
	 * 房子户型
	 */
	private String houseType;

}
