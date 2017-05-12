package com.aotu.service;

import java.util.List;

import com.aotu.entity.CustomerCreditCard;
import com.aotu.entity.Order;
import com.aotu.entity.Page;

/**
 * 客户信用卡信息 Service
 * @author zhoujj
 */
public interface ICustomerCreditCardService {

	/**
	 * 新增
	 * @param customerCreditCard
	 * @throws Exception
	 */
	public void save(CustomerCreditCard customerCreditCard) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param customerCreditCard
	 * @throws Exception
	 */
	public void update(CustomerCreditCard customerCreditCard) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public CustomerCreditCard get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, CustomerCreditCard customerCreditCard) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<CustomerCreditCard> queryList(CustomerCreditCard customerCreditCard) throws Exception;
	
}
