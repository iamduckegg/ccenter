package com.xljt.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xljt.entity.MClientEntity;

/**
 * 合同管理
 * @author ZX
 */
@Controller
@RequestMapping(value="contract")
public class ContractManageController {
	
	@RequestMapping("")
	public ModelAndView toMain(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("contract/main");
		return mv;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> findList(){
		return null;
	}
	
	@RequestMapping("/contacter")
	public ModelAndView toContacter(HttpServletRequest request, MClientEntity mClientEntity){
		ModelAndView mv = new ModelAndView("contract/contacter/main");
		return mv;
	}
	@RequestMapping("/contract")
	public ModelAndView toContract(HttpServletRequest request, MClientEntity mClientEntity){
		ModelAndView mv = new ModelAndView("contract/contract/main");
		return mv;
	}
	@RequestMapping("/inventoryHis")
	public ModelAndView toInventoryHis(HttpServletRequest request, MClientEntity mClientEntity){
		ModelAndView mv = new ModelAndView("contract/inventoryHis/main");
		return mv;
	}
	
}
