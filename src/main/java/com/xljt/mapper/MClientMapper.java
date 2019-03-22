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
	List<Map<String, Object>> selectClientList(MClientEntity mClientEntity) throws Exception;
	/**
	 * 查询实例
	 * @param clientId
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> selectClient(String clientId) throws Exception;
	/**
	 * 保存
	 * @param mClientEntity
	 * @throws Exception
	 */
	void insertClient (MClientEntity mClientEntity) throws Exception;
	/**
	 * 修改
	 * @param mClientEntity
	 * @throws Exception
	 */
	void updateClient (MClientEntity mClientEntity) throws Exception;
	/**
	 * 删除
	 * @param clientId
	 * @throws Exception
	 */
	void deleteClient (String clientId) throws Exception;
}
