package com.aotu.service;

import java.util.List;

import com.aotu.entity.Channel;
import com.aotu.entity.Page;

/**
 *支付通道 Service
 * @author zhoujj
 */
public interface IChannelService {

	/**
	 * 新增
	 * @param channel
	 * @throws Exception
	 */
	public void save(Channel channel) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param channel
	 * @throws Exception
	 */
	public void update(Channel channel) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Channel get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Channel channel) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Channel> queryList(Channel channel) throws Exception;
	
}
