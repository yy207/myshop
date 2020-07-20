package io.gongyu.modules.gy.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 保证金-记录
 * 
 * @author 
 * @email 
 * @date 2020-04-27 10:17:42
 */
@Data
@TableName("gongyu_money_record")
public class GongyuMoneyRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 用户id
	 */
	private Integer userId;

	@TableField(exist = false)
	private String  username;
	/**
	 * 用户手机号
	 */
	private String mobile;
	/**
	 * 金额
	 */
	private String money;
	/**
	 * 操作类型
	 */
	private String operationType;
	/**
	 * 创建时间
	 */
	private Date creationTime;

}
