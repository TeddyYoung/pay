package com.aotu.dao;

import java.util.List;

import com.aotu.entity.Company;

/**
 * 公司信息 DAO 
 * @author zhoujj
 */
public interface CompanyDAO extends BaseDAO {
	
	/**
	 * 获取下级公司
	 * @return
	 */
	public List<Company> querySubList(Company company);
	
}