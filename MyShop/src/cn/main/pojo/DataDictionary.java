package cn.main.pojo;
/**
 * 数据字典
 * @author sff
 *
 */
public class DataDictionary {
	private int id;//id
	private String keyCode;//类型代码
	private String keyName;//类型名称
	private int valueId;//值
	private String valueName; //值名称
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKeyCode() {
		return keyCode;
	}
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public int getValueId() {
		return valueId;
	}
	public void setValueId(int valueId) {
		this.valueId = valueId;
	}
	public String getValueName() {
		return valueName;
	}
	public void setValueName(String valueName) {
		this.valueName = valueName;
	}
	
	
	
	
	
}
