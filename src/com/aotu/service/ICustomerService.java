package com.aotu.service;

import java.util.List;

import com.aotu.entity.Customer;
import com.aotu.entity.CustomerDefaultRate;
import com.aotu.entity.Page;

/**
 * 客户信息 Service
 * @author zhoujj
 */
public interface ICustomerService {

	/**
	 * 新增
	 * @param customer
	 * @throws Exception
	 */
	public void save(Customer customer) throws Exception;
	
	
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param customer
	 * @throws Exception
	 */
	public void update(Customer customer) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Customer get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Customer customer) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Customer> queryList(Customer customer) throws Exception;

	
	/**
	 * 根据品牌及用户手机获取用户对象
	 * @param brandId
	 * @param phone
	 * @return
	 */
	public Customer getCustomerByBrandAndPhone(String brandId, String phone);
	
	/**
	 * 获取下级客户列表
	 * @return
	 * @throws Exception
	 */
	public List<Customer> querySubCustomerList(Customer customer) throws Exception;

	/**
	 * 判断上级用户是否满足升级条件，如果满足返回升级通道比例
	 * @param customer
	 * @return
	 * @throws Exception 
	 */

	public List<CustomerDefaultRate> getLevelUpRates(Customer customer)
			throws Exception;
	
}
