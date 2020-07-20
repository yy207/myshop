package io.gongyu.modules.gy.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 地铁
 * @author 
 * @email 
 * @date 2020-04-20 16:52:12
 */
@Data
public class GongyuMetroEntity implements Serializable {
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
	 * 地铁名字
	 */
	private String metroName;

}
