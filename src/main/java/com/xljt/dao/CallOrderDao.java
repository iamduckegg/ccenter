package com.xljt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.xljt.entity.CallBasicVo;
import com.xljt.entity.Page;

@Repository
public class CallOrderDao  {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 分页查询
	 * @param pages
	 * @param basicPo
	 * @return
	 */
	public Page findlist(Page pages,CallBasicVo basicPo) throws Exception{
		Page page = new Page();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT cb.ticket_id ticketId ,cb.ticket_num ticketNum,cb.client_name clientName,"
				+ "cb.phone,cb.car_number carNumber,d.type_name carType,cb.mileage,cb.fault_site faultSite,"
				+ "d2.type_name faultType,cb.call_date callDate,cb.fault_describe faultDescribe,"
				+ "cb.client_claim clientClaim,cb.dispose_result disposeResult,d3.type_name opinion,cb.check_result checkResult,"
				+ "cb.ticket_status ticketStatus ,cb.subject ,cb.priority_level priorityLevel , d4.type_name servicerName, "
				+ "cb.ticket_template_id ticketTemplateId , cs.finish_repair_date finishDate");
		sql.append(" FROM call_basic cb "
				+ " LEFT JOIN dic d ON cb.car_type = d.code_type "
				+ " LEFT JOIN dic d2 ON cb.fault_type = d2.code_type"
				+ " LEFT JOIN dic d3 ON cb.opinion = d3.code_type"
				+ " LEFT JOIN call_servicer cs ON cb.ticket_id = cs.ticket_id"
				+ " LEFT JOIN dic d4 ON cs.servicer_user_id = d4.code_type"
				+ " where 1=? " );
		String sqlc = "select count(1) from call_basic cb where 1=? ";
		List<Object> paramList = new ArrayList<Object>();
		paramList.add("1");
		if(!StringUtils.isEmpty(basicPo.getTicketNum())){
			sql.append(" and  cb.ticket_num like ? ");
			sqlc += " and cb.ticket_num like ?";
			paramList.add("%"+basicPo.getTicketNum()+"%");
		}
		if(!StringUtils.isEmpty(basicPo.getClientName())){
			sql.append(" and  cb.client_name = ? ");
			sqlc += " and cb.client_name = ?";
			paramList.add(basicPo.getClientName());
		}
		if(!StringUtils.isEmpty(basicPo.getSubject())){
			sql.append(" and  cb.subject like ? ");
			sqlc += " and cb.subject like ?";
			paramList.add("%"+basicPo.getSubject()+"%");
		}
		if(!StringUtils.isEmpty(basicPo.getPhone())){
			sql.append(" and  cb.phone like ? ");
			sqlc += " and cb.phone like ?";
			paramList.add("%"+basicPo.getPhone()+"%");
		}
		if(!StringUtils.isEmpty(basicPo.getCarNumber())){
			sql.append(" and  cb.car_number like ? ");
			sqlc += " and cb.car_number like ?";
			paramList.add("%"+basicPo.getCarNumber()+"%");
		}
		if(!StringUtils.isEmpty(basicPo.getFaultType())){
			sql.append(" and  cb.fault_type = ? ");
			sqlc += " and cb.fault_type = ?";
			paramList.add(basicPo.getFaultType());
		}
		if(!StringUtils.isEmpty(basicPo.getTicketStatus())){
			sql.append(" and  cb.ticket_status = ? ");
			sqlc += " and cb.ticket_status = ?";
			paramList.add(basicPo.getTicketStatus());
		}
		if(!StringUtils.isEmpty(basicPo.getServicerUserId())){
			sql.append(" and  cs.servicer_user_id = ? ");
			sqlc += " and cs.servicer_user_id = ?";
			paramList.add(basicPo.getServicerUserId());
		}
		if(!StringUtils.isEmpty(basicPo.getPriorityLevel())){
			sql.append(" and  cb.priority_level = ? ");
			sqlc += " and cb.priority_level = ?";
			paramList.add(basicPo.getPriorityLevel());
		}
		if(!StringUtils.isEmpty(basicPo.getTicketTemplateId())){
			sql.append(" and  cb.ticket_template_id = ? ");
			sqlc += " and cb.ticket_template_id = ?";
			paramList.add(basicPo.getTicketTemplateId());
		}
		
		if(!StringUtils.isEmpty(basicPo.getStartDate())&&!StringUtils.isEmpty(basicPo.getEndDate())){
			sql.append(" and  cb.call_date BETWEEN ? AND ? ");
			sqlc += " and cb.call_date BETWEEN ? AND ? ";
			paramList.add(basicPo.getStartDate());
			paramList.add(basicPo.getEndDate());
		}
		
