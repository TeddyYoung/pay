package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.CompanyDefaultRateDAO;
import com.aotu.entity.CompanyDefaultRate;
import com.aotu.entity.Page;
import com.aotu.service.ICompanyDefaultRateService;

/**
 * 公司默认费率配置 Service实现类
 * @author zhoujj
 */
@Service("companyDefaultRateService")
public class CompanyDefaultRateServiceImpl implements ICompanyDefaultRateService{
	@Autowired
	private CompanyDefaultRateDAO companyDefaultRateDAO;
public void save(CompanyDefaultRate companyDefaultRate)throws Exception{
	this.companyDefaultRateDAO.save(companyDefaultRate);
}

public void delete(String id)throws Exception{
	this.companyDefaultRateDAO.delete(id);
}

public void update(CompanyDefaultRate companyDefaultRate)throws Exception{
	this.companyDefaultRateDAO.update(companyDefaultRate);
}

public CompanyDefaultRate get(String id)throws Exception{
	return (CompanyDefaultRate) this.companyDefaultRateDAO.get(id);
}

public Page queryPage(Page page,CompanyDefaultRate companyDefaultRate)throws Exception{
	int totalRecordsNum = companyDefaultRateDAO.queryCount(companyDefaultRate);
	page.setTotalRecordsNum(totalRecordsNum);
	List<CompanyDefaultRate> records = companyDefaultRateDAO.queryPage(page.getPageSize(), page.getStartIndex(), companyDefaultRate);
	page.setRecords(records);
	return page;
}

public List<CompanyDefaultRate> queryList(CompanyDefaultRate companyDefaultRate)throws Exception{
	List<CompanyDefaultRate> records = companyDefaultRateDAO.queryList(companyDefaultRate);
	return records;
}
}
