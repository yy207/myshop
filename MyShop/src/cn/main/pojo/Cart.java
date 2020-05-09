package cn.main.pojo;
/**
 * 购物车实体类
 * @author sff
 *
 */
public class Cart {
	private int id;//id
	private int uid;//用户，购物车外键
	private int gid;//商品外键
	private int number;//商品数量
	private double price;//价格
	
	private Good good;//商品

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	} 
}
