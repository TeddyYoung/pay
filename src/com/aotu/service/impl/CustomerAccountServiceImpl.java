package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.CustomerAccountDAO;
import com.aotu.entity.CustomerAccount;
import com.aotu.entity.Page;
import com.aotu.service.ICustomerAccountService;

/**
 * 客户账户 Service实现类
 * @author zhoujj
 */
@Service("customerAccountService")
public class CustomerAccountServiceImpl implements ICustomerAccountService {

	@Autowired
	private CustomerAccountDAO customerAccountDAO;
	
	/**
	 * 新增
	 * @param customerAccount
	 * @throws Exception
	 */
	public void save(CustomerAccount customerAccount) throws Exception {
		this.customerAccountDAO.save(customerAccount);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.customerAccountDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param customerAccount
	 * @throws Exception
	 */
	public void update(CustomerAccount customerAccount) throws Exception {
		this.customerAccountDAO.update(customerAccount);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public CustomerAccount get(String id) throws Exception {
		return (CustomerAccount)this.customerAccountDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, CustomerAccount customerAccount) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = customerAccountDAO.queryCount(customerAccount);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<CustomerAccount> records = customerAccountDAO.queryPage(page.getPageSize(), page.getStartIndex(), customerAccount);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<CustomerAccount> queryList(CustomerAccount customerAccount) throws Exception {
		List<CustomerAccount> records = customerAccountDAO.queryList(customerAccount);
		return records;
	}

}
