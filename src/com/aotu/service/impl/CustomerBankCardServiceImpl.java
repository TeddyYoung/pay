package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.CustomerBankCardDAO;
import com.aotu.entity.CustomerBankCard;
import com.aotu.entity.Page;
import com.aotu.service.ICustomerBankCardService;

/**
 * 客户银行卡信息 Service实现类
 * @author zhoujj
 */
@Service("customerBankCardService")
public class CustomerBankCardServiceImpl implements ICustomerBankCardService {

	@Autowired
	private CustomerBankCardDAO customerBankCardDAO;
	
	/**
	 * 新增
	 * @param customerBankCard
	 * @throws Exception
	 */
	public void save(CustomerBankCard customerBankCard) throws Exception {
		this.customerBankCardDAO.save(customerBankCard);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.customerBankCardDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param customerBankCard
	 * @throws Exception
	 */
	public void update(CustomerBankCard customerBankCard) throws Exception {
		this.customerBankCardDAO.update(customerBankCard);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public CustomerBankCard get(String id) throws Exception {
		return (CustomerBankCard)this.customerBankCardDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, CustomerBankCard customerBankCard) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = customerBankCardDAO.queryCount(customerBankCard);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<CustomerBankCard> records = customerBankCardDAO.queryPage(page.getPageSize(), page.getStartIndex(), customerBankCard);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<CustomerBankCard> queryList(CustomerBankCard customerBankCard) throws Exception {
		List<CustomerBankCard> records = customerBankCardDAO.queryList(customerBankCard);
		return records;
	}

}
