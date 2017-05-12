package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.CompanyDAO;
import com.aotu.entity.Company;
import com.aotu.entity.Page;
import com.aotu.service.ICompanyService;

/**
 * 公司信息 Service实现类
 * @author zhoujj
 */
@Service("companyService")
public class CompanyServiceImpl implements ICompanyService {
	
	@Autowired
	private CompanyDAO companyDAO;

	public void save(Company company) throws Exception{
		this.companyDAO.save(company);
	}
	
	public void delete(String id)throws Exception{
		this.companyDAO.delete(id);
	}
	
	public void update(Company company)throws Exception{
		this.companyDAO.update(company);
	}
	
	public Company get(String id)throws Exception{
		return (Company)this.companyDAO.get(id);
	}
	
	public Page queryPage(Page page, Company company)throws Exception{
		int totalRecordsNum = companyDAO.queryCount(company);
		page.setTotalRecordsNum(totalRecordsNum);
		List<Company> records = companyDAO.queryPage(page.getPageSize(),page.getStartIndex(),company);
		page.setRecords(records);
		return page;
	}
	
	public List<Company> queryList(Company company)throws Exception{
		List<Company> records = companyDAO.queryList(company);
		return records;
	}
	
	public String getCompanyIds(String deptId) throws Exception {
		String companyIds = "";
		Company company = new Company();
		company.setDeptId(deptId);
		List<Company> records = companyDAO.queryList(company);
		if (records != null && records.size() > 0) {
			company = records.get(0);
			companyIds = "'" + company.getId() + "',";
			List<Company> subCompanyList = this.companyDAO.querySubList(company);
			companyIds += getSubCompanyIds(subCompanyList);
			if (companyIds.contains(",")) {
				companyIds = companyIds.substring(0, companyIds.lastIndexOf(","));
			}
		}
		return companyIds;
	}
	
	/*
	 * 拼接公司id字符串
	 */
	private String getSubCompanyIds(List<Company> companyList){
		String companyIds = "";
		Company company = null;
		if (companyList != null && companyList.size() > 0) {
			for (int i = 0; i < companyList.size(); i++) {
				company = companyList.get(i);
				companyIds += "'" + company.getId() + "',";
				List<Company> subCompanyList = this.companyDAO.querySubList(company);
				if(subCompanyList != null && subCompanyList.size()>0){
					companyIds += getSubCompanyIds(subCompanyList);
				}
			}
		}
		return companyIds;
	}
	
	/*
	 * 获取下级公司列表
	 */
	private List<Company> querySubList(Company company) throws Exception {
		List<Company> subCompanyList = this.companyDAO.querySubList(company);
		if (subCompanyList != null && subCompanyList.size() > 0) {
			company.setSubCompanyList(subCompanyList);
			for (Company subCompany : subCompanyList) {
				this.querySubList(subCompany);
			}
		}
		return subCompanyList;
	}
	
}
