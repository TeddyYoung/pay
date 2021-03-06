package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.CustomerApplyDAO;
import com.aotu.entity.CustomerApply;
import com.aotu.entity.Page;
import com.aotu.service.ICustomerApplyService;

/**
 * 客户待审核信息 Service实现类
 * @author zhoujj
 */
@Service("customerApplyService")
public class CustomerApplyServiceImpl implements ICustomerApplyService {

	@Autowired
	private CustomerApplyDAO customerApplyDAO;
	
	/**
	 * 新增
	 * @param customerApply
	 * @throws Exception
	 */
	public void save(CustomerApply customerApply) throws Exception {
		this.customerApplyDAO.save(customerApply);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.customerApplyDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param customerApply
	 * @throws Exception
	 */
	public void update(CustomerApply customerApply) throws Exception {
		this.customerApplyDAO.update(customerApply);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public CustomerApply get(String id) throws Exception {
		return (CustomerApply)this.customerApplyDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, CustomerApply customerApply) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = customerApplyDAO.queryCount(customerApply);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<CustomerApply> records = customerApplyDAO.queryPage(page.getPageSize(), page.getStartIndex(), customerApply);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<CustomerApply> queryList(CustomerApply customerApply) throws Exception {
		List<CustomerApply> records = customerApplyDAO.queryList(customerApply);
		return records;
	}

}
