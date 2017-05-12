package com.aotu.service;

import java.util.List;

import com.aotu.entity.Customer;
import com.aotu.entity.CustomerDefaultRate;
import com.aotu.entity.CustomerRate;
import com.aotu.entity.Order;
import com.aotu.entity.Page;

/**
 * 客户费率信息 Service
 * @author zhoujj
 */
public interface ICustomerRateService {

	/**
	 * 新增
	 * @param customerRate
	 * @throws Exception
	 */
	public void save(CustomerRate customerRate) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param customerRate
	 * @throws Exception
	 */
	public void update(CustomerRate customerRate) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public CustomerRate get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, CustomerRate customerRate) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<CustomerRate> queryList(CustomerRate customerRate) throws Exception;

	public void saveOrupdateCustomerRate(Customer customer,
			List<CustomerDefaultRate> defaultRates) throws Exception;
	
}
