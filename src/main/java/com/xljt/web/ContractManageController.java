package com.xljt.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
}
