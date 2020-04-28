package cn.main.pojo;

import java.util.Date;
import java.util.List;

/**
 * 商品实体类
 * @author sff
 *
 */
public class Good {
	private Integer id;//主键id
	private Integer sid;//外键用户id
	private String name;//名称
	private double price;//价格
	private Integer buyCount;//购买次数
	private Integer repertory;//库存
	private String picPath;//图片路径
	private String videoPath;//视频路径
	private String describe;//描述
	private Integer type1;//一级分类
	private Integer type2;///二级分类
	private Integer type3;//三级分类
	private Integer state;//状态
	private String createTime;//创建时间
	
	private Shop shop;
	private List<Image> images;//标题
	private List<Image> imagesDetail;//详细信息
	
	 
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public List<Image> getImagesDetail() {
		return imagesDetail;
	}
	public void setImagesDetail(List<Image> imagesDetail) {
		this.imagesDetail = imagesDetail;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	private Integer  count;//计数
	
	public Integer  getCount() {
		return count;
	}
	public void setCount(Integer  count) {
		this.count = count;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(Integer buyCount) {
		this.buyCount = buyCount;
	}
	public Integer getRepertory() {
		return repertory;
	}
	public void setRepertory(Integer repertory) {
		this.repertory = repertory;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getVideoPath() {
		return videoPath;
	}
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Integer getType1() {
		return type1;
	}
	public void setType1(Integer type1) {
		this.type1 = type1;
	}
	public Integer getType2() {
		return type2;
	}
	public void setType2(Integer type2) {
		this.type2 = type2;
	}
	public Integer getType3() {
		return type3;
	}
	public void setType3(Integer type3) {
		this.type3 = type3;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
	
	
	
	
	
	
	
	
}
