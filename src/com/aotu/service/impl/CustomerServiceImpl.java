package com.aotu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.CustomerDAO;
import com.aotu.entity.Customer;
import com.aotu.entity.CustomerAccount;
import com.aotu.entity.CustomerDefaultRate;
import com.aotu.entity.Page;
import com.aotu.service.ICustomerAccountService;
import com.aotu.service.ICustomerDefaultRateService;
import com.aotu.service.ICustomerRateService;
import com.aotu.service.ICustomerService;
import com.aotu.util.BizConstUtil;

/**
 * 客户信息 Service实现类
 * @author zhoujj
 */
@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private ICustomerDefaultRateService customerDefaultRateService;
	
	@Autowired
	private ICustomerAccountService customerAccountService;
	
	@Autowired
	private ICustomerRateService customerRateService;
	
	@Override
	public void save(Customer customer) throws Exception {
		
		List<CustomerDefaultRate> defaultRates = customerDefaultRateService.getInitRates(customer.getBrandId());
		customerRateService.saveOrupdateCustomerRate(customer, defaultRates); //创建通道
		customerAccountService.save(new CustomerAccount(customer));
		this.customerDAO.save(customer);
	}
	
	@Override
	public void delete(String id) throws Exception {
		this.customerDAO.delete(id);
	}
	
	@Override
	public void update(Customer customer) throws Exception {
		this.customerDAO.update(customer);
	}
	
	@Override
	public Customer get(String id) throws Exception {
		return (Customer)this.customerDAO.get(id);
	}
	
	@Override
	public Page queryPage(Page page, Customer customer) throws Exception {
		int totalRecordsNum = customerDAO.queryCount(customer);
		page.setTotalRecordsNum(totalRecordsNum);
		List<Customer> records = customerDAO.queryPage(page.getPageSize(), page.getStartIndex(), customer);
		page.setRecords(records);
		return page;
	}
	
	@Override
	public List<Customer> queryList(Customer customer) throws Exception {
		List<Customer> records = customerDAO.queryList(customer);
		return records;
	}
	
	@Override
	public List<CustomerDefaultRate> getLevelUpRates(Customer customer) throws Exception{
		List<CustomerDefaultRate> list =new ArrayList<CustomerDefaultRate>();
		if(BizConstUtil.COMMON_YES.equals(customer.getIsCompany())){ //是否是代理商
			return list;
		}else {
			Customer filterCustomer = new Customer();
			filterCustomer.setBrandId(customer.getBrandId());
			filterCustomer.setParentCustomerId(customer.getId());
			List<Customer> subCustomers = this.queryList(customer);
			int subCustomerNum = subCustomers.size();
			List<CustomerDefaultRate> defaultRates = this.customerDefaultRateService.getHighLevelRates(customer);
			if(defaultRates.size()==0){
				return defaultRates;
			}
			else{
				for (CustomerDefaultRate customerDefaultRate : defaultRates) {
					if(subCustomerNum==customerDefaultRate.getUpgradeCondition()){
						list.add(customerDefaultRate);
					}
				}
				return list;
			}
		}
		
	}
	
	@Override
	public Customer getCustomerByBrandAndPhone(String brandId,String phone){
		Customer customer = new Customer();
		customer.setBrandId(brandId);
		customer.setPhone(phone);
		List<Customer> list =null;
		try {
			list = this.queryList(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list!=null &&list.size()>0) return list.get(0);
		else return null;
	}
	
	@Override
	public List<Customer> querySubCustomerList(Customer customer) throws Exception {
		List<Customer> subCustomerList = this.customerDAO.querySubCustomerList(customer);
		return subCustomerList;
	}
	
	public String getCustomerIds(String customerId) throws Exception {
		String customerIds = "";
		Customer customer = new Customer();
		customer.setId(customerId);
		List<Customer> subCustomerList = this.customerDAO.querySubCustomerList(customer);
		customerIds += getSubCustomerIds(subCustomerList);
		if (customerIds.contains(",")) {
			customerIds = customerIds.substring(0, customerIds.lastIndexOf(","));
		}
		return customerIds;
	}
	
	/*
	 * 拼接公司id字符串
	 */
	private String getSubCustomerIds(List<Customer> customerList){
		String customerIds = "";
		Customer customer = null;
		if (customerList != null && customerList.size() > 0) {
			for (int i = 0; i < customerList.size(); i++) {
				customer = customerList.get(i);
				customerIds += "'" + customer.getId() + "',";
				List<Customer> subCustomerList = this.customerDAO.querySubCustomerList(customer);
				if(subCustomerList != null && subCustomerList.size()>0){
					customerIds += getSubCustomerIds(subCustomerList);
				}
			}
		}
		return customerIds;
	}
	
	/*
	 * 获取下级客户列表
	 */
	private List<Customer> querySubList(Customer customer) throws Exception {
		List<Customer> subCustomerList = this.customerDAO.querySubCustomerList(customer);
		if (subCustomerList != null && subCustomerList.size() > 0) {
			customer.setSubCustomerList(subCustomerList);
			for (Customer subCustomer : subCustomerList) {
				this.querySubList(subCustomer);
			}
		}
		return subCustomerList;
	}

}