		sql.append(" ORDER BY cb.create_date DESC ");
		sql.append(" limit " + ((pages.getPage()-1)*pages.getLimit()) + "," + pages.getLimit());
		Object[] params = paramList.toArray();
		Integer count = jdbcTemplate.queryForObject(sqlc, params, Integer.class);
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString(), params);
		page.setList(list);
		page.setCount(count);
		return page; 
	}
	
	/**
	 * 基础信息与维修服务信息
	 * @return
	 */
	public Map<String,Object> getBasicAndServicer(String ticketId) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		String sql = " SELECT"
						+ " cb.ticket_id AS ticketId,"
						+ " cb.ticket_num AS ticketNum,"
						+ " cb.client_name AS clientName,"
						+ " cb.phone,"
						+ " cb.car_number AS carNumber,"
						+ " d.type_name AS carType,"
						+ " cb.mileage,"
						+ " cb.fault_site AS faultSite,"
						+ " d2.type_name AS faultType,"
						+ " cb.call_date AS callDate,"
						+ " cb.fault_describe AS faultDescribe,"
						+ " cb.client_claim AS clientClaim,"
						+ " cb.dispose_result AS disposeResult,"
						+ " d3.type_name opinion,"
						+ " cb.check_result AS checkResult,"
						+ " cb.create_date AS createDate,"
						+ " cb.update_date AS updateDate,"
						+ " d4.type_name AS servicerUserId,"
						+ " cs.begin_repair_date AS beginRepairDate,"
						+ " cs.finish_repair_date AS finishRepairDate,"
						+ " cs.repair_user_name AS repairUserName,"
						+ " cs.repair_site AS repairSite,"
						+ " cs.repair_company AS repairCompany,"
						+ " cs.fault_detection AS faultDetection,"
						+ " cc.vin,"
						+ " cc.engine_number engineNumber"
						+ " FROM"
						+ " call_basic AS cb"
						+ " INNER JOIN call_servicer AS cs ON cb.ticket_id = cs.ticket_id "
						+ " LEFT JOIN dic d ON cb.car_type = d.code_type "
						+ " LEFT JOIN dic d2 ON cb.fault_type = d2.code_type"
						+ " LEFT JOIN dic d3 ON cb.opinion = d3.code_type"
						+ " LEFT JOIN call_car cc ON cb.car_number=cc.car_number "
						+ " LEFT JOIN dic d4 ON cs.servicer_user_id = d4.code_type "
						+ " WHERE cb.ticket_id = " + ticketId;
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString());
		map=list.get(0);
		return map;
	}
	
	/**
	 * 救援详情
	 * @param ticketId
	 * @return
	 */
	public List<Map<String, Object>> getRescueDetail(String ticketId) throws Exception{
		String sql = "SELECT"
					+ " rd.ticket_id AS ticketId,"
					+ " d.type_name AS rescueType,"
					+ " rd.rescue_site AS rescueSite,"
					+ " rd.rescue_end AS rescueEnd,"
					+ " rd.kilometre,"
					+ " rd.unit_price AS unitPrice,"
					+ " rd.other_cost AS otherCost,"
					+ " rd.amount,"
					+ " rd.remark,"
					+ " rd.row_id AS rowId"
					+ " FROM rescue_detail AS rd"
					+ " LEFT JOIN dic d ON rd.rescue_type = d.code_type"
					+ " WHERE"
					+ " rd.ticket_id = " + ticketId;
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString());
		return list;
	}
	
	/**
	 * 维修详情
	 * @param ticketId
	 * @return
	 */
	public List<Map<String, Object>> getRepairDetail(String ticketId) throws Exception{
		String sql = "SELECT"
					+ " rd.ticket_id AS ticketId,"
					+ " rd.parts_name AS partsName,"
					+ " rd.unit_price AS unitPrice,"
					+ " rd.parts_number AS partsNumber,"
					+ " rd.parts_amount AS partsAmount,"
					+ " rd.man_hour_price AS manHourPrice,"
					+ " rd.amount,"
					+ " d.type_name AS isFreeRepair,"
					+ " rd.remark,"
					+ " rd.row_id AS rowId"
					+ " FROM"
					+ " repiar_detail AS rd"
					+ " LEFT JOIN dic d ON rd.is_free_repair = d.code_type"
					+ " WHERE rd.ticket_id = " + ticketId;
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString());
		return list;
	}

}  
