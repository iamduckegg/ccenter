package com.xljt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.xljt.entity.CallBasicVo;
/**
 * 工单信息表
 * @author ZX
 */
@Repository
public class CallBasicDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 保存
	 * @param basic
	 */
	public void saveCallBasic(CallBasicVo basic) throws Exception{
		StringBuffer sql = new StringBuffer();
		Map<String, Object> map = getColumns(basic);
		
		sql.append("INSERT INTO call_basic ( ");
		
		sql.append(map.get("culmnSb")+") values ( "+ map.get("valueSb") + ") on duplicate key update "+ map.get("updateSb") );
		
		//System.out.println("基础表>>>>>>"+sql);
		
		jdbcTemplate.update(sql.toString());
		
	}
	
	/**
	 * 生成sql
	 * @param basic
	 * @return
	 */
	private Map<String,Object> getColumns(CallBasicVo basic) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		StringBuffer culmnSb =new StringBuffer();
		StringBuffer valueSb =new StringBuffer();
		StringBuffer updateSb =new StringBuffer();
		culmnSb.append("ticket_id ");	
		valueSb.append("'"+basic.getTicketId()+"'");	
		updateSb.append("ticket_id = '"+ basic.getTicketId() + "'");	
		
		if(!StringUtils.isEmpty(basic.getCreateDate())){
			culmnSb.append(",create_date");
			valueSb.append(",'"+basic.getCreateDate()+"'");
			updateSb.append(",create_date = '"+basic.getCreateDate()+"'");
		}
		if(!StringUtils.isEmpty(basic.getUpdateDate())){
			culmnSb.append(",update_date");
			valueSb.append(",'"+basic.getUpdateDate()+"'");
			updateSb.append(",update_date = '"+basic.getUpdateDate()+"'");
		}
		if(!StringUtils.isEmpty(basic.getTicketNum())){
			culmnSb.append(",ticket_num");
			valueSb.append(",'"+basic.getTicketNum()+"'");
			updateSb.append(",ticket_num = '"+basic.getTicketNum()+"'");
		}
		if(!StringUtils.isEmpty(basic.getClientName())){
			culmnSb.append(",client_name");
			valueSb.append(",'"+basic.getClientName()+"'");
			updateSb.append(",client_name = '"+basic.getClientName()+"'");
		}
		if(!StringUtils.isEmpty(basic.getPhone())){
			culmnSb.append(",phone");
			valueSb.append(",'"+basic.getPhone()+"'");
			updateSb.append(",phone = '"+basic.getPhone()+"'");
		}
		if(!StringUtils.isEmpty(basic.getCarNumber())){
			culmnSb.append(",car_number");
			valueSb.append(",'"+basic.getCarNumber()+"'");
			updateSb.append(",car_number = '"+basic.getCarNumber()+"'");
		}
		if(!StringUtils.isEmpty(basic.getCarType())){
			culmnSb.append(",car_type");
			valueSb.append(",'"+basic.getCarType()+"'");
			updateSb.append(",car_type = '"+basic.getCarType()+"'");
		}
		if(!StringUtils.isEmpty(basic.getMileage())){
			culmnSb.append(",mileage");
			valueSb.append(",'"+basic.getMileage()+"'");
			updateSb.append(",mileage = '"+basic.getMileage()+"'");
		}
		if(!StringUtils.isEmpty(basic.getFaultSite())){
			culmnSb.append(",fault_site");
			valueSb.append(",'"+basic.getFaultSite()+"'");
			updateSb.append(",fault_site = '"+basic.getFaultSite()+"'");
		}
		if(!StringUtils.isEmpty(basic.getFaultType())){
			culmnSb.append(",fault_type");
			valueSb.append(",'"+basic.getFaultType()+"'");
			updateSb.append(",fault_type = '"+basic.getFaultType()+"'");
		}
		if(!StringUtils.isEmpty(basic.getCallDate())){
			culmnSb.append(",call_date");
			valueSb.append(",'"+basic.getCallDate()+"'");
			updateSb.append(",call_date = '"+basic.getCallDate()+"'");
		}
		if(!StringUtils.isEmpty(basic.getFaultDescribe())){
			culmnSb.append(",fault_describe");
			valueSb.append(",'"+basic.getFaultDescribe()+"'");
			updateSb.append(",fault_describe = '"+basic.getFaultDescribe()+"'");
		}
		if(!StringUtils.isEmpty(basic.getClientClaim())){
			culmnSb.append(",client_claim");
			valueSb.append(",'"+basic.getClientClaim()+"'");
			updateSb.append(",client_claim = '"+basic.getClientClaim()+"'");
		}
		if(!StringUtils.isEmpty(basic.getDisposeResult())){
			culmnSb.append(",dispose_result");
			valueSb.append(",'"+basic.getDisposeResult()+"'");
			updateSb.append(",dispose_result = '"+basic.getDisposeResult()+"'");
		}
		if(!StringUtils.isEmpty(basic.getOpinion())){
			culmnSb.append(",opinion");
			valueSb.append(",'"+basic.getOpinion()+"'");
			updateSb.append(",opinion = '"+basic.getOpinion()+"'");
		}
		if(!StringUtils.isEmpty(basic.getCheckResult())){
			culmnSb.append(",check_result");
			valueSb.append(",'"+basic.getCheckResult()+"'");
			updateSb.append(",check_result = '"+basic.getCheckResult()+"'");
		}
		if(!StringUtils.isEmpty(basic.getTicketStatus())){
			culmnSb.append(",ticket_status");
			valueSb.append(",'"+basic.getTicketStatus()+"'");
			updateSb.append(",ticket_status = '"+basic.getTicketStatus()+"'");
		}
		if(!StringUtils.isEmpty(basic.getSubject())){
			culmnSb.append(",subject");
			valueSb.append(",'"+basic.getSubject()+"'");
			updateSb.append(",subject = '"+basic.getSubject()+"'");
		}
		if(!StringUtils.isEmpty(basic.getPriorityLevel())){
			culmnSb.append(",priority_level");
			valueSb.append(",'"+basic.getPriorityLevel()+"'");
			updateSb.append(",priority_level = '"+basic.getPriorityLevel()+"'");
		}
		if(!StringUtils.isEmpty(basic.getTicketTemplateId())){
			culmnSb.append(",ticket_template_id");
			valueSb.append(",'"+basic.getTicketTemplateId()+"'");
			updateSb.append(",ticket_template_id = '"+basic.getTicketTemplateId()+"'");
		}
		
		map.put("culmnSb", culmnSb);
		map.put("valueSb", valueSb);
		map.put("updateSb", updateSb);
		
		return map;
	}
	
	
	
}
