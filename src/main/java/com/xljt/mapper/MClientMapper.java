package com.xljt.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xljt.entity.MClientEntity;

@Repository
public interface MClientMapper {

	/**
	 * 分页查询
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selectClientList(MClientEntity mcClientVo) throws Exception;
	/**
	 * 新增客户
	 */
	void insertClient (MClientEntity mcClientEntity) throws Exception;
}
