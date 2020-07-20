package io.gongyu.modules.gy.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 区域地铁站
 * @author 
 * @email 
 * @date 2020-04-20 16:52:12
 */
@Data
public class GongyuAreaMetroEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 地铁id
	 */
	private Integer metroId;
	/**
	 * 区域id
	 */
	private Integer areaId;
	/**
	 * 地铁站名字
	 */
	private String subwayStation;

}
