package io.gongyu.gy.entity.responseParam;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class AreaMetroEntity implements Serializable {

	private static final long serialVersionUID = 215291900149285309L;
	/**
	 * 主键
	 */
	@TableId
	private Integer areaId;
	/**
	 * 区域名
	 */
	private String areaName;
	/**
	 * 地铁信息
	 */
	private List<MetroEntity> listMetro;
}
