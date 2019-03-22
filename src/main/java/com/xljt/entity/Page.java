package com.xljt.entity;

import java.util.List;
import java.util.Map;

/**
 * 分页
 * @author ZX
 *
 */
public class Page {
	private int limit;
	private int page;
	private int count;
	private List<Map<String, Object>> list;
	
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Map<String, Object>> getList() {
		return list;
	}
	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}
	
}
