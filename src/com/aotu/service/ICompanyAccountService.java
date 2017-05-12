package com.aotu.service;

import java.util.List;

import com.aotu.entity.Company;
import com.aotu.entity.CompanyAccount;
import com.aotu.entity.Page;

/**
 * 公司账户 Service
 * @author zhoujj
 */
public interface ICompanyAccountService {

	/**
	 * 新增
	 * @param companyAccount
	 * @throws Exception
	 */
	public void save(CompanyAccount companyAccount) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param companyAccount
	 * @throws Exception
	 */
	public void update(CompanyAccount companyAccount) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public CompanyAccount get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, CompanyAccount companyAccount) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<CompanyAccount> queryList(CompanyAccount companyAccount) throws Exception;
	
}
