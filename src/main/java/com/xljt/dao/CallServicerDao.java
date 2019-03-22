package com.xljt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.xljt.entity.CallServicerVo;

/**
 * 维修信息表
 * @author ZX
 */
@Repository
public class CallServicerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 保存
	 * @param service
	 */
	public void saveCallServicer(CallServicerVo service) throws Exception{
		StringBuffer sql = new StringBuffer();
		Map<String, Object> map = getColumns(service);
		
		sql.append("INSERT INTO call_servicer ( ");
		
		sql.append(map.get("culmnSb")+") values ( "+ map.get("valueSb") + ") on duplicate key update "+ map.get("updateSb") );
		
		//System.out.println("服务表>>>>>>"+sql);
		
		jdbcTemplate.update(sql.toString());
		
	}
	
	/**
	 * 生成sql
	 * @param servicer
	 * @return
	 */
	private Map<String,Object> getColumns(CallServicerVo servicer) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		StringBuffer culmnSb =new StringBuffer();
		StringBuffer valueSb =new StringBuffer();
		StringBuffer updateSb =new StringBuffer();
		culmnSb.append("ticket_id ");	
		valueSb.append("'"+servicer.getTicketId()+"'");	
		updateSb.append("ticket_id = '"+ servicer.getTicketId() + "'");	
		
		if(!StringUtils.isEmpty(servicer.getServiceUserId())){
			culmnSb.append(",servicer_user_id");
			valueSb.append(",'"+servicer.getServiceUserId()+"'");
			updateSb.append(",servicer_user_id = '"+servicer.getServiceUserId()+"'");
		}
		if(!StringUtils.isEmpty(servicer.getBeginRepairDate())){
			culmnSb.append(",begin_repair_date");
			valueSb.append(",'"+servicer.getBeginRepairDate()+"'");
			updateSb.append(",begin_repair_date = '"+servicer.getBeginRepairDate()+"'");
		}
		if(!StringUtils.isEmpty(servicer.getFinishRepairDate())){
			culmnSb.append(",finish_repair_date");
			valueSb.append(",'"+servicer.getFinishRepairDate()+"'");
			updateSb.append(",finish_repair_date = '"+servicer.getFinishRepairDate()+"'");
		}
		if(!StringUtils.isEmpty(servicer.getRepairUserName())){
			culmnSb.append(",repair_user_name");
			valueSb.append(",'"+servicer.getRepairUserName()+"'");
			updateSb.append(",repair_user_name = '"+servicer.getRepairUserName()+"'");
		}
		if(!StringUtils.isEmpty(servicer.getRepairSite())){
			culmnSb.append(",repair_site");
			valueSb.append(",'"+servicer.getRepairSite()+"'");
			updateSb.append(",repair_site = '"+servicer.getRepairSite()+"'");
		}
		if(!StringUtils.isEmpty(servicer.getRepairCompany())){
			culmnSb.append(",repair_company");
			valueSb.append(",'"+servicer.getRepairCompany()+"'");
			updateSb.append(",repair_company = '"+servicer.getRepairCompany()+"'");
		}
		if(!StringUtils.isEmpty(servicer.getFaultDetection())){
			culmnSb.append(",fault_detection");
			valueSb.append(",'"+servicer.getFaultDetection()+"'");
			updateSb.append(",fault_detection = '"+servicer.getFaultDetection()+"'");
		}
		
		map.put("culmnSb", culmnSb);
		map.put("valueSb", valueSb);
		map.put("updateSb", updateSb);
		
		return map;
	}
}
