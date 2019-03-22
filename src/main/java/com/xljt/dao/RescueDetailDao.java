package com.xljt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.xljt.entity.RescueDetailVo;

/**
 * 救援明细
 * @author ZX
 */
@Repository
public class RescueDetailDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 保存
	 * @param rescue
	 */
	public void saveRescueDetail(RescueDetailVo rescue) throws Exception{
		StringBuffer sql = new StringBuffer();
		
		Map<String, Object> map = getColumns(rescue);
		
		sql.append("INSERT INTO rescue_detail ( ");
		
		sql.append(map.get("culmnSb")+") values ( "+ map.get("valueSb") + ") on duplicate key update "+ map.get("updateSb") );
		
		//System.out.println("救援明细>>>>>>"+sql);
		
		jdbcTemplate.update(sql.toString());
	}
	
	/**
	 * 生成sql
	 * @param rescue
	 * @return
	 */
	private Map<String,Object> getColumns(RescueDetailVo rescue) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		StringBuffer culmnSb =new StringBuffer();
		StringBuffer valueSb =new StringBuffer();
		StringBuffer updateSb =new StringBuffer();
		
		culmnSb.append("ticket_id ");	
		valueSb.append("'"+rescue.getTicketId()+"'");	
		updateSb.append("ticket_id = '"+ rescue.getTicketId() + "'");	
		
		culmnSb.append(",row_id ");	
		valueSb.append(","+rescue.getRowId());	
		updateSb.append(",row_id = "+ rescue.getRowId());	
		
		if(!StringUtils.isEmpty(rescue.getRescueType())){
			culmnSb.append(",rescue_type");
			valueSb.append(",'"+rescue.getRescueType()+"'");
			updateSb.append(",rescue_type = '"+ rescue.getRescueType()+"'");
		}
		if(!StringUtils.isEmpty(rescue.getRescueSite())){
			culmnSb.append(",rescue_site");
			valueSb.append(",'"+rescue.getRescueSite()+"'");
			updateSb.append(",rescue_site = '"+rescue.getRescueSite()+"'");
		}
		if(!StringUtils.isEmpty(rescue.getRescueEnd())){
			culmnSb.append(",rescue_end");
			valueSb.append(",'"+rescue.getRescueEnd()+"'");
			updateSb.append(",rescue_end = '"+rescue.getRescueEnd()+"'");
		}
		if(!StringUtils.isEmpty(rescue.getKilometre())){
			culmnSb.append(",kilometre");
			valueSb.append(","+rescue.getKilometre());
			updateSb.append(",kilometre = "+rescue.getKilometre());
		}
		if(!StringUtils.isEmpty(rescue.getUnitPrice())){
			culmnSb.append(",unit_price");
			valueSb.append(","+rescue.getUnitPrice());
			updateSb.append(",unit_price = "+rescue.getUnitPrice());
		}
		if(!StringUtils.isEmpty(rescue.getOtherCost())){
			culmnSb.append(",other_cost");
			valueSb.append(","+rescue.getOtherCost());
			updateSb.append(",other_cost = "+rescue.getOtherCost());
		}
		if(!StringUtils.isEmpty(rescue.getAmount())){
			culmnSb.append(",amount");
			valueSb.append(","+rescue.getAmount());
			updateSb.append(",amount = "+rescue.getAmount());
		}
		if(!StringUtils.isEmpty(rescue.getRemark())){
			culmnSb.append(",remark");
			valueSb.append(",'"+rescue.getRemark()+"'");
			updateSb.append(",remark = '"+rescue.getRemark()+"'");
		}
		
		map.put("culmnSb", culmnSb);
		map.put("valueSb", valueSb);
		map.put("updateSb", updateSb);
		
		return map;
	}
			
}
