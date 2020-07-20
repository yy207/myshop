package io.gongyu.modules.gy.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 房源图片
 * 
 * @author 
 * @email 
 * @date 2020-04-22 15:23:52
 */
@Data
@TableName("gongyu_house_img")
public class GongyuHouseImgEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 房子id
	 */
	private Integer houseId;
	/**
	 *  房子名字
	 */
	private String houseName;
	/**
	 * 房子图片
	 */
	private String houseImger;
	/**
	 * 类型
	 */
	private String ident;

}
