package com.aotu.service;

import java.util.List;

import com.aotu.entity.Area;
import com.aotu.entity.Order;
import com.aotu.entity.Page;

/**
 *地区基础信息 Service
 * @author zhoujj
 */
public interface IAreaService {

	/**
	 * 新增
	 * @param area
	 * @throws Exception
	 */
	public void save(Area area) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param area
	 * @throws Exception
	 */
	public void update(Area area) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Area get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Area area) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Area> queryList(Area area) throws Exception;
	
}
