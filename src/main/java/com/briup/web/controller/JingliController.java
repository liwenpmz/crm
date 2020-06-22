package com.briup.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Chance;
import com.briup.bean.Plan;
import com.briup.bean.User;
import com.briup.service.IChanceService;
import com.briup.service.IPlanService;

/** 
* @author 作者lw: 
* @version 创建时间：2020年4月3日 下午3:20:48 
* 类说明 
*/

@Controller
public class JingliController {
	@Autowired
	private IPlanService service;
	@Autowired IChanceService chanceService;
	@RequestMapping("toPlan")
	public String toPlan(HttpSession session,String address,Integer pageIndex) {
		User jingli = (User)session.getAttribute("user");
		Page<Chance> handler = chanceService.findByHandler(jingli,address,0);
		session.setAttribute("plans", handler);
		session.setAttribute("address", address);
		return "pages/plan";
	}
	@RequestMapping("pagePlan")
	public String updataPlans(Integer pageIndex,HttpSession session) {
		String address = (String) session.getAttribute("address");
		chanceService.findByAddress(address, pageIndex);
		return "pages/plan";
	}
	@RequestMapping("resetPlan")
	@ResponseBody
	public String resetPlan(HttpSession session) {
		session.removeAttribute("address");
		return "重置成功！";
	}
	
	@RequestMapping("toPlan_add")
	public String toPlan_add(HttpSession session,Integer id) {
		Chance chance = chanceService.findChanceById(id);
		session.setAttribute("chance", chance);
		return "pages/plan_add";
	}
	@RequestMapping("plan_edit")
	public String plan_edit() {
		return "pages/plan_edit";
	}
	@RequestMapping("plan_detail")
	public String plan_detail() {
		return "pages/plan_detail";
	}
}
