package com.aotu.service;

import java.util.List;

import com.aotu.entity.CustomerApply;
import com.aotu.entity.Order;
import com.aotu.entity.Page;

/**
 * 客户待审核信息 Service
 * @author zhoujj
 */
public interface ICustomerApplyService {

	/**
	 * 新增
	 * @param customerApply
	 * @throws Exception
	 */
	public void save(CustomerApply customerApply) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param customerApply
	 * @throws Exception
	 */
	public void update(CustomerApply customerApply) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public CustomerApply get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, CustomerApply customerApply) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<CustomerApply> queryList(CustomerApply customerApply) throws Exception;
	
}
