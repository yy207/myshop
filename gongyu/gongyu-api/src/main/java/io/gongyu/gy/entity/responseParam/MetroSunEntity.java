package io.gongyu.gy.entity.responseParam;

import java.io.Serializable;

import lombok.Data;

@Data
public class MetroSunEntity implements Serializable {

	private static final long serialVersionUID = -5503828759267018867L;
	/**
	 * 地铁站名字
	 */
	private String subwayStation;
}
