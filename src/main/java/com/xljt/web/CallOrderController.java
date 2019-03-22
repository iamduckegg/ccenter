package com.xljt.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xljt.entity.CallBasicVo;
import com.xljt.entity.Page;
import com.xljt.service.CallOrderService;


/**
 * 订单
 * @author ZX
 */
@Controller
@RequestMapping(value="ccenter")
public class CallOrderController {
	@Autowired
	private CallOrderService callOrderService;

	private static Logger logger = LoggerFactory.getLogger(CallOrderController.class);
	
	@RequestMapping("")
	public ModelAndView toMain(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("ccenter/main");
		return mv;
	}
	
	/**
	 * 分页查询工单列表
	 * @param request
	 * @param basicVo
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> findList(HttpServletRequest request, CallBasicVo basicVo){
		Map<String, Object> map = new HashMap<String, Object>();
		Page pages = new Page();
		pages.setPage(Integer.parseInt(request.getParameter("page")));
		pages.setLimit(Integer.parseInt(request.getParameter("limit")));
		Page page =null;
		try {
			page = callOrderService.queryList(pages,basicVo);
			
		} catch (Exception e) {
			logger.error("分页查询工单列表异常");
		}
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", page.getCount());
		map.put("data", page.getList());
		
		return map;
	}
	

	
	/**
	 * 查询订单详情
	 * @return
	 */
	@RequestMapping("/detail")
	@ResponseBody
	public ModelAndView queryDetail(HttpServletRequest request,String ticketId){
		ModelAndView mv = new ModelAndView("ccenter/detail");
		Map<String, Object> orders = null;
		try {
			orders = callOrderService.queryOrder(ticketId);
		} catch (Exception e) {
			logger.error("查询订单详情异常");
		}
		
		request.setAttribute("basic", orders.get("basicAndServicer"));
		request.setAttribute("rescues", orders.get("rescueDetail"));
		request.setAttribute("repairOne", orders.get("repairOne"));
		request.setAttribute("repairTwo", orders.get("repairTwo"));
		
		request.setAttribute("rescueSum", orders.get("rescueSum"));
		request.setAttribute("repairSum", orders.get("repairSum"));
		request.setAttribute("repairCount", Integer.parseInt(orders.get("repairCount").toString()) < 10 ? 8 : (Integer.parseInt(orders.get("repairCount").toString())));
		request.setAttribute("allSum", orders.get("allSum"));
		return mv;
	}
	
	/**
	 * 数据获取
	 * @param request
	 */
	//@Scheduled(cron = "0 0/2 * * * ? ")
	public void copyData(){
		try {
			logger.info(new Date().toString());
			callOrderService.copyData();
			logger.info("Finish");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
