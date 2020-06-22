package com.briup.service;
/** 
* @author 作者lw: 
* @version 创建时间：2020年4月1日 下午3:16:02 
* 类说明 
*/

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.briup.bean.Chance;
import com.briup.bean.User;

public interface IChanceService {
	/**
	 * 查询所有的信息
	 * @return
	 */
	Page<Chance> findAllChances();
	/**
	 * 查询指定页上的信息
	 * @param pageIndex
	 * @return
	 */
	Page<Chance> findAllChances(Integer pageIndex);
	/**
	 * 保存信息
	 * @param chance
	 */
	void saveChance(Chance chance);
	/**
	 * 通过id查询信息
	 * @param id
	 * @return
	 */
	Chance findChanceById(Integer id);
	/**
	 * 删除对应的id信息
	 * @param id
	 */
	void deleteChance(Integer id);
	/**
	 * 查询所的信息
	 * @return
	 */
	List<Chance> allChances();
	
	//查询显示
	Page<Chance> getChances(String customer,String address);
	
	Page<Chance> getChances(Integer pageIndex,String customer,String address);
	
	Page<Chance> findByHandler(User user,String address,Integer pageIndex);
	Page<Chance> findByAddress(String address,Integer pageIndex);
	
}
