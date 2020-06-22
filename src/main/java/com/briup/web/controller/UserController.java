package com.briup.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Role;
import com.briup.bean.User;
import com.briup.service.IRoleService;
import com.briup.service.IUserService;

/** 
* @author 作者lw: 
* @version 创建时间：2020年3月26日 下午4:32:44 
* 类说明 
*/
@Controller
public class UserController {

	//service层
	@Autowired
	private IUserService service;
	@Autowired
	private IRoleService roleService;
	//获取前台输入的用户名密码，进行校验
	@RequestMapping("user/login")
	//返回响应体 json格式返回前台
	@ResponseBody
	public String login(String name,String password,HttpSession session) {
		//需要判断用户名密码是否为空，但是前台已经完成。
		//System.out.println(name);
		//System.out.println(password);
		//调用service层，来判断用户名密码是否正确。
		User user = service.findByName(name);
		//如果user为空则表示用户名不存在
		if(user==null) {
			return "当前用户不存在！";
		}
		//判断密码是否正确。
		if(!(user.getPassword().equals(password))) {
			return "密码错误！";
		}
		//判断用户状态：1为正常，2为位注销
		if(user.getFlag()!=1) {
			return "改用户已被注销！";
		}
		//System.out.println("-------------"+user);
		//将数据保存到session范围中，供前台使用。
		session.setAttribute("user", user);
		return "success";
	}
	
	//退出功能
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}
	//显示用户管理
	@RequestMapping("toUser")
	public String toUser(HttpSession session,Integer roleId) {
		session.setAttribute("roleId", roleId);
		Page<User> users= service.findUsersByRole(roleId);
		session.setAttribute("users", users);
		//查询角色信息-角色名字
		List<Role> allRoles = roleService.allRoles();
		session.setAttribute("allRoles", allRoles);
		return "pages/user";
	} 
	//分页查询
	@RequestMapping("updateUserPage")
	public String userPage(Integer pageIndex,HttpSession session) {
		Integer roleId = (Integer) session.getAttribute("roleId");
		Page<User> users = service.findUsersByRole(roleId, pageIndex);
		session.setAttribute("users", users);
		return "pages/user";
	}
	//重置
	@RequestMapping("resetUser")
	@ResponseBody
	public String resetUser(HttpSession sesion) {
		sesion.removeAttribute("roleId");
		return "重置成功！";
	}
	@RequestMapping("saveUser")
	@ResponseBody
	
	public String saveUser(User user) {   
//		Role role = roleService.findRoleById(roleId);
		//System.out.println("wwwdd++++++++++++++++++++++"+user);
		if(user.getId()!=null)
			{
			service.saveUser(user);
			return "修改成功";
			}
		else{ 
			service.saveUser(user);
			return "添加成功";
		}
		 
	}
	//更新用户信息
	@RequestMapping("findUserById")
	@ResponseBody
	public	User findUserById(Integer id) {
		return service.findUserById(id);
	}
	@RequestMapping("delUser")
	@ResponseBody
	public String delUser(Integer id) {
		User user = service.findUserById(id);
		user.getRole().getUsers().remove(user);
		service.deleteUser(id);
		return "删除成功";
	}
}
