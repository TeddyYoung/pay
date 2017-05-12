package com.aotu.dao;

import java.util.List;

import com.aotu.entity.Customer;

/**
 * 客户信息 DAO 
 * @author zhoujj
 */
public interface CustomerDAO extends BaseDAO {
	
	/**
	 * 查询下级客户列表
	 * @param customer
	 * @return
	 */
	public List<Customer> querySubCustomerList(Customer customer);
	
}