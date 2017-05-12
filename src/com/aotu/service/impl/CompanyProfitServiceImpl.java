package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.CompanyProfitDAO;
import com.aotu.entity.CompanyProfit;
import com.aotu.entity.Page;
import com.aotu.service.ICompanyProfitService;

/**
 * 公司分润 Service实现类
 * @author zhoujj
 */
@Service("companyProfitService")
public class CompanyProfitServiceImpl implements ICompanyProfitService{
	@Autowired
	private CompanyProfitDAO companyProfitDAO;
	
public void save(CompanyProfit companyProfit)throws Exception{
	this.companyProfitDAO.save(companyProfit);
}
public void delete(String id)throws Exception{
	this.companyProfitDAO.delete(id);
}

public void update(CompanyProfit companyProfit)throws Exception{
	this.companyProfitDAO.update(companyProfit);
}

public CompanyProfit get(String id) throws Exception{
	return (CompanyProfit)this.companyProfitDAO.get(id);
}

public Page queryPage(Page page,CompanyProfit companyProfit)throws Exception{
	int totalRecordsNum = companyProfitDAO.queryCount(companyProfit);
	page.setTotalRecordsNum(totalRecordsNum);
	List<CompanyProfit> records = companyProfitDAO.queryPage(page.getPageSize(), page.getStartIndex(), companyProfit);
	page.setRecords(records);
	return page;
}

public List<CompanyProfit> queryList(CompanyProfit companyProfit)throws Exception{
	List<CompanyProfit> records = companyProfitDAO.queryList(companyProfit);
	return records;
}

}
