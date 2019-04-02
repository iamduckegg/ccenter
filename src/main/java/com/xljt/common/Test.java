package com.xljt.common;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.util.StringUtils;

import com.xljt.entity.RepairDetailVo;
import com.xljt.utils.SSLUtil;

public class Test {
	public static void main(String[] args) {
		try {
			RepairDetailVo repairDetail = new RepairDetailVo();
			
			String str = SSLUtil.sslList(Basic.DETAILURL, null);
			
			JSONObject basicObject = new JSONObject(str);
			
			
			JSONObject ticketObject = basicObject.getJSONObject("ticket");

			String ticketId = ticketObject.getString("ticketId");
			
			JSONArray customArray = ticketObject.getJSONArray("custom_fields");
			
			
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
					int amount = StringUtils.isEmpty(repairsList.getJSONObject(i).getString("field_6")) && isNumeric(repairsList.getJSONObject(i).getString("field_6")) ?  0 : repairsList.getJSONObject(i).getInt("field_6");
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
					
					System.out.println(repairDetail);
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
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
