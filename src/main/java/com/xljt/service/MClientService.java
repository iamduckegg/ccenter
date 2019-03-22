package com.xljt.service;

import java.util.List;
import java.util.Map;

import com.xljt.entity.MClientEntity;

public interface MClientService {
	
	/**
	 * 分页查询
	 * @param mClientEntity
	 * @return
	 */
	public List<Map<String, Object>> queryList(MClientEntity mClientEntity);
	/**
	 * 查询实例
	 * @param mClientEntity
	 * @return
	 */
	public Map<String, Object> queryObject(MClientEntity mClientEntity);
	/**
	 * 保存客户
	 * @return
	 * @throws Exception
	 */
	public void saveClient(MClientEntity mClientEntity);
	
	/**
	 * 修改客户
	 * @param mClientEntity
	 */
	public void modifyClient(MClientEntity mClientEntity);
	
	/**
	 * 删除
	 * @param mClientEntity
	 */
	public void removeClient(String clientIds);
}
