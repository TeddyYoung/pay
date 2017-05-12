package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.BankDAO;
import com.aotu.entity.Bank;
import com.aotu.entity.Order;
import com.aotu.entity.Page;
import com.aotu.service.IBankService;

/**
 * 银行基础信息 Service实现类
 * @author zhoujj
 */
@Service("bankService")
public class BankServiceImpl implements IBankService {

	@Autowired
	private BankDAO bankDAO;
	
	/**
	 * 新增
	 * @param bank
	 * @throws Exception
	 */
	public void save(Bank bank) throws Exception {
		this.bankDAO.save(bank);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.bankDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param bank
	 * @throws Exception
	 */
	public void update(Bank bank) throws Exception {
		this.bankDAO.update(bank);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Bank get(String id) throws Exception {
		return (Bank)this.bankDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Bank bank) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = bankDAO.queryCount(bank);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<Bank> records = bankDAO.queryPage(page.getPageSize(), page.getStartIndex(), bank);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Bank> queryList(Bank bank) throws Exception {
		List<Bank> records = bankDAO.queryList(bank);
		return records;
	}

}
