package io.gongyu.gy.entity.requestParam;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class HouseParamEntity implements Serializable{

	private static final long serialVersionUID = 1742149480052267428L;
	/**
	 * 房子区域
	 */
	@ApiModelProperty(value = "区域")
	private	String houseArea;
	/**
	 * 地铁
	 */
	@ApiModelProperty(value = "地铁")
	private	String houseMetro;
	/**
	 * 地体站站名
	 */
	@ApiModelProperty(value = "地体站站名")
	private	String stationName;
	/**
	 * 房子价格
	 */
	@ApiModelProperty(value = "房子价格")
	private	String housePrice;
}
