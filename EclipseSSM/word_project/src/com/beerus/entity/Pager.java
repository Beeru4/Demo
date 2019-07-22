package com.beerus.entity;

import java.util.List;

/**
 * 分页帮助类
 * 
 * @author J.z
 *
 */
public class Pager<T> {
	private int currPageNo; // 当前页码
	private int totalRow;// 总行数
	private int totalPager;// 总页码
	private int pageSize;// 当前页码
	private List<T> datas;// 查询出来的数据

	public int getCurrPageNo() {
		return currPageNo;
	}

	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public int getTotalPager() {
		return totalPager;
	}

	public void setTotalPager(int totalPager) {
		this.totalPager = totalPager;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

}
