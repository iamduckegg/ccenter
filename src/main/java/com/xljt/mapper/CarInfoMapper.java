package com.xljt.mapper;

import java.util.List;
import java.util.Map;

public interface CarInfoMapper {

	/**
	 * 分页查询
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectCarInfoList() throws Exception;
}
