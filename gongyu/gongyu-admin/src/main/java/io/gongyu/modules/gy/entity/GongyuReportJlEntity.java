package io.gongyu.modules.gy.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 举报记录
 * 
 * @author 
 * @email 
 * @date 2020-04-27 10:13:37
 */
@Data
@TableName("gongyu_report_jl")
public class GongyuReportJlEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 被举报人id
	 */
	private Integer userId;

	/**
	 * 被举报人名称
	 */
	@TableField(exist = false)
	private String username;

	/**
	 * 被举报人电话
	 */
	@TableField(exist = false)
	private String mobile;
	/**
	 * 举报类型
	 */
	private String reportName;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 图片
	 */
	private String imger;
	/**
	 * 创建时间
	 */
	private Date creationTime;

}
