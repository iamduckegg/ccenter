package com.xljt.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	public List<Map<String, Object>> queryList(MClientEntity mcClientVo) {
		List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>(); 
		try {
			listMap = mcClientMapper.selectClientList(mcClientVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMap;
	}
	
	
	@Override
	public void saveClient(MClientEntity mcClientEntity){
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			mcClientEntity.setCreateDate(sdf.format(new Date()));
			mcClientEntity.setUpdateDate(sdf.format(new Date()));
			
			mcClientMapper.insertClient(mcClientEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
