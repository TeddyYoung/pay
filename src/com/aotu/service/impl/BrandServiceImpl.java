package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.BrandDAO;
import com.aotu.entity.Brand;
import com.aotu.entity.Page;
import com.aotu.service.IBrandService;

/**
 * 系统用户 Service实现类
 * @author zhoujj
 */
@Service("brandService")
public class BrandServiceImpl implements IBrandService {

	@Autowired
	private BrandDAO brandDAO;
	
	/**
	 * 新增
	 * @param brand
	 * @throws Exception
	 */
	public void save(Brand brand) throws Exception {
		this.brandDAO.save(brand);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.brandDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param brand
	 * @throws Exception
	 */
	public void update(Brand brand) throws Exception {
		this.brandDAO.update(brand);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Brand get(String id) throws Exception {
		return (Brand)this.brandDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Brand brand) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = brandDAO.queryCount(brand);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<Brand> records = brandDAO.queryPage(page.getPageSize(), page.getStartIndex(), brand);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Brand> queryList(Brand brand) throws Exception {
		List<Brand> records = brandDAO.queryList(brand);
		return records;
	}

}
