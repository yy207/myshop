package cn.main.pojo;
/**
 * 属性实体类
 * @author sff
 *
 */
public class Property {
	private int id;//id
	private int gid;//商品id
	private String key;//键
	private String value;//值 集合
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
