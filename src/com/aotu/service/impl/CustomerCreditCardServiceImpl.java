package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.CustomerCreditCardDAO;
import com.aotu.entity.CustomerCreditCard;
import com.aotu.entity.Page;
import com.aotu.service.ICustomerCreditCardService;

/**
 * 客户信用卡信息 Service实现类
 * @author zhoujj
 */
@Service("customerCreditCardService")
public class CustomerCreditCardServiceImpl implements ICustomerCreditCardService {

	@Autowired
	private CustomerCreditCardDAO customerCreditCardDAO;
	
	/**
	 * 新增
	 * @param customerCreditCard
	 * @throws Exception
	 */
	public void save(CustomerCreditCard customerCreditCard) throws Exception {
		this.customerCreditCardDAO.save(customerCreditCard);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.customerCreditCardDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param customerCreditCard
	 * @throws Exception
	 */
	public void update(CustomerCreditCard customerCreditCard) throws Exception {
		this.customerCreditCardDAO.update(customerCreditCard);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public CustomerCreditCard get(String id) throws Exception {
		return (CustomerCreditCard)this.customerCreditCardDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, CustomerCreditCard customerCreditCard) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = customerCreditCardDAO.queryCount(customerCreditCard);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<CustomerCreditCard> records = customerCreditCardDAO.queryPage(page.getPageSize(), page.getStartIndex(), customerCreditCard);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<CustomerCreditCard> queryList(CustomerCreditCard customerCreditCard) throws Exception {
		List<CustomerCreditCard> records = customerCreditCardDAO.queryList(customerCreditCard);
		return records;
	}

}
