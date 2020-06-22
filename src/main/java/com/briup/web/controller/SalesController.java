package com.briup.web.controller;
/** 
* @author 作者lw: 
* @version 创建时间：2020年4月1日 下午3:02:07 
* 类说明 
*/

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Chance;
import com.briup.bean.User;
import com.briup.service.IChanceService;
import com.briup.service.IUserService;
@Controller
public class SalesController {
	@Autowired 
	private IChanceService service;
	@Autowired
	private IUserService userService;
	@RequestMapping("toSales")
	public String toSales(HttpSession session,String customer,String address) {
		session.setAttribute("customer", customer);
		session.setAttribute("address", address);
		Page<Chance> chances = service.getChances(customer, address);
		session.setAttribute("chances",chances);
		
		List<User> allUsers = userService.allUsers();
		session.setAttribute("allUsers",allUsers);
		return "pages/sales";
	}
	@RequestMapping("saveChance")  
	@ResponseBody
	public String saveChance(Chance chance) {
		if(chance.getId()!=null) {
			service.saveChance(chance);
			return "修改成功";
		}
		else {
			service.saveChance(chance);
			return "添加成功";
		}
	}
	@RequestMapping("pageChance")
	public String updataChances(Integer pageIndex,HttpSession session) {
		String customer = (String) session.getAttribute("customer");
		String address = (String) session.getAttribute("address");
		Page<Chance> chances = service.getChances(pageIndex, customer, address);
		session.setAttribute("chances", chances);
		return "pages/sales";
	}
	@RequestMapping("findChanceById")
	@ResponseBody
	public Chance findChanceById(Integer id) {
		return	service.findChanceById(id);
	}
	@RequestMapping("resetSales")
	@ResponseBody
	public String resetSales(HttpSession session) {
		session.removeAttribute("customer");
		session.removeAttribute("address");
		return "重置成功！";
	}
	@RequestMapping("delSales")
	@ResponseBody
	public String delSales(Integer id) {
		service.deleteChance(id);
		return "删除成功！";
	}
	
} 
