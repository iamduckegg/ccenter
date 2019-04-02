package com.xljt.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.xljt.common.Basic;
import com.xljt.dao.CallBasicDao;
import com.xljt.dao.CallOrderDao;
import com.xljt.dao.CallServicerDao;
import com.xljt.dao.RepairDetailDao;
import com.xljt.dao.RescueDetailDao;
import com.xljt.entity.CallBasicVo;
import com.xljt.entity.CallServicerVo;
import com.xljt.entity.Page;
import com.xljt.entity.RepairDetailVo;
import com.xljt.entity.RescueDetailVo;
import com.xljt.service.CallOrderService;
import com.xljt.utils.SSLUtil;
import com.xljt.web.CallOrderController;

@Service
public class CallOrderServiceImpl implements CallOrderService{
	
	@Autowired
	private CallOrderDao callOrderDao;

	@Autowired
	private CallBasicDao callBasicDao;
	
	@Autowired
	private CallServicerDao callServiceDao;
	
	@Autowired
	private RescueDetailDao rescueDetailDao;
	
	@Autowired
	private RepairDetailDao repairDetailDao;
	
	private static Logger logger = LoggerFactory.getLogger(CallOrderController.class);
	/**
	 * 分页查询
	 */
	@Override
	public Page queryList(Page pages,CallBasicVo basicPo) throws Exception{
		Page page = callOrderDao.findlist(pages,basicPo);
		return page;
	}
	
	/**
	 * 查询工单
	 * @param ticketId
	 * @return
	 */
	@Override
	@Transactional
	public Map<String,Object> queryOrder(String ticketId) throws Exception{
		Map<String,Object> map = new HashMap<>();
		Map<String, Object> basicAndServicer = callOrderDao.getBasicAndServicer(ticketId);
		List<Map<String, Object>> rescueDetail = callOrderDao.getRescueDetail(ticketId);
		int rescueSum = 0;
		for (Map<String, Object> rescue : rescueDetail) {
			rescueSum += Integer.parseInt(rescue.get("amount").toString());
		}
		List<Map<String, Object>> repairDetail = callOrderDao.getRepairDetail(ticketId);
		
		List<Map<String, Object>> repairOne = new ArrayList<>();
		List<Map<String, Object>> repairTwo = new ArrayList<>();
		
		for (int i = 0; i < repairDetail.size(); i++) {
			if(i<8){
				repairOne.add(repairDetail.get(i));
			}else{
				repairTwo.add(repairDetail.get(i));
			}
		}
		
		int repairSum = 0;
		for (Map<String, Object> repair : repairDetail) {
			repairSum += Integer.parseInt(repair.get("amount").toString());
		}
		int allSum = rescueSum+repairSum;
		map.put("rescueSum", rescueSum);
		map.put("repairSum", repairSum);
		map.put("allSum", allSum);
		
		map.put("basicAndServicer", basicAndServicer);
		map.put("rescueDetail", rescueDetail);
		
		//map.put("repairDetail", repairDetail);
		map.put("repairOne", repairOne);
		map.put("repairTwo", repairTwo);
		
		map.put("repairCount", repairDetail.size());
		
		return map;
	}
	
