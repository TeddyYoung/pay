package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.OrderDAO;
import com.aotu.entity.Order;
import com.aotu.entity.Page;
import com.aotu.service.IOrderService;

/**
 * 订单信息 Service实现类
 * @author Teddy
 */
@Service("orderService")
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderDAO orderDAO;
	
	/**
	 * 新增
	 * @param order
	 * @throws Exception
	 */
	public void save(Order order) throws Exception {
		this.orderDAO.save(order);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.orderDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param order
	 * @throws Exception
	 */
	public void update(Order order) throws Exception {
		this.orderDAO.update(order);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Order get(String id) throws Exception {
		return (Order)this.orderDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Order order) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = orderDAO.queryCount(order);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<Order> records = orderDAO.queryPage(page.getPageSize(), page.getStartIndex(), order);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Order> queryList(Order order) throws Exception {
		List<Order> records = orderDAO.queryList(order);
		return records;
	}

}
