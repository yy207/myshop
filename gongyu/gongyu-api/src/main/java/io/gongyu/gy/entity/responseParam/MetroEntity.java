package io.gongyu.gy.entity.responseParam;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class MetroEntity implements Serializable {

	private static final long serialVersionUID = 5732924868244649629L;
	/**
	 * 主键
	 */
	private Integer metroId;
	/**
	 * 地铁名字
	 */
	private String metroName;
	/**
	 * 地铁站名字
	 */
	private List<MetroSunEntity> stationName;
}
