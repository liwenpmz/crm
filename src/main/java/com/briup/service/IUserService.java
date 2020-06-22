package com.briup.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.briup.bean.Role;
import com.briup.bean.User;

/** 
* @author 作者lw: 
* @version 创建时间：2020年3月26日 下午4:48:26 
* 类说明 
*/
public interface IUserService {
	
	public User findByName(String name);
	/**
	 * 查询刚进入用户模块的所有用户
	 * @return
	 */
	Page<User> findAllUsers();
	/**
	 * 查询指定页上的信息
	 * @param pageIndex
	 * @return
	 */
	Page<User> findAllUsers(Integer pageIndex);
	
	/**
	 * 新增
	 * @param user
	 */
	void saveUser(User user);
	
	/** 
	 * 通过id找到对应的User
	 * @param id
	 * @return
	 */
	User findUserById(Integer id);
	
	/**
	 * 删除
	 * @param id
	 */
	void deleteUser(Integer id);
	
	//查询User信息
	Page<User> findUsersByRole(Integer roleId);
	//根据分页查询User的相关信息
	Page<User> findUsersByRole(Integer roleId,Integer pageIndex);
	
	List<User> allUsers();
}
