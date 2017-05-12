package com.aotu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.CustomerRateDAO;
import com.aotu.entity.Customer;
import com.aotu.entity.CustomerDefaultRate;
import com.aotu.entity.CustomerRate;
import com.aotu.entity.Page;
import com.aotu.service.ICustomerRateService;

/**
 * 客户费率信息 Service实现类
 * @author zhoujj
 */
@Service("customerRateService")
public class CustomerRateServiceImpl implements ICustomerRateService {

	@Autowired
	private CustomerRateDAO customerRateDAO;
	
	/**
	 * 新增
	 * @param customerRate
	 * @throws Exception
	 */
	public void save(CustomerRate customerRate) throws Exception {
		this.customerRateDAO.save(customerRate);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.customerRateDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param customerRate
	 * @throws Exception
	 */
	public void update(CustomerRate customerRate) throws Exception {
		this.customerRateDAO.update(customerRate);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public CustomerRate get(String id) throws Exception {
		return (CustomerRate)this.customerRateDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, CustomerRate customerRate) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = customerRateDAO.queryCount(customerRate);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<CustomerRate> records = customerRateDAO.queryPage(page.getPageSize(), page.getStartIndex(), customerRate);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<CustomerRate> queryList(CustomerRate customerRate) throws Exception {
		List<CustomerRate> records = customerRateDAO.queryList(customerRate);
		return records;
	}
	
	@Override
	public void saveOrupdateCustomerRate(Customer customer,List<CustomerDefaultRate> defaultRates) throws Exception{
		String customerId = customer.getId();
		CustomerRate customerRate = new CustomerRate();
		customerRate.setCustomerId(customerId);
		List<CustomerRate> list = this.queryList(customerRate);
		if(list.size()>0){
			for (CustomerRate rate : list) {
				for (CustomerDefaultRate defaultRate : defaultRates) {
					if(rate.getChannelId().equals(defaultRate.getChannelId())){
						rate.setHolidayFee(defaultRate.getHolidayFee());
						rate.setNightFee(defaultRate.getNightFee());
						rate.setNormalFee(defaultRate.getNormalFee());
						rate.setTradeRate(defaultRate.getTradeRate());
						rate.setCashMax(defaultRate.getCashMax());
						this.update(rate);
					}
				}
			}
		}
		if(list.size()!=defaultRates.size()){
			for (CustomerDefaultRate customerDefaultRate : defaultRates) {
				for (CustomerRate rate : list) {
					if(rate.getChannelId().equals(customerDefaultRate.getChannelId())){
						defaultRates.remove(customerDefaultRate);
					}
				}
			}
		}
		for (CustomerDefaultRate customerDefaultRate : defaultRates) {
			CustomerRate rate = new CustomerRate(customerDefaultRate,customer);
			this.save(rate);

		}
		
	}

}
