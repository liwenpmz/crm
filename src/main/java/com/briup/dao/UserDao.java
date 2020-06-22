package com.briup.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Role;
import com.briup.bean.User;

/** 
* @author 作者lw: 
* @version 创建时间：2020年3月26日 下午4:54:24 
* 类说明 
* 	User对象和数据库进行保存
*/
public interface UserDao extends JpaRepository<User, Integer>{
	User findByName(String name); 
	
	Page<User> findByRole(Role role,Pageable able);

	
	
	
}
