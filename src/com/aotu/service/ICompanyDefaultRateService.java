package com.aotu.service;

import java.util.List;

import com.aotu.entity.CompanyDefaultRate;
import com.aotu.entity.Order;
import com.aotu.entity.Page;

/**
 * 公司默认费率配置 Service
 * @author zhoujj
 */
public interface ICompanyDefaultRateService {

	/**
	 * 新增
	 * @param companyDefaultRate
	 * @throws Exception
	 */
	public void save(CompanyDefaultRate companyDefaultRate) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param companyDefaultRate
	 * @throws Exception
	 */
	public void update(CompanyDefaultRate companyDefaultRate) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public CompanyDefaultRate get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, CompanyDefaultRate companyDefaultRate) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<CompanyDefaultRate> queryList(CompanyDefaultRate companyDefaultRate) throws Exception;
	
}
