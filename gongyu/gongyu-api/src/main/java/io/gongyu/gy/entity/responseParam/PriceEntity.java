package io.gongyu.gy.entity.responseParam;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("gongyu_price")
public class PriceEntity implements Serializable {

	private static final long serialVersionUID = 4701812925431465042L;
	private Integer id;
	private String priceName;
}
