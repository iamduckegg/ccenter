package com.xljt.service;

import java.text.ParseException;
import java.util.Map;

import com.xljt.entity.CallBasicVo;
import com.xljt.entity.Page;

/**
 * 
 * @author ZX
 */
public interface CallOrderService {
	/**
	 * 分页查询
	 * @param pages
	 * @param basicPo
	 * @return
	 * @throws Exception 
	 */
	public Page queryList(Page pages,CallBasicVo basicPo) throws Exception;
	
	/**
	 * 查询工单
	 * @return
	 */
	public Map<String,Object> queryOrder(String ticketId) throws Exception;
	
	/**
	 * 数据获取
	 * @param request
	 * @throws ParseException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public void copyData();

}
