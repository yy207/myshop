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

	private Integer sid;//外键 订单id 商店id
	private Integer gid;//外键 商品id
	private Integer number;//商品的数量
	
	private Integer to;//收货id
	private String endTime;//创建时间
	private Double price;//价格
	private Integer state;//订单状态
	private String logidtics;//物流编码
	private Integer address;//收货地址外键
	private String orderCode;//订单码
	private String alipayCode;//alipay订单码
	private String createTime;//创建时间
	private String remark;//创建时间

	
	private List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();

	private Shop shop;
	private Good good;
	
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAlipayCode() {
		return alipayCode;
	}

	public void setAlipayCode(String alipayCode) {
		this.alipayCode = alipayCode;
	}

	public Integer getTo() {
		return to;
	}

	public void setTo(Integer to) {
		this.to = to;
	}

	public Shop getShop() { 
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
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
