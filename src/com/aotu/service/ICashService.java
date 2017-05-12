package com.aotu.service;

import java.util.List;

import com.aotu.entity.Cash;
import com.aotu.entity.Page;

/**
 * 提现申请 Service
 * @author zhoujj
 */
public interface ICashService {

	/**
	 * 新增
	 * @param cash
	 * @throws Exception
	 */
	public void save(Cash cash) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param cash
	 * @throws Exception
	 */
	public void update(Cash cash) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Cash get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Cash cash) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Cash> queryList(Cash cash) throws Exception;
	
}
