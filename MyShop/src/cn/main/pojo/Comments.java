package cn.main.pojo;

import java.util.List;
/**
 * 评论类
 * @author sff
 *
 */
public class Comments {
	private Integer id;//id
	private Integer uid;//用户
	private Integer gid;//商店
	private String createTime;//time
	private String content;//content
	
	private List<Image> images;

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
	public Integer getGid() {
		return gid;
	} 
	public void setGid(Integer gid) {
		this.gid = gid;
	} 
	public String getCreateTime() {
		return createTime;
	} 
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	} 
	public String getContent() {
		return content;
	} 
	public void setContent(String content) {
		this.content = content;
	} 
	public List<Image> getImages() {
		return images;
	} 
	public void setImages(List<Image> images) {
		this.images = images;
	} 
}

