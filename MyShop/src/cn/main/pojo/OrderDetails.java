package cn.main.pojo;
/**
 * 订单详情实体类
 * @author sff
 *
 */
public class OrderDetails {
	private Integer id;//id
	private Integer oid;//外键 订单id
	private Integer sid;//外键 订单id
	private Integer gid;//外键 商品id
	private Integer number;//商品的数量
	private double price;//商品的价格
	
	private Order order;
	private Good good;
	
	
	
	
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}


	
	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
	
	
}
