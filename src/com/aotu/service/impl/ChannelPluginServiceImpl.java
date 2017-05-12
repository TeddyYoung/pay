package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.ChannelPluginDAO;
import com.aotu.entity.ChannelPlugin;
import com.aotu.entity.Page;
import com.aotu.service.IChannelPluginService;

/**
 * 通道配置 Service实现类
 * @author zhoujj
 */
@Service("channelPluginService")
public class ChannelPluginServiceImpl implements IChannelPluginService {

	@Autowired
	private ChannelPluginDAO channelPluginDAO;
	/**
	 * 新增
	 * @param channelPlugin
	 * @throws Exception
	 */
	public void save(ChannelPlugin channelPlugin) throws Exception {
		this.channelPluginDAO.save(channelPlugin);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.channelPluginDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param channelPlugin
	 * @throws Exception
	 */
	public void update(ChannelPlugin channelPlugin) throws Exception {
		this.channelPluginDAO.update(channelPlugin);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public ChannelPlugin get(String id) throws Exception {
		return (ChannelPlugin)this.channelPluginDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, ChannelPlugin channelPlugin) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = channelPluginDAO.queryCount(channelPlugin);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<ChannelPlugin> records = channelPluginDAO.queryPage(page.getPageSize(), page.getStartIndex(), channelPlugin);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<ChannelPlugin> queryList(ChannelPlugin channelPlugin) throws Exception {
		List<ChannelPlugin> records = channelPluginDAO.queryList(channelPlugin);
		return records;
	}

}
