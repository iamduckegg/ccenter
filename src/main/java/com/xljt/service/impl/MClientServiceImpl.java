package com.xljt.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xljt.entity.MClientEntity;
import com.xljt.mapper.MClientMapper;
import com.xljt.service.MClientService;

@Service
public class MClientServiceImpl implements MClientService {

	@Autowired
	private MClientMapper mcClientMapper;

	@Override
	public List<Map<String, Object>> queryList(MClientEntity mClientEntity) {
		List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>(); 
		try {
			listMap = mcClientMapper.selectClientList(mClientEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMap;
	}
	
	@Override
	public Map<String, Object> queryObject(MClientEntity mClientEntity) {
		Map<String, Object> map = new HashMap<String,Object>(); 
		try {
			map = mcClientMapper.selectClient(mClientEntity.getClientId()+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	@Override
	public void saveClient(MClientEntity mClientEntity){
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			mClientEntity.setCreateDate(sdf.format(new Date()));
			mClientEntity.setUpdateDate(sdf.format(new Date()));
			
			mcClientMapper.insertClient(mClientEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifyClient(MClientEntity mClientEntity) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mClientEntity.setUpdateDate(sdf.format(new Date()));
		
		try {
			mcClientMapper.updateClient(mClientEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeClient(String clientIds) {
		try {
			String[] clientIdArray = clientIds.split(",");
			for (int i = 0; i < clientIdArray.length; i++) {
				mcClientMapper.deleteClient(clientIdArray[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
