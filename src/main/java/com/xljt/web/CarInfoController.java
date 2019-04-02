package com.xljt.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xljt.entity.CallInfoEntity;

@Controller
@RequestMapping(value="contract/car")
public class CarInfoController {
	
	private static Logger logger = LoggerFactory.getLogger(MClientController.class);
	
	@RequestMapping("")
	public ModelAndView toCar(HttpServletRequest request, CallInfoEntity callInfoEntity){
		ModelAndView mv = new ModelAndView("contract/car/main");
		return mv;
	}
}
