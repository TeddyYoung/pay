package com.aotu.service;

import java.util.List;

import com.aotu.entity.Company;
import com.aotu.entity.Page;

/**
 * 公司信息 Service
 * @author zhoujj
 */
public interface ICompanyService {

	/**
	 * 新增
	 * @param company
	 * @throws Exception
	 */
	public void save(Company company) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param company
	 * @throws Exception
	 */
	public void update(Company company) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Company get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Company company) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Company> queryList(Company company) throws Exception;
	
	/**
	 * 通过部门ID获取所有下级公司id
	 * @param deptId
	 * @return
	 * @throws Exception
	 */
	public String getCompanyIds(String deptId) throws Exception;
	
}
