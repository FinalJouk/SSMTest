package com.newer.datang.data.util;

import java.util.List;

/**
 * 分页工具类
 * @author zxl
 * @param <T>
 */
public class PageBean<T> {
	List<T> data = null;
	/**总页数*/
	int totalPages;
	/** //页号（第几页）*/
	int pageNo;
	/**每一页的大小（每一页的记录总数）*/
	int pageSize;
	/**总记录数*/
	int totalRecords;
	
	
	public PageBean(List<T> data, int totalPages, int pageNo, int pageSize,
			int totalRecords) {
		super();
		this.data = data;
		this.totalPages = totalPages;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalRecords = totalRecords;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	@Override
	public String toString() {
		return "PageBean [data=" + data + ", totalPages=" + totalPages
				+ ", pageNo=" + pageNo + ", pageSize=" + pageSize + "]";
	}
	public PageBean(List<T> data, int totalPages, int pageNo, int pageSize) {
		super();
		this.data = data;
		this.totalPages = totalPages;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}
	public PageBean() {
		super();
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 总页数
	 * @return
	 */
	public int getTotalPages() {
		return (this.totalRecords +this.pageSize - 1)/this.pageSize;
	}
	
	/**
	 * 第一页
	 * @return
	 */
	public int getFirstPage() {
		return 1;
	}
	
	/**
	 * 最后一页
	 * @return
	 */
	public int getLastPage() {
		if (this.totalRecords == 0) {
			return 1;
		}
		return this.getTotalPages();
	}
	
	/**
	 * 前一页
	 * @return
	 */
	public int getPreviousPage() {
		if (this.pageNo == 1) {
			return 1;
		}
		return this.pageNo - 1;
	}
	
	/**
	 * 后一页
	 * @return
	 */
	public int getNextPage() {
		if (this.pageNo == this.getLastPage()) {
			return this.pageNo;
		}
		return this.pageNo + 1;
	}
}










