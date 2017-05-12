package com.aotu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.CustomerDefaultRateDAO;
import com.aotu.entity.Customer;
import com.aotu.entity.CustomerDefaultRate;
import com.aotu.entity.Order;
import com.aotu.entity.Page;
import com.aotu.service.ICustomerDefaultRateService;

/**
 * 客户默认费率配置 Service实现类
 * @author zhoujj
 */
@Service("customerDefaultRateService")
public class CustomerDefaultRateServiceImpl implements ICustomerDefaultRateService {

	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustomerDefaultRateDAO customerDefaultRateDAO;
	
	/**
	 * 新增
	 * @param customerDefaultRate
	 * @throws Exception
	 */
	public void save(CustomerDefaultRate customerDefaultRate) throws Exception {
		this.customerDefaultRateDAO.save(customerDefaultRate);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.customerDefaultRateDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param customerDefaultRate
	 * @throws Exception
	 */
	public void update(CustomerDefaultRate customerDefaultRate) throws Exception {
		this.customerDefaultRateDAO.update(customerDefaultRate);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public CustomerDefaultRate get(String id) throws Exception {
		return (CustomerDefaultRate)this.customerDefaultRateDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, CustomerDefaultRate customerDefaultRate) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = customerDefaultRateDAO.queryCount(customerDefaultRate);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<CustomerDefaultRate> records = customerDefaultRateDAO.queryPage(page.getPageSize(), page.getStartIndex(), customerDefaultRate);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<CustomerDefaultRate> queryList(CustomerDefaultRate customerDefaultRate) throws Exception {
		List<CustomerDefaultRate> records = customerDefaultRateDAO.queryList(customerDefaultRate);
		return records;
	}
	
	@Override
	public List<CustomerDefaultRate> getHighLevelRates(Customer customer) throws Exception{
		List<CustomerDefaultRate> results = new ArrayList<CustomerDefaultRate>();
		CustomerDefaultRate customerDefaultRate = new CustomerDefaultRate();
		customerDefaultRate.setBrandId(customer.getBrandId());
		try {
			List<CustomerDefaultRate> rateList = this.queryList(customerDefaultRate);
			Integer typeLevel = Integer.valueOf(customer.getType());
			if(typeLevel==0) {
				return results;
			}
			else{
				String highLevel = String.valueOf(typeLevel-1);
				for (CustomerDefaultRate defaultRate : rateList) {
					if(highLevel.equals(defaultRate.getCustomerType())){
						results.add(defaultRate);
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("获取更高等级失败！");
		}
		return results;
		
	}
	
	
	@Override
	public List<CustomerDefaultRate> getInitRates(String brandId) throws Exception{
		CustomerDefaultRate customerDefaultRate = new CustomerDefaultRate();
		customerDefaultRate.setBrandId(brandId);
		List<CustomerDefaultRate> list = new ArrayList<CustomerDefaultRate>();
		try {
			List<CustomerDefaultRate> rateList = this.queryList(customerDefaultRate);
			String type= rateList.get(rateList.size()-1).getCustomerType();
			for (CustomerDefaultRate defaultRate : rateList) {
				if(type.equals(defaultRate.getCustomerType())){
					list.add(defaultRate);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("获取更高等级失败！");
		}
		return list;
	}

}
