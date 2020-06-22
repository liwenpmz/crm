package com.briup.service;
/** 
* @author 作者lw: 
* @version 创建时间：2020年3月27日 下午2:34:59 
* 类说明 
*/

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.briup.bean.Role;

public interface IRoleService {
	/**
	 * 查询刚进入角色模块的所有角色
	 * @return
	 */
	Page<Role> findAllRoles();
	
	/**
	 * 查询指定页也上的信息
	 * @param pageIndex
	 * @return
	 */
	Page<Role> findAllRoles(Integer pageIndex);
	
	/**
	 * 新增
	 * @param role
	 */
	void saveRole(Role role);
	
	/** 
	 * 通过id找到对应的Role
	 * @param id
	 * @return
	 */
	Role findRoleById(Integer id);
	
	
	/**
	 * 删除
	 * @param id
	 */
	void deleteRole(Integer id);
	
	/**
	 * 查询所有角色信息
	 */
	List<Role> allRoles();
}
