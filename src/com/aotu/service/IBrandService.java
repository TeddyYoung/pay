package com.aotu.service;

import java.util.List;

import com.aotu.entity.Brand;
import com.aotu.entity.Page;
import com.aotu.entity.system.User;

/**
 * 系统用户 Service
 * @author zhoujj
 */
public interface IBrandService {

	/**
	 * 新增
	 * @param brand
	 * @throws Exception
	 */
	public void save(Brand brand) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param brand
	 * @throws Exception
	 */
	public void update(Brand brand) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Brand get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Brand brand) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Brand> queryList(Brand brand) throws Exception;
	
}