	/**
	 * 数据获取
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@Override
	@Transactional
	public void copyData(){
		String str = null;
		String url = Basic.LISTURL;
		url= Basic.LISTURL + "&page="+1;
		
		try {
			str = SSLUtil.sslList(url, null);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}

		
		JSONObject basicObject = new JSONObject(str);
		JSONArray ticketsArray = basicObject.getJSONArray("tickets");
		
		for (int i=0;i<ticketsArray.length();i++) {
			
			JSONObject ticketsObject = ticketsArray.getJSONObject(i);
			try {
				this.saveCallBasic(ticketsObject);
			} catch (Exception e) {
				logger.error(e.toString());
			}
			try {
				this.saveCallService(ticketsObject);
			} catch (Exception e) {
				logger.error(e.toString());
			}
			try {
				this.saveRescueDetail(ticketsObject);
			} catch (Exception e) {
				logger.error(e.toString());
			}
			try {
				this.saveRepiarDetail(ticketsObject);
			} catch (Exception e) {
				logger.error(e.toString());
			}
		}
	}
	
	/**
	 * 保存工单
	 * @param ticketsArray
	 * @throws ParseException
	 */
	public void saveCallBasic(JSONObject ticketsObject) throws Exception{
		
		CallBasicVo basic = new CallBasicVo();
			
		String ticketId = ticketsObject.getString("ticketId");
		String faultDescribe = ticketsObject.getString("descript");
		String createDate = ticketsObject.getString("createDT");
		String updateDate = ticketsObject.getString("updateDT");
		String ticketStatus = ticketsObject.getString("ticketStatus");
		String subject = ticketsObject.getString("subject");
		String priorityLevel = ticketsObject.getString("priorityLevel");
		String ticketTemplateId = ticketsObject.getString("ticketTemplateId");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		String ticketNum = "BXD"+sdf.format(new Date())+"-"+ticketId;
		
		JSONArray customArray = ticketsObject.getJSONArray("custom_fields");
		
		Map<String,Object> customMap = new HashMap<String,Object>();
		
		for (int j=0;j<customArray.length();j++) {
			customMap.put(customArray.getJSONObject(j).getString("key"), customArray.getJSONObject(j).get("value"));
		}
		
		String clientName = StringUtils.isEmpty(customMap.get("field_4")) ? "" : customMap.get("field_4").toString();
		String phone = StringUtils.isEmpty(customMap.get("field_3")) ? "" : customMap.get("field_3").toString();
		String carNumber = StringUtils.isEmpty(customMap.get("field_7")) ? "" : customMap.get("field_7").toString();
		String carType = StringUtils.isEmpty(customMap.get("field_106")) ? "" : customMap.get("field_106").toString();
		String mileage = StringUtils.isEmpty(customMap.get("field_107")) ? "" : customMap.get("field_107").toString();
		String faultSite = StringUtils.isEmpty(customMap.get("field_15")) ? "" : customMap.get("field_15").toString();
		String faultType = StringUtils.isEmpty(customMap.get("field_109")) ? "" : customMap.get("field_109").toString();
		String callDate = StringUtils.isEmpty(customMap.get("field_108")) ? "" : customMap.get("field_108").toString();
		String clientClaim = StringUtils.isEmpty(customMap.get("field_6")) ? "" : customMap.get("field_6").toString();
		String disposeResult = StringUtils.isEmpty(customMap.get("field_110")) ? "" : customMap.get("field_110").toString();
		String opinion = StringUtils.isEmpty(customMap.get("field_28")) ? "" : customMap.get("field_28").toString();
		String checkResult = StringUtils.isEmpty(customMap.get("field_120")) ? "" : customMap.get("field_120").toString();
		
		basic.setTicketTemplateId(ticketTemplateId);
		basic.setSubject(subject);
		basic.setPriorityLevel(priorityLevel);
		basic.setTicketStatus(ticketStatus);
		basic.setTicketId(ticketId);
		basic.setTicketNum(ticketNum);
		basic.setFaultDescribe(faultDescribe);
		basic.setCallDate(callDate);
		basic.setCreateDate(createDate);
		basic.setUpdateDate(updateDate);
		basic.setClientName(clientName);
		basic.setPhone(phone);
		basic.setCarNumber(carNumber);
		basic.setCarType(carType);
		basic.setMileage(mileage);
		basic.setFaultSite(faultSite);
		basic.setFaultType(faultType);
		basic.setClientClaim(clientClaim);
		basic.setDisposeResult(disposeResult);
		basic.setOpinion(opinion);
		basic.setCheckResult(checkResult);
		
		callBasicDao.saveCallBasic(basic);
		
	}

