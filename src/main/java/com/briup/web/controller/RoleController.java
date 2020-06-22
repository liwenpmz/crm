package com.briup.web.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Role;
import com.briup.service.IRoleService;

/** 
* @author 作者lw: 
* @version 创建时间：2020年3月27日 上午11:51:39 
* 类说明 
* 	角色管理模块
*/
@Controller
public class RoleController {
	//service层
	@Autowired
	private IRoleService service;
	
	@RequestMapping("toRole")
	public String toRole(HttpSession session) {
		//将数据库所有角色信息查询出来。保存到session之中。
		Page<Role> roles = service.findAllRoles();
		session.setAttribute("roles", roles);
		//System.out.println(roles.getTotalPages()+"---------------");
		return "pages/role";
	}
	@RequestMapping("saveRole")  
	@ResponseBody
	public String saveRole(Role role) {   
		//System.out.println("wwwdd+++++++++"+role);
		
		if(role.getId()!=null)
			{
			service.saveRole(role);
			return "修改成功";
			}
		else{
			service.saveRole(role);
			return "添加成功";
		}
		 
	}
	@RequestMapping("delRole")
	@ResponseBody
	public String delRole(Integer id) {
		service.deleteRole(id);
		return "删除成功!";
	}
	@RequestMapping("pageRole")
	public String updatePageRole(Integer pageIndex,HttpSession session) {
		Page<Role> roles = service.findAllRoles(pageIndex);
		session.setAttribute("roles", roles);
		return "pages/role";
	}
	//根据id查询指定的角色
	@RequestMapping("findRoleById")
	@ResponseBody
	public Role findRoleById(Integer id) {
		return service.findRoleById(id);
	}
}
