package io.gongyu.modules.gy.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class PriceEntity implements Serializable{

	private static final long serialVersionUID = -4846223868646368741L;
	private Integer id;
	private String priceName;
}
