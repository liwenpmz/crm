package com.briup.service;

import org.springframework.data.domain.Page;

import com.briup.bean.Chance;
import com.briup.bean.Plan;
import com.briup.bean.User;

/** 
* @author 作者lw: 
* @version 创建时间：2020年4月3日 下午3:26:51 
* 类说明 
*/
public interface IPlanService {
	
	void SavePlan(Plan plan);
	
	void deletePlan(Integer id);
	
	Page<Plan> findAllPlans(Integer pageIndex);
	//Page<Chance> getChances(String customer,String address);
	
}
