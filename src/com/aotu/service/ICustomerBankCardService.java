package com.aotu.service;

import java.util.List;

import com.aotu.entity.CustomerBankCard;
import com.aotu.entity.Order;
import com.aotu.entity.Page;

/**
 * 客户银行卡信息 Service
 * @author zhoujj
 */
public interface ICustomerBankCardService {

	/**
	 * 新增
	 * @param customerBankCard
	 * @throws Exception
	 */
	public void save(CustomerBankCard customerBankCard) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param customerBankCard
	 * @throws Exception
	 */
	public void update(CustomerBankCard customerBankCard) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public CustomerBankCard get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, CustomerBankCard customerBankCard) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<CustomerBankCard> queryList(CustomerBankCard customerBankCard) throws Exception;
	
}