	/**
	 * 保存维修
	 * @param ticketsObject
	 * @throws ParseException
	 */
	public void saveCallService(JSONObject ticketsObject) throws Exception{
		
		CallServicerVo servicer = new CallServicerVo();
		
		String ticketId = ticketsObject.getString("ticketId");
		String servicerUserId = ticketsObject.getString("servicerUserId");
		
		JSONArray customArray = ticketsObject.getJSONArray("custom_fields");
		Map<String,Object> customMap = new HashMap<String,Object>();
		
		for (int j=0;j<customArray.length();j++) {
			customMap.put(customArray.getJSONObject(j).getString("key"), customArray.getJSONObject(j).get("value"));
		}
		
		String beginRepairDate = StringUtils.isEmpty(customMap.get("field_112")) ? "" : customMap.get("field_112").toString();
		String finishRepairDate = StringUtils.isEmpty(customMap.get("field_22")) ? "" : customMap.get("field_22").toString();
		String repairUserName = StringUtils.isEmpty(customMap.get("field_113")) ? "" : customMap.get("field_113").toString();
		String repairSite = StringUtils.isEmpty(customMap.get("field_114")) ? "" : customMap.get("field_114").toString();
		String repairCompany = StringUtils.isEmpty(customMap.get("field_115")) ? "" : customMap.get("field_115").toString();
		String faultDetection = StringUtils.isEmpty(customMap.get("field_116")) ? "" : customMap.get("field_116").toString();
		
		servicer.setTicketId(ticketId);
		servicer.setServiceUserId(servicerUserId);
		servicer.setBeginRepairDate(beginRepairDate);
		servicer.setFinishRepairDate(finishRepairDate);
		servicer.setRepairUserName(repairUserName);
		servicer.setRepairSite(repairSite);
		servicer.setRepairCompany(repairCompany);
		servicer.setFaultDetection(faultDetection);
		
		callServiceDao.saveCallServicer(servicer);
	}
	
