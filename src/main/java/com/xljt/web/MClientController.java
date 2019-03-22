package com.xljt.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xljt.entity.MClientEntity;
import com.xljt.service.MClientService;

@Controller
@RequestMapping(value="contract/client")
public class MClientController {
	
	@Autowired
	private MClientService mClientService;
	
	private static Logger logger = LoggerFactory.getLogger(MClientController.class);
	
	@RequestMapping("")
	public ModelAndView toMain(HttpServletRequest request, MClientEntity mClientEntity){
		ModelAndView mv = new ModelAndView("contract/client/main");
		return mv;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> list(HttpServletRequest request, MClientEntity mClientEntity){
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(Integer.parseInt(request.getParameter("page")) , Integer.parseInt(request.getParameter("limit")));
		List<Map<String, Object>> list = mClientService.queryList(mClientEntity);
		PageInfo<Map<String, Object>> pagein = new PageInfo<>(list);
		List<Map<String, Object>> result = pagein.getList();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pagein.getTotal());
		map.put("data", result);
		return map;
	}
	
	@RequestMapping("/toAdd")
	public ModelAndView toAdd(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("contract/client/add");
		return mv;
	}
	
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(HttpServletRequest request, MClientEntity mClientEntity){
		ModelAndView mv = new ModelAndView("contract/client/edit");
		Map<String, Object> client = mClientService.queryObject(mClientEntity);
		JSONObject json =  new JSONObject(client);
		mv.addObject("client", json);
		return mv;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> saveClient(MClientEntity mClientEntity){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			mClientService.saveClient(mClientEntity);
			logger.info("客户信息保存成功。");
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", "success");
		return map;
	}
	
	@RequestMapping("/modify")
	@ResponseBody
	public Map<String, Object> modifyClient(MClientEntity mClientEntity){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			mClientService.modifyClient(mClientEntity);
			logger.info("客户信息修改成功。");
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", "success");
		return map;
	}
	
	@RequestMapping("/remove")
	@ResponseBody
	public Map<String, Object> removeClient(String clientIds){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			mClientService.removeClient(clientIds);
			logger.info("客户信息删除成功。");
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", "success");
		return map;
	}

}
