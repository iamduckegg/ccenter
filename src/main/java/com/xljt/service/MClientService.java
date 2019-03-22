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
	 * 保存客户
	 * @return
	 * @throws Exception
	 */
	public void saveClient(MClientEntity mClientEntity);
}
