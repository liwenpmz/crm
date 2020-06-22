package com.briup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Chance;
import com.briup.bean.Plan;
import com.briup.dao.ChanceDao;
import com.briup.dao.PlanDao;
import com.briup.service.IPlanService;

/** 
* @author 作者lw: 
* @version 创建时间：2020年4月3日 下午3:27:32 
* 类说明 
*/
@Service
public class PlanServiceImpl implements IPlanService{
	@Autowired
	private PlanDao dao;
	@Override
	public void SavePlan(Plan plan) {
		dao.save(plan);
	}

	@Override
	public void deletePlan(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public Page<Plan> findAllPlans(Integer pageIndex) {
		return	dao.findAll(PageRequest.of(pageIndex, 5));
	}

	
	
	
}
