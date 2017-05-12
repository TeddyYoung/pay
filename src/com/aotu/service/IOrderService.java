package com.aotu.service;

import java.util.List;

import com.aotu.entity.Order;
import com.aotu.entity.Page;

/**
 * 订单信息 Service
 * @author Teddy
 */
public interface IOrderService {

	/**
	 * 新增
	 * @param order
	 * @throws Exception
	 */
	public void save(Order order) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param order
	 * @throws Exception
	 */
	public void update(Order order) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Order get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Order order) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Order> queryList(Order order) throws Exception;
	
}
