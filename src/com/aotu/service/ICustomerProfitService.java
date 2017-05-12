package com.aotu.service;

import java.util.List;

import com.aotu.entity.Customer;
import com.aotu.entity.CustomerProfit;
import com.aotu.entity.Page;

/**
 * 客户分润收入 Service
 * @author zhoujj
 */
public interface ICustomerProfitService {

	/**
	 * 新增
	 * @param customerProfit
	 * @throws Exception
	 */
	public void save(CustomerProfit customerProfit) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param customerProfit
	 * @throws Exception
	 */
	public void update(CustomerProfit customerProfit) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public CustomerProfit get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, CustomerProfit customerProfit) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<CustomerProfit> queryList(CustomerProfit customerProfit) throws Exception;
	
}
