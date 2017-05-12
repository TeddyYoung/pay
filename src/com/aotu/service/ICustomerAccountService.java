package com.aotu.service;

import java.util.List;

import com.aotu.entity.CustomerAccount;
import com.aotu.entity.Page;

/**
 * 客户账户 Service
 * @author zhoujj
 */
public interface ICustomerAccountService {

	/**
	 * 新增
	 * @param customerAccount
	 * @throws Exception
	 */
	public void save(CustomerAccount customerAccount) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param customerAccount
	 * @throws Exception
	 */
	public void update(CustomerAccount customerAccount) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public CustomerAccount get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, CustomerAccount customerAccount) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<CustomerAccount> queryList(CustomerAccount customerAccount) throws Exception;
	
}
