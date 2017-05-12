package com.aotu.service;

import java.util.List;

import com.aotu.entity.CompanyProfit;
import com.aotu.entity.Order;
import com.aotu.entity.Page;

/**
 * 公司分润 Service
 * @author zhoujj
 */
public interface ICompanyProfitService {

	/**
	 * 新增
	 * @param companyProfit
	 * @throws Exception
	 */
	public void save(CompanyProfit companyProfit) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param companyProfit
	 * @throws Exception
	 */
	public void update(CompanyProfit companyProfit) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public CompanyProfit get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, CompanyProfit companyProfit) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<CompanyProfit> queryList(CompanyProfit companyProfit) throws Exception;
	
}
