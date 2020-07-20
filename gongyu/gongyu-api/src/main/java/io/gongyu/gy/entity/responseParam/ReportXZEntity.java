package io.gongyu.gy.entity.responseParam;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
/**
 * 举报选项
 * @author Administrator
 *
 */
@Data
@TableName("gongyu_report_xz")
public class ReportXZEntity implements Serializable{

	private static final long serialVersionUID = -5499078743055765892L;
	private Integer id;
	private String reportName;
}
