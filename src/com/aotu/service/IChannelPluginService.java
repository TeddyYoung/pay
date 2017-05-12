package com.aotu.service;

import java.util.List;

import com.aotu.entity.Area;
import com.aotu.entity.ChannelPlugin;
import com.aotu.entity.Page;

/**
 *通道配置 Service
 * @author zhoujj
 */
public interface IChannelPluginService {

	/**
	 * 新增
	 * @param channelPlugin
	 * @throws Exception
	 */
	public void save(ChannelPlugin channelPlugin) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param channelPlugin
	 * @throws Exception
	 */
	public void update(ChannelPlugin channelPlugin) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public ChannelPlugin get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, ChannelPlugin channelPlugin) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<ChannelPlugin> queryList(ChannelPlugin channelPlugin) throws Exception;
	
}
