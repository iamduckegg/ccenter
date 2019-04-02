package com.xljt.common;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

import com.xljt.utils.SSLUtil;

public class GetOrderSerlet {
	/**
	 * 查询订单列表
	 * @return
	 */
	@SuppressWarnings("unused")
	public void getList(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("main.jsp");
		try {
			String str = SSLUtil.sslList(Basic.LISTURL, null);
			
			JSONObject jsonObject1 = new JSONObject(str);
			String str1 = jsonObject1.getString("next_page");
			JSONArray str2 = jsonObject1.getJSONArray("tickets");
			JSONArray jsonArray= new JSONArray(str);
			
			for(int i=0;i<jsonArray.length();i++){
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String ticketId = jsonObject.getString("ticketId");
				String subject = jsonObject.getString("field_4");
				
			}
			
			request.setAttribute("list", jsonArray);
		} catch (KeyManagementException | NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		}
	}
}
