package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Role;
import com.briup.bean.User;
import com.briup.dao.UserDao;
import com.briup.service.IUserService;

/** 
* @author 作者lw: 
* @version 创建时间：2020年3月26日 下午4:52:04 
* 类说明 :
* 	和User用户相关的Service层逻辑
*/
@Service
public class UserServiceImpl implements IUserService{

	//dao层
	@Autowired
	private UserDao dao;
	
	@Override
	public User findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public Page<User> findAllUsers() {
		return findAllUsers(0);
	}

	@Override
	public Page<User> findAllUsers(Integer pageIndex) {
		return dao.findAll(PageRequest.of(pageIndex, 3));
	}

	@Override
	public void saveUser(User user) {
		dao.save(user);
	}

	@Override
	public User findUserById(Integer id) {
		return dao.getOne(id);
	}

	@Override
	public void deleteUser(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public Page<User> findUsersByRole(Integer roleId) {
		return findUsersByRole(roleId, 0);
	}

	@Override
	public Page<User> findUsersByRole(Integer roleId, Integer pageIndex) {
		Page<User> users = null;
		if (roleId == null) {
			//将所有用户查询出来
			users = dao.findAll(PageRequest.of(pageIndex, 3));
		} else {
			//根据角色条件筛选用户
			Role role = new Role();
			role.setId(roleId);
			users = dao.findByRole(role, PageRequest.of(pageIndex, 3));
		}
		return users;
	}

	@Override
	public List<User> allUsers() {
		
		return dao.findAll();
	}


	
}