	/**
	 * 保存救援明细
	 * @param ticketsObject
	 * @throws ParseException
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public void saveRescueDetail(JSONObject ticketsObject) throws Exception{
		RescueDetailVo rescueDetail = new RescueDetailVo();
		String ticketId = ticketsObject.getString("ticketId");
		
		JSONArray customArray = ticketsObject.getJSONArray("custom_fields");
		Map<String,Object> customMap = new HashMap<String,Object>();
		
		for (int j=0;j<customArray.length();j++) {
			customMap.put(customArray.getJSONObject(j).getString("key"), customArray.getJSONObject(j).get("value"));
		}
		if(customMap.containsKey("field_121")){
			
			JSONArray rescueList = (JSONArray) customMap.get("field_121");
			for (int i = 0; i < rescueList.length(); i++) {
				String rescueType = StringUtils.isEmpty(rescueList.getJSONObject(i).getString("field_9")) ? "" : rescueList.getJSONObject(i).getString("field_9");
				String rescueSite = StringUtils.isEmpty(rescueList.getJSONObject(i).getString("field_10")) ? "" : rescueList.getJSONObject(i).getString("field_10");
				String rescueEnd = StringUtils.isEmpty(rescueList.getJSONObject(i).getString("field_11")) ? "" : rescueList.getJSONObject(i).getString("field_11");
				String kilometre = StringUtils.isEmpty(rescueList.getJSONObject(i).getString("field_12")) ? "" : rescueList.getJSONObject(i).getString("field_12");
				String unitPrice = StringUtils.isEmpty(rescueList.getJSONObject(i).getString("field_13")) ? "" : rescueList.getJSONObject(i).getString("field_13");
				String otherCost = StringUtils.isEmpty(rescueList.getJSONObject(i).getString("field_14")) ? "" : rescueList.getJSONObject(i).getString("field_14");
				int amount = !StringUtils.isEmpty(rescueList.getJSONObject(i).getString("field_15")) && isNumeric(rescueList.getJSONObject(i).getString("field_15")) ? rescueList.getJSONObject(i).getInt("field_15") : 0;
				String remark = StringUtils.isEmpty(rescueList.getJSONObject(i).getString("field_16")) ? "" : rescueList.getJSONObject(i).getString("field_16");
				int rowId = StringUtils.isEmpty(rescueList.getJSONObject(i).getInt("rowId")) ? 1 : rescueList.getJSONObject(i).getInt("rowId");
				
				rescueDetail.setTicketId(ticketId);
				rescueDetail.setRescueType(rescueType);
				rescueDetail.setRescueSite(rescueSite);
				rescueDetail.setRescueEnd(rescueEnd);
				rescueDetail.setKilometre(kilometre);
				rescueDetail.setUnitPrice(unitPrice);
				rescueDetail.setOtherCost(otherCost);
				rescueDetail.setAmount(amount);
				rescueDetail.setRemark(remark);
				rescueDetail.setRowId(rowId);
				
				rescueDetailDao.saveRescueDetail(rescueDetail);
			}
		}
	}
	
	/**
	 * 保存维修明细
	 * @param ticketsObject
	 * @throws ParseException
	 */
	public void saveRepiarDetail(JSONObject ticketsObject) throws Exception{
		RepairDetailVo repairDetail = new RepairDetailVo();
		String ticketId = ticketsObject.getString("ticketId");
		JSONArray customArray = ticketsObject.getJSONArray("custom_fields");
		
		Map<String,Object> customMap = new HashMap<String,Object>();
		for (int j=0;j<customArray.length();j++) {
			customMap.put(customArray.getJSONObject(j).getString("key"), customArray.getJSONObject(j).get("value"));
		}
		if(customMap.containsKey("field_122")){
			JSONArray repairsList = (JSONArray) customMap.get("field_122");
			for (int i = 0; i < repairsList.length(); i++) {
				String partsName = StringUtils.isEmpty(repairsList.getJSONObject(i).getString("field_1")) ? "" : repairsList.getJSONObject(i).getString("field_1");
				String unitPrice = StringUtils.isEmpty(repairsList.getJSONObject(i).getString("field_2")) ? "" : repairsList.getJSONObject(i).getString("field_2");
				String partsNumber = StringUtils.isEmpty(repairsList.getJSONObject(i).getString("field_3")) ? "" : repairsList.getJSONObject(i).getString("field_3");
				String partsAmount = StringUtils.isEmpty(repairsList.getJSONObject(i).getString("field_4")) ? "" : repairsList.getJSONObject(i).getString("field_4");
				String manHourPrice = StringUtils.isEmpty(repairsList.getJSONObject(i).getString("field_5")) ? "" : repairsList.getJSONObject(i).getString("field_5");
				int amount = !StringUtils.isEmpty(repairsList.getJSONObject(i).getString("field_6")) && isNumeric(repairsList.getJSONObject(i).getString("field_6")) ? repairsList.getJSONObject(i).getInt("field_6") : 0;
				String isFreeRepair = StringUtils.isEmpty(repairsList.getJSONObject(i).getString("field_7")) ? "" : repairsList.getJSONObject(i).getString("field_7");
				String remark = StringUtils.isEmpty(repairsList.getJSONObject(i).getString("field_8")) ? "" : repairsList.getJSONObject(i).getString("field_8");
				int rowId = StringUtils.isEmpty(repairsList.getJSONObject(i).getInt("rowId")) ? 1 : repairsList.getJSONObject(i).getInt("rowId");
			
				repairDetail.setTicketId(ticketId);
				repairDetail.setPartsName(partsName);
				repairDetail.setUnitPrice(unitPrice);
				repairDetail.setPartsNumber(partsNumber);
				repairDetail.setPartsAmount(partsAmount);
				repairDetail.setManHourPrice(manHourPrice);
				repairDetail.setAmount(amount);
				repairDetail.setIsFreeRepair(isFreeRepair);
				repairDetail.setRemark(remark);
				repairDetail.setRowId(rowId);
				
				repairDetailDao.saveRepairDetail(repairDetail);
			}
		}
	}
	/**
	 * 是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){
		for(int i = 0;i < str.length(); i ++){
			if (!Character.isDigit(str.charAt(i))){
				return false;
			}
		}  
		return true;
	}
	
}
