package io.gongyu.gy.entity.responseParam;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 地址
 * @author Administrator
 *
 */
@Data
public class CityAddressOneEntity implements Serializable{

	private static final long serialVersionUID = -5532060091337648177L;
	
	//地区Id
	private Integer areaId;
	//地区父节点
	private Integer parentId;
	//地区编码
	private String areaCode;
	//地区名
	private String areaName;
	//城市编码
	private String cityCode;
	//城市中心点（即：经纬度坐标）
	private String center;
	//首字母拼音
	private String initial;
	//区县级
	private List<CityAddressTwoEntity> listPrefecture;
}
