package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.AreaDAO;
import com.aotu.entity.Area;
import com.aotu.entity.Page;
import com.aotu.service.IAreaService;

/**
 * 地区基础信息 Service实现类
 * @author zhoujj
 */
@Service("areaService")
public class AreaServiceImpl implements IAreaService {

	@Autowired
	private AreaDAO areaDAO;
	/**
	 * 新增
	 * @param area
	 * @throws Exception
	 */
	public void save(Area area) throws Exception {
		this.areaDAO.save(area);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.areaDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param area
	 * @throws Exception
	 */
	public void update(Area area) throws Exception {
		this.areaDAO.update(area);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Area get(String id) throws Exception {
		return (Area)this.areaDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Area area) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = areaDAO.queryCount(area);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<Area> records = areaDAO.queryPage(page.getPageSize(), page.getStartIndex(), area);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Area> queryList(Area area) throws Exception {
		List<Area> records = areaDAO.queryList(area);
		return records;
	}

}
