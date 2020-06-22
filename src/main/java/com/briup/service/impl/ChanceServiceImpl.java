package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.briup.bean.Chance;
import com.briup.bean.User;
import com.briup.dao.ChanceDao;
import com.briup.service.IChanceService;

/** 
* @author 作者lw: 
* @version 创建时间：2020年4月1日 下午3:41:22 
* 类说明 
*/
@Service
public class ChanceServiceImpl implements IChanceService {
	@Autowired
	private ChanceDao dao;
	@Override
	public Page<Chance> findAllChances() {
		return  findAllChances(0);
	}

	@Override
	public Page<Chance> findAllChances(Integer pageIndex) {
		return dao.findAll(PageRequest.of(pageIndex, 5));
	}

	@Override
	public void saveChance(Chance chance) {
		dao.save(chance);
	}

	@Override
	public Chance findChanceById(Integer id) {
		return dao.getOne(id);
	}

	@Override
	public void deleteChance(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public List<Chance> allChances() {
		return dao.findAll();
	}

	@Override
	public Page<Chance> getChances(String customer, String address) {
		return getChances(0, customer, address);
	}

	@Override
	public Page<Chance> getChances(Integer pageIndex, String customer, String address) {
		if((customer!=null&&customer.trim()!="")&&(address!=null&&address.trim()!="")) {
			//根据客户名及区域查询
			return  dao.findByCustomerAndAddress(customer, address,PageRequest.of(pageIndex, 3));
		}else if(customer!=null&&customer.trim()!="") {
			//客户名查询
			//System.out.println("来了吗");
			return dao.findByCustomerLike("%"+customer+"%", PageRequest.of(pageIndex, 3));
		}else if(address!=null&&address.trim()!=""){
			//地址查询
			return dao.findByAddress(address, PageRequest.of(pageIndex, 3));
		}
		else {
			//无条件查询
			return dao.findAll(PageRequest.of(pageIndex, 3));
		}
	}

	@Override
	public Page<Chance> findByHandler(User user, String address,Integer pageIndex) {
		if(address!=null&&address.trim()!="") 
			return dao.findByHandlerAndAddress(user, address, PageRequest.of(pageIndex, 3));
		else
			return dao.findByHandler(user, PageRequest.of(pageIndex, 3));	
	}

	@Override
	public Page<Chance> findByAddress(String address, Integer pageIndex) {
		return dao.findByAddress(address,  PageRequest.of(pageIndex, 3));
	}

}
