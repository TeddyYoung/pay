package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.CustomerProfitDAO;
import com.aotu.entity.CustomerProfit;
import com.aotu.entity.CustomerRate;
import com.aotu.entity.Page;
import com.aotu.service.ICustomerProfitService;

/**
 * 客户分润收入 Service实现类
 * @author zhoujj
 */
@Service("customerProfitService")
public class CustomerProfitServiceImpl implements ICustomerProfitService {

	@Autowired
	private CustomerProfitDAO customerProfitDAO;
	
	/**
	 * 新增
	 * @param customerProfit
	 * @throws Exception
	 */
	public void save(CustomerProfit customerProfit) throws Exception {
		this.customerProfitDAO.save(customerProfit);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.customerProfitDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param customerProfit
	 * @throws Exception
	 */
	public void update(CustomerProfit customerProfit) throws Exception {
		this.customerProfitDAO.update(customerProfit);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public CustomerProfit get(String id) throws Exception {
		return (CustomerProfit)this.customerProfitDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, CustomerProfit customerProfit) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = customerProfitDAO.queryCount(customerProfit);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<CustomerProfit> records = customerProfitDAO.queryPage(page.getPageSize(), page.getStartIndex(), customerProfit);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<CustomerProfit> queryList(CustomerProfit customerProfit) throws Exception {
		List<CustomerProfit> records = customerProfitDAO.queryList(customerProfit);
		return records;
	}

}
