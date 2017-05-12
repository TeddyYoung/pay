package com.aotu.service;

import java.util.List;

import com.aotu.entity.Bank;
import com.aotu.entity.Page;

/**
 * 银行基础信息 Service
 * @author zhoujj
 */
public interface IBankService {

	/**
	 * 新增
	 * @param bank
	 * @throws Exception
	 */
	public void save(Bank bank) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param bank
	 * @throws Exception
	 */
	public void update(Bank bank) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Bank get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Bank bank) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Bank> queryList(Bank bank) throws Exception;
	
}
