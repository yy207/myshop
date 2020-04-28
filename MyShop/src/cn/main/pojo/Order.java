package cn.main.pojo;
 
import java.util.ArrayList;
import java.util.List;
 

/**
 * 订单实体类类
 * @author sff
 *
 */
public class Order {
	private Integer id;//id
	private Integer uid;//外键用户id
	private String orderCode;//订单码
	private String createTime;//创建时间
	

	private String endTime;//创建时间
	private Double price;//价格
	private Integer state;//订单状态
	private String logidtics;//物流编码
	private Integer address;//收货地址外键
	
	
	private List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();

	
	public Integer getAddress() {
		return address;
	}

	public void setAddress(Integer address) {
		this.address = address;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getLogidtics() {
		return logidtics;
	}

	public void setLogidtics(String logidtics) {
		this.logidtics = logidtics;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	} 
}
