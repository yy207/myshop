package cn.main.pojo;
/**
 * 分类实体类
 * @author sff
 *
 */
public class Category {
	private int id;//id
	private String name;//类型名称
	private int parentId;//父id
	private int type;//分类 1 2 3 
	private String iconClass;//图标类
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getIconClass() {
		return iconClass;
	}
	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}
	
	
	
}
