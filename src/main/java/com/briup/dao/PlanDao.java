package com.briup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Plan;

/** 
* @author 作者lw: 
* @version 创建时间：2020年4月3日 下午3:25:45 
* 类说明 
*/
public interface PlanDao	extends JpaRepository<Plan,Integer> {
	
}
