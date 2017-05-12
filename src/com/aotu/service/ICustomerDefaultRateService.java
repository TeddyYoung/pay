package com.aotu.service;

import java.util.List;

import com.aotu.entity.Customer;
import com.aotu.entity.CustomerDefaultRate;
import com.aotu.entity.Order;
import com.aotu.entity.Page;

/**
 * 客户默认费率配置 Service
 * @author zhoujj
 */
public interface ICustomerDefaultRateService {

	/**
	 * 新增
	 * @param customerDefaultRate
	 * @throws Exception
	 */
	public void save(CustomerDefaultRate customerDefaultRate) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param customerDefaultRate
	 * @throws Exception
	 */
	public void update(CustomerDefaultRate customerDefaultRate) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public CustomerDefaultRate get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, CustomerDefaultRate customerDefaultRate) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<CustomerDefaultRate> queryList(CustomerDefaultRate customerDefaultRate) throws Exception;

	/**
	 * huo
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	public 	List<CustomerDefaultRate> getHighLevelRates(Customer customer)
			throws Exception;

	/**
	 * 获取初始rates
	 * @param brandId
	 * @return
	 * @throws Exception
	 */
	public List<CustomerDefaultRate> getInitRates(String brandId) throws Exception;


	
}
