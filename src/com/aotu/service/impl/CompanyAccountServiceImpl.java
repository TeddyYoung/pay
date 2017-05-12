package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.CompanyAccountDAO;
import com.aotu.entity.CompanyAccount;
import com.aotu.entity.Page;
import com.aotu.service.ICompanyAccountService;

/**
 * 公司信息 Service实现类
 * @author zhoujj
 */
@Service("companyAccountService")
public class CompanyAccountServiceImpl implements ICompanyAccountService{
	@Autowired
	private CompanyAccountDAO companyAccountDAO;
	//增加
	public void save(CompanyAccount companyAccount) throws Exception{
		this.companyAccountDAO.save(companyAccount);
	}
	
	public void delete(String id)throws Exception{
		this.companyAccountDAO.delete(id);
	}
	
	public void update(CompanyAccount companyAccount)throws Exception{
		this.companyAccountDAO.update(companyAccount);
	}
	
	public CompanyAccount get(String id)throws Exception{
		return (CompanyAccount)this.companyAccountDAO.get(id);
	}
	
	public Page queryPage(Page page, CompanyAccount companyAccount)throws Exception{
		int totalRecordsNum = companyAccountDAO.queryCount(companyAccount);
		page.setTotalRecordsNum(totalRecordsNum);
		List<CompanyAccount> records = companyAccountDAO.queryPage(page.getPageSize(),page.getStartIndex(),companyAccount);
		page.setRecords(records);
		return page;
	}
	public List<CompanyAccount> queryList(CompanyAccount companyAccount)throws Exception{
		List<CompanyAccount> records = companyAccountDAO.queryList(companyAccount);
		return records;
	}
}
