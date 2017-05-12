package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.CashDAO;
import com.aotu.entity.Cash;
import com.aotu.entity.Order;
import com.aotu.entity.Page;
import com.aotu.service.ICashService;

/**
 * 提现申请 Service实现类
 * @author zhoujj
 */
@Service("cashService")
public class CashServiceImpl implements ICashService {

	@Autowired
	private CashDAO cashDAO;
	
	/**
	 * 新增
	 * @param cash
	 * @throws Exception
	 */
	public void save(Cash cash) throws Exception {
		this.cashDAO.save(cash);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.cashDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param cash
	 * @throws Exception
	 */
	public void update(Cash cash) throws Exception {
		this.cashDAO.update(cash);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Cash get(String id) throws Exception {
		return (Cash)this.cashDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Cash cash) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = cashDAO.queryCount(cash);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<Cash> records = cashDAO.queryPage(page.getPageSize(), page.getStartIndex(), cash);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Cash> queryList(Cash cash) throws Exception {
		List<Cash> records = cashDAO.queryList(cash);
		return records;
	}

}
