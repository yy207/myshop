package cn.main.pojo;

import java.util.Date;

/**
 * 地址实体类
 * @author sff
 *
 */
public class Address {
	private Integer id;//id
	private Integer uid;//用户id
	private String address;//地址
	private String createTime;//创建时间
	private Integer isDefault;//是否默认
	private String remark;//备注说明
	private String phone;//电话
	private String name;//
	
	private Integer city1;
	private Integer city2;
	private Integer city3;

	private City c1;
	private City c2;
	private City c3;
	
	
	 
	public City getC1() {
		return c1;
	}
	public void setC1(City c1) {
		this.c1 = c1;
	}
	public City getC2() {
		return c2;
	}
	public void setC2(City c2) {
		this.c2 = c2;
	}
	public City getC3() {
		return c3;
	}
	public void setC3(City c3) {
		this.c3 = c3;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCity1() {
		return city1;
	}
	public void setCity1(Integer city1) {
		this.city1 = city1;
	}
	public Integer getCity2() {
		return city2;
	}
	public void setCity2(Integer city2) {
		this.city2 = city2;
	}
	public Integer getCity3() {
		return city3;
	}
	public void setCity3(Integer city3) {
		this.city3 = city3;
	}
}
