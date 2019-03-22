package com.xljt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.xljt.entity.RepairDetailVo;

/**
 * 维修明细
 * @author ZX
 */
@Repository
public class RepairDetailDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 保存
	 * @param repairDetail
	 */
	public void saveRepairDetail(RepairDetailVo repair) throws Exception{
		StringBuffer sql = new StringBuffer();
		
		Map<String, Object> map = getColumns(repair);
		
		sql.append("INSERT INTO repiar_detail ( ");
		
		sql.append(map.get("culmnSb")+") values ( "+ map.get("valueSb") + ") on duplicate key update "+ map.get("updateSb") );
		
		//System.out.println("维修明细>>>>>>"+sql);
		
		jdbcTemplate.update(sql.toString());	
	}
	
	/**
	 * 生成sql
	 * @param repair
	 * @return
	 */
	private Map<String,Object> getColumns(RepairDetailVo repair) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		StringBuffer culmnSb =new StringBuffer();
		StringBuffer valueSb =new StringBuffer();
		StringBuffer updateSb =new StringBuffer();
		
		culmnSb.append("ticket_id ");	
		valueSb.append("'"+repair.getTicketId()+"'");	
		updateSb.append("ticket_id = '"+ repair.getTicketId() + "'");	
		
		culmnSb.append(",row_id ");	
		valueSb.append(","+repair.getRowId());	
		updateSb.append(",row_id = "+ repair.getRowId());
		
		if(!StringUtils.isEmpty(repair.getPartsName())){
			culmnSb.append(",parts_name");
			valueSb.append(",'"+repair.getPartsName()+"'");
			updateSb.append(",parts_name = '"+repair.getPartsName()+"'");
		}
		if(!StringUtils.isEmpty(repair.getUnitPrice())){
			culmnSb.append(",unit_price");
			valueSb.append(",'"+repair.getUnitPrice()+"'");
			updateSb.append(",unit_price = '"+ repair.getUnitPrice()+"'");
		}
		if(!StringUtils.isEmpty(repair.getPartsNumber())){
			culmnSb.append(",parts_number");
			valueSb.append(",'"+repair.getPartsNumber()+"'");
			updateSb.append(",parts_number = '"+ repair.getPartsNumber()+"'");
		}
		if(!StringUtils.isEmpty(repair.getPartsAmount())){
			culmnSb.append(",parts_amount");
			valueSb.append(",'"+repair.getPartsAmount()+"'");
			updateSb.append(",parts_amount = '"+ repair.getPartsAmount()+"'");
		}
		if(!StringUtils.isEmpty(repair.getManHourPrice())){
			culmnSb.append(",man_hour_price");
			valueSb.append(",'"+repair.getManHourPrice()+"'");
			updateSb.append(",man_hour_price = '"+ repair.getManHourPrice()+"'");
		}
		if(!StringUtils.isEmpty(repair.getAmount())){
			culmnSb.append(",amount");
			valueSb.append(",'"+repair.getAmount()+"'");
			updateSb.append(",amount = '"+ repair.getAmount()+"'");
		}
		if(!StringUtils.isEmpty(repair.getIsFreeRepair())){
			culmnSb.append(",is_free_repair");
			valueSb.append(",'"+repair.getIsFreeRepair()+"'");
			updateSb.append(",is_free_repair = '"+repair.getIsFreeRepair()+"'");
		}
		if(!StringUtils.isEmpty(repair.getRemark())){
			culmnSb.append(",remark");
			valueSb.append(",'"+repair.getRemark()+"'");
			updateSb.append(",remark = '"+repair.getRemark()+"'");
		}
		
		map.put("culmnSb", culmnSb);
		map.put("valueSb", valueSb);
		map.put("updateSb", updateSb);
		return map;
	}
}
