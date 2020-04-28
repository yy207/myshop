package cn.main.utils;

import java.util.List;

/**
 * 分页工具
 * @author sff
 *
 */
public class Page {
	private int currentIndex;//当前页
	private int totalCount;//总条数
	private int pageSize=5;//每页显示条数
	private int pageCount;//总页数 
 

	public Page(){} 
	public Page(int pageSize){this.pageSize = this.pageSize;} 
	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		this.pageCount = this.totalCount%this.pageSize==0?
				this.totalCount/this.pageSize:(this.totalCount/this.pageSize+1);
		
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
}
